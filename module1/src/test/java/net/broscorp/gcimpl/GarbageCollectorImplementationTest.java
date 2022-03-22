package net.broscorp.gcimpl;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;

class GarbageCollectorImplementationTest {

  private final GarbageCollector gc = new GarbageCollectorImplementation();

  @Test
  public void unlinkedObjectsCollectionTest() {
    // GIVEN

    final ApplicationBean restControllerBean = initializeControllerBean();
    final ApplicationBean requestBean = initializeHttpRequestBeanBean();

    Map<String, ApplicationBean> heap = new HashMap<>();
    heap.putAll(getMemoryFootprint("controller", restControllerBean));
    heap.putAll(getMemoryFootprint("request", requestBean));
    List<ApplicationBean> expectedGarbage = new ArrayList<>(getChildren(requestBean));
    System.out.println("expectedGarbage = " + expectedGarbage);
    final HeapInfo heapInfo = new HeapInfo(heap);
    StackInfo stack = new StackInfo();
    stack.push("main");
    stack.push("handleRequest", restControllerBean);
    // WHEN
    final List<ApplicationBean> actualGarbage = gc.collect(heapInfo, stack);

    // THEN
    assertEquals(expectedGarbage.size(), actualGarbage.size());
    assertTrue(actualGarbage.containsAll(expectedGarbage));
  }

  @Test
  public void boundedSubChildCollectionTest() {
    // GIVEN
    List<ApplicationBean> expectedGarbage = new ArrayList<>();

    final ApplicationBean restControllerBean = initializeControllerBean();
    final ApplicationBean requestBean = initializeHttpRequestBeanBean();

    restControllerBean.addRelation("requestBody", requestBean.getChildBean("body"));
    expectedGarbage.add(requestBean);
    expectedGarbage.add(requestBean.getChildBean("headers"));

    Map<String, ApplicationBean> heap = new HashMap<>();
    heap.putAll(getMemoryFootprint("request", requestBean));
    heap.putAll(getMemoryFootprint("controller", restControllerBean));

    final HeapInfo heapInfo = new HeapInfo(heap);
    StackInfo stack = new StackInfo();
    stack.push("main");
    stack.push("handleRequest", restControllerBean);

    // WHEN
    final List<ApplicationBean> actualGarbage = gc.collect(heapInfo, stack);

    // THEN
    assertEquals(expectedGarbage.size(), actualGarbage.size());
    assertTrue(actualGarbage.containsAll(expectedGarbage));
  }

  @Test
  public void multiRootCollectionTest() {
    // WHEN
    Map<String, ApplicationBean> heap = new HashMap<>();

    final ApplicationBean serviceBean = initializeServiceBean();
    final ApplicationBean repositoryBean = initializeRepositoryBean();
    final ApplicationBean domainModelBean = initializeDomainModelBean();

    heap.putAll(getMemoryFootprint("model", domainModelBean));
    heap.putAll(getMemoryFootprint("service", serviceBean));
    heap.putAll(getMemoryFootprint("repository", repositoryBean));

    final HeapInfo heapInfo = new HeapInfo(heap);
    StackInfo stack = new StackInfo();
    stack.push("main");
    stack.push("handleRequest", initializeControllerBean());
    stack.push("login", serviceBean);
    stack.push("findUserByLogin", repositoryBean);

    List<ApplicationBean> expectedGarbage = new ArrayList<>(getChildren(domainModelBean));

    // WHEN
    final List<ApplicationBean> actualGarbage = gc.collect(heapInfo, stack);

    // THEN
    assertEquals(expectedGarbage.size(), actualGarbage.size());
    assertTrue(actualGarbage.containsAll(expectedGarbage));
  }

  @Test
  public void crossRootCollectionTest() {
    // WHEN
    List<ApplicationBean> expectedGarbage = new ArrayList<>();

    final ApplicationBean controllerBean = initializeControllerBean();
    final ApplicationBean serviceBean = initializeServiceBean();

    final ApplicationBean requestBean = initializeHttpRequestBeanBean();
    controllerBean.addRelation("headers", requestBean.getChildBean("headers"));
    serviceBean.addRelation("body", requestBean.getChildBean("body"));

    expectedGarbage.add(requestBean);

    Map<String, ApplicationBean> heap = new HashMap<>();
    heap.putAll(getMemoryFootprint("controller", controllerBean));
    heap.putAll(getMemoryFootprint("service", serviceBean));
    heap.putAll(getMemoryFootprint("request", requestBean));

    final HeapInfo heapInfo = new HeapInfo(heap);
    StackInfo stack = new StackInfo();
    stack.push("main");
    stack.push("handleRequest", controllerBean);
    stack.push("login", serviceBean);

    // WHEN
    final List<ApplicationBean> actualGarbage = gc.collect(heapInfo, stack);

    // THEN
    assertEquals(expectedGarbage.size(), actualGarbage.size());
    assertTrue(actualGarbage.containsAll(expectedGarbage));
  }

