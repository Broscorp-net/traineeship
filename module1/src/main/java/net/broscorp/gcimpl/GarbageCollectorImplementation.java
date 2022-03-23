package net.broscorp.gcimpl;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Deque;
import java.util.List;
import net.broscorp.gcimpl.StackInfo.Frame;

public class GarbageCollectorImplementation implements GarbageCollector {

  @Override
  public List<ApplicationBean> collect(HeapInfo heap, StackInfo stack) {
    Collection<ApplicationBean> beans = heap.getBeans().values();
    Deque<StackInfo.Frame> frames = stack.getStack();

    List<ApplicationBean> garbage = new ArrayList<>(beans);
    garbage.removeAll(findStackedFrames(frames));
    return garbage;
  }

  private List<ApplicationBean> findStackedFrames(Deque<StackInfo.Frame> frames) {
    List<ApplicationBean> stackedBeans = new ArrayList<>();
    for (Frame frame : frames) {
      stackedBeans.addAll(frame.getParameters());
      for (ApplicationBean parameter : frame.getParameters()) {
        addDependencies(parameter, stackedBeans);
      }
    }
    return stackedBeans;
  }

  private void addDependencies(ApplicationBean bean, List<ApplicationBean> stackedBeans) {
    stackedBeans.addAll(bean.getFieldValues().values());
    for (ApplicationBean innerBean : bean.getFieldValues().values()) {
      if (!stackedBeans.containsAll(innerBean.getFieldValues().values())) {
        addDependencies(innerBean, stackedBeans);
      }
    }
  }
}
