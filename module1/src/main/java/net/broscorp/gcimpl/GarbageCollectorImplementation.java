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
    for (ApplicationBean a : beans) {
      int ptrs = 0;
      for (ApplicationBean d : beans) {
        if (a == d) {
          ptrs++;
        }
      }
      for (StackInfo.Frame b : frames) {
        for (ApplicationBean c : b.getParameters()) {
          if (a == c) {
            ptrs++;
            alive.addAll(getChildren(a));
          }
        }
      }
      if (ptrs < 2) {
        garbage.addAll(getChildren(a));
        garbage = garbage.stream().distinct().collect(Collectors.toList());
      }
    }

    garbage.removeAll(alive);

    return garbage;
  }

  private List<ApplicationBean> getChildren(ApplicationBean bean) {
    List<ApplicationBean> garbage = new ArrayList<>();
    garbage.add(bean);
    bean.getFieldValues()
        .forEach(
            (key, value) -> {
              if (value != bean && !(value.getFieldValues().containsValue(bean))) {
                garbage.addAll(getChildren(value));
              }
            });

    return garbage;
  }
}