  @Test
  public void circularDependencyTest1() {
    // GIVEN
    ApplicationBean service = new ApplicationBean();
    service.addRelation("self", service);

    Map<String, ApplicationBean> heap = new HashMap<>();
    heap.put("service", service);

    final HeapInfo heapInfo = new HeapInfo(heap);
    StackInfo stack = new StackInfo();
    stack.push("main");
    stack.push("foo", service);

    // WHEN
    final List<ApplicationBean> actualGarbage = gc.collect(heapInfo, stack);

    // THEN
    assertTrue(actualGarbage.isEmpty());
  }

  @Test
  public void circularDependencyTest2() {
    // GIVEN
    final ApplicationBean restControllerBean = initializeControllerBean();
    ApplicationBean serviceA = new ApplicationBean();
    ApplicationBean serviceB = new ApplicationBean();
    serviceA.addRelation("serviceB", serviceB);
    serviceB.addRelation("serviceA", serviceA);

    Map<String, ApplicationBean> heap =
        new HashMap<>(getMemoryFootprint("controller", restControllerBean));
    heap.put("serviceA", serviceA);
    heap.put("serviceB", serviceB);

    final HeapInfo heapInfo = new HeapInfo(heap);
    StackInfo stack = new StackInfo();
    stack.push("main");
    stack.push("handleRequest", restControllerBean);
    stack.push("foo", serviceA);
    stack.push("bar", serviceB);
    stack.push("baz", serviceA);
    stack.pop(); // baz finished
    stack.pop(); // bar finished
    stack.pop(); // foo finished
    List<ApplicationBean> expectedGarbage = new ArrayList<>();
    expectedGarbage.add(serviceA);
    expectedGarbage.add(serviceB);
    // WHEN
    final List<ApplicationBean> actualGarbage = gc.collect(heapInfo, stack);

    // THEN
    assertEquals(expectedGarbage.size(), actualGarbage.size());
    assertTrue(actualGarbage.containsAll(expectedGarbage));
  }

  private ApplicationBean initializeControllerBean() {
    final ApplicationBean restControllerBean = new ApplicationBean();
    restControllerBean.addRelation("path", new ApplicationBean());
    restControllerBean.addRelation("requestValidator", new ApplicationBean());
    ApplicationBean service = new ApplicationBean();
    service.addRelation("repository", new ApplicationBean());
    restControllerBean.addRelation("applicationService", service);

    return restControllerBean;
  }

  private ApplicationBean initializeHttpRequestBeanBean() {
    final ApplicationBean requestBean = new ApplicationBean();
    final ApplicationBean headers = new ApplicationBean();
    final ApplicationBean body = new ApplicationBean();
    requestBean.addRelation("headers", headers);
    requestBean.addRelation("body", body);

    return requestBean;
  }

  private ApplicationBean initializeServiceBean() {
    return new ApplicationBean();
  }

  private ApplicationBean initializeDomainModelBean() {
    final ApplicationBean domainModel = new ApplicationBean();
    final ApplicationBean modelId = new ApplicationBean();
    final ApplicationBean modelName = new ApplicationBean();
    final ApplicationBean modelEmail = new ApplicationBean();
    domainModel.addRelation("id", modelId);
    domainModel.addRelation("name", modelName);
    domainModel.addRelation("email", modelEmail);

    return domainModel;
  }

  private ApplicationBean initializeRepositoryBean() {
    final ApplicationBean repository = new ApplicationBean();
    final ApplicationBean entityManager = new ApplicationBean();
    repository.addRelation("entityManager", entityManager);

    return repository;
  }

  private Map<String, ApplicationBean> getMemoryFootprint(String beanName, ApplicationBean bean) {
    Map<String, ApplicationBean> heap = new HashMap<>();
    heap.put(beanName, bean);

    final Map<String, ApplicationBean> childRelations = bean.getFieldValues();
    if (childRelations.isEmpty()) {
      return heap;
    }

    bean.getFieldValues().forEach((key, value) -> heap.putAll(getMemoryFootprint(key, value)));

    return heap;
  }

  private List<ApplicationBean> getChildren(ApplicationBean bean) {
    List<ApplicationBean> garbage = new ArrayList<>();
    garbage.add(bean);
    bean.getFieldValues()
        .forEach(
            (key, value) -> {
              garbage.addAll(getChildren(value));
            });

    return garbage;
  }
}
