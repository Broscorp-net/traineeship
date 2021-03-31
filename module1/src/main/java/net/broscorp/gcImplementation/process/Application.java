package net.broscorp.gcImplementation.process;

import static net.broscorp.gcImplementation.model.BeanType.CHILD;
import static net.broscorp.gcImplementation.model.BeanType.ROOT;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import net.broscorp.gcImplementation.model.ApplicationBean;
import net.broscorp.gcImplementation.model.HeapInfo;

public class Application {

  public HeapInfo getSimpleHeapSnapshot() {
    Map<String, ApplicationBean> heap = new HashMap<>();

    final ApplicationBean restControllerBean = initializeControllerBean();
    final ApplicationBean requestBean = initializeHttpRequestBeanBean();

    heap.putAll(getMemoryFootprint("controller", restControllerBean));
    heap.putAll(getMemoryFootprint("request", requestBean));
    List<ApplicationBean> expectedGarbage = new ArrayList<>(convertToGarbage(requestBean));

    return new HeapInfo(heap, expectedGarbage);
  }

  public HeapInfo getBoundedChildHeapSnapshot() {
    Map<String, ApplicationBean> heap = new HashMap<>();
    List<ApplicationBean> expectedGarbage = new ArrayList<>();

    final ApplicationBean restControllerBean = initializeControllerBean();
    final ApplicationBean requestBean = initializeHttpRequestBeanBean();

    restControllerBean.addRelation("requestBody", requestBean.getChildBean("body"));
    expectedGarbage.add(requestBean);
    expectedGarbage.add(requestBean.getChildBean("headers"));

    heap.putAll(getMemoryFootprint("request", requestBean));
    heap.putAll(getMemoryFootprint("controller", restControllerBean));

    return new HeapInfo(heap, expectedGarbage);
  }

  public HeapInfo getMultiRootHeapSnapshot() {
    Map<String, ApplicationBean> heap = new HashMap<>();

    final ApplicationBean serviceBean = initializeServiceBean();
    final ApplicationBean repositoryBean = initializeRepositoryBean();
    final ApplicationBean domainModelBean = initializeDomainModelBean();

    heap.putAll(getMemoryFootprint("model", domainModelBean));
    heap.putAll(getMemoryFootprint("service", serviceBean));
    heap.putAll(getMemoryFootprint("repository", repositoryBean));
    List<ApplicationBean> expectedGarbage = new ArrayList<>(convertToGarbage(domainModelBean));

    return new HeapInfo(heap, expectedGarbage);
  }

  public HeapInfo getCrossRootBoundedHeapSnapShot() {
    Map<String, ApplicationBean> heap = new HashMap<>();
    List<ApplicationBean> expectedGarbage = new ArrayList<>();

    final ApplicationBean controllerBean = initializeControllerBean();
    final ApplicationBean serviceBean = initializeServiceBean();

    final ApplicationBean requestBean = initializeHttpRequestBeanBean();
    controllerBean.addRelation("headers", requestBean.getChildBean("headers"));
    serviceBean.addRelation("body", requestBean.getChildBean("body"));

    expectedGarbage.add(requestBean);

    heap.putAll(getMemoryFootprint("controller", controllerBean));
    heap.putAll(getMemoryFootprint("service", serviceBean));
    heap.putAll(getMemoryFootprint("request", requestBean));

    return new HeapInfo(heap, expectedGarbage);
  }

  private ApplicationBean initializeControllerBean() {
    final ApplicationBean restControllerBean = new ApplicationBean(ROOT);
    restControllerBean.addRelation("path", new ApplicationBean(CHILD));
    restControllerBean.addRelation("requestValidator", new ApplicationBean(CHILD));
    restControllerBean.addRelation("applicationService", new ApplicationBean(CHILD));

    return restControllerBean;
  }

  private ApplicationBean initializeHttpRequestBeanBean() {
    final ApplicationBean requestBean = new ApplicationBean(CHILD);
    final ApplicationBean headers = new ApplicationBean(CHILD);
    final ApplicationBean body = new ApplicationBean(CHILD);
    requestBean.addRelation("headers", headers);
    requestBean.addRelation("body", body);

    return requestBean;
  }

  private ApplicationBean initializeServiceBean() {
    return new ApplicationBean(ROOT);
  }

  private ApplicationBean initializeDomainModelBean() {
    final ApplicationBean domainModel = new ApplicationBean(CHILD);
    final ApplicationBean modelId = new ApplicationBean(CHILD);
    final ApplicationBean modelName = new ApplicationBean(CHILD);
    final ApplicationBean modelEmail = new ApplicationBean(CHILD);
    domainModel.addRelation("id", modelId);
    domainModel.addRelation("name", modelName);
    domainModel.addRelation("email", modelEmail);

    return domainModel;
  }

  private ApplicationBean initializeRepositoryBean() {
    final ApplicationBean repository = new ApplicationBean(ROOT);
    final ApplicationBean entityManager = new ApplicationBean(CHILD);
    repository.addRelation("entityManager", entityManager);

    return repository;
  }

  private Map<String, ApplicationBean> getMemoryFootprint(String beanName, ApplicationBean bean) {
    Map<String, ApplicationBean> heap = new HashMap<>();
    heap.put(beanName, bean);

    final Map<String, ApplicationBean> childRelations = bean.getChildRelations();
    if (childRelations.isEmpty()) {
      return heap;
    }

    bean.getChildRelations().forEach((key, value) -> {
      heap.putAll(getMemoryFootprint(key, value));
    });

    return heap;
  }

  private List<ApplicationBean> convertToGarbage(ApplicationBean bean) {
    List<ApplicationBean> garbage = new ArrayList<>();
    garbage.add(bean);
    bean.getChildRelations().forEach((key, value) -> {
      garbage.addAll(convertToGarbage(value));
    });

    return garbage;
  }
}
