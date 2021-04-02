package net.broscorp.gcImplementation.gc;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;
import net.broscorp.gcImplementation.model.ApplicationBean;
import net.broscorp.gcImplementation.model.BeanType;

public class GarbageCollectorImplementation implements GarbageCollector {

  @Override
  public List<ApplicationBean> collect(Map<String, ApplicationBean> heap) {
    return findUnreachableNodes(heap);
  }

  private List<ApplicationBean> findUnreachableNodes(Map<String, ApplicationBean> heap) {

    List<ApplicationBean> rootApplicationBeans = heap.values().stream()
        .filter(bean -> bean.getBeanType() == BeanType.ROOT)
        .collect(Collectors.toList());

    List<ApplicationBean> liveApplicationBeans = new ArrayList<>(rootApplicationBeans);

    rootApplicationBeans
        .forEach(root -> liveApplicationBeans.addAll(identifyLiveRelations(root)));

    return heap.values().stream()
        .filter(node -> !liveApplicationBeans.contains(node))
        .collect(Collectors.toList());
  }

  private List<ApplicationBean> identifyLiveRelations(ApplicationBean root) {
    List<ApplicationBean> surviveApplicationBeans = new ArrayList<>();
    final Collection<ApplicationBean> relations = root.getChildRelations().values();

    if (!relations.isEmpty()) {
      surviveApplicationBeans.addAll(relations);
      relations
          .forEach(relation -> surviveApplicationBeans.addAll(identifyLiveRelations(relation)));
    }

    return surviveApplicationBeans;
  }
}
