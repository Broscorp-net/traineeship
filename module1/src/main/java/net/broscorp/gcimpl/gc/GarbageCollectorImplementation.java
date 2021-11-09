package net.broscorp.gcimpl.gc;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Deque;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import net.broscorp.gcimpl.model.ApplicationBean;
import net.broscorp.gcimpl.model.HeapInfo;
import net.broscorp.gcimpl.model.StackInfo;

public class GarbageCollectorImplementation implements GarbageCollector {

  @Override
  public List<ApplicationBean> collect(HeapInfo heap, StackInfo stack) {
    return findUnreachableNodes(heap.getBeans(), stack.getStack());
  }

  private List<ApplicationBean> findUnreachableNodes(
      Map<String, ApplicationBean> heap, Deque<StackInfo.Frame> stack) {
    List<ApplicationBean> rootBeans =
        stack.stream().flatMap(f -> f.getParameters().stream()).collect(Collectors.toList());
    List<ApplicationBean> reachableBeans =
        rootBeans.stream().flatMap(this::identifyLiveRelations).collect(Collectors.toList());

    ArrayList<ApplicationBean> allBeans = new ArrayList<>(heap.values());
    allBeans.removeAll(rootBeans);
    allBeans.removeAll(reachableBeans);
    return allBeans;
  }

  private Stream<ApplicationBean> identifyLiveRelations(ApplicationBean root) {
    Collection<ApplicationBean> relations = root.getFieldValues().values();
    return Stream.concat(
        relations.stream().filter(r -> !relations.contains(r)).flatMap(this::identifyLiveRelations),
        relations.stream());
  }
}
