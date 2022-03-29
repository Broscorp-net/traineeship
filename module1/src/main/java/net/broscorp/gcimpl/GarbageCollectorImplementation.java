package net.broscorp.gcimpl;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.Deque;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class GarbageCollectorImplementation implements GarbageCollector {

  @Override
  public List<ApplicationBean> collect(HeapInfo heap, StackInfo stack) {
    Collection<ApplicationBean> beans = heap.getBeans().values();
    Deque<StackInfo.Frame> frames = stack.getStack();

    ArrayList<ApplicationBean> alive = new ArrayList<>();
    List<ApplicationBean> garbage = new ArrayList<>();

    garbage = beans.stream().distinct().collect(Collectors.toList());

    for (StackInfo.Frame b : frames) {
      for (ApplicationBean c : b.getParameters()) {
        alive.addAll(getChildren(c, new ArrayList<ApplicationBean>()));
      }
    }

    garbage = garbage.stream().filter(entry -> !(alive.contains(entry)))
        .collect(Collectors.toList());

    return garbage;
  }

  private List<ApplicationBean> getChildren(ApplicationBean bean,
      ArrayList<ApplicationBean> distinctions) {
    List<ApplicationBean> garbage = new ArrayList<>();
    garbage.add(bean);
    bean.getFieldValues()
        .forEach(
            (key, value) -> {
              if (!(distinctions.contains(value))) {
                distinctions.add(value);
                garbage.addAll(getChildren(value, distinctions));
              }
            });

    return garbage;
  }
}
