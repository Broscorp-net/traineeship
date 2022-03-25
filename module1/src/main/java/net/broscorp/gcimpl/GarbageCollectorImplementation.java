package net.broscorp.gcimpl;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.Deque;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;

public class GarbageCollectorImplementation implements GarbageCollector {

  @Override
  public List<ApplicationBean> collect(HeapInfo heap, StackInfo stack) {
    Deque<StackInfo.Frame> frames = stack.getStack();
    List<ApplicationBean> aliveBeans = new ArrayList<>();
    frames.stream().forEach(i -> aliveBeans.addAll(i.getParameters()));
    List<ApplicationBean> aliveBeansWithCildren = new ArrayList<>();
    aliveBeansWithCildren.addAll(aliveBeans);
    aliveBeans.forEach(a -> aliveBeansWithCildren.addAll(a.getFieldValues().values()));
    Collection<ApplicationBean> beans = heap.getBeans().values();
    beans.removeAll(aliveBeansWithCildren);
    return  beans.stream().collect(Collectors.toList());
  }
}
