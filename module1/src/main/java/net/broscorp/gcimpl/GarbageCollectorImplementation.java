package net.broscorp.gcimpl;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Deque;
import java.util.List;

public class GarbageCollectorImplementation implements GarbageCollector {

  @Override
  public List<ApplicationBean> collect(HeapInfo heap, StackInfo stack) {
    Collection<ApplicationBean> beans = heap.getBeans().values();
    Deque<StackInfo.Frame> frames = stack.getStack();
    List<ApplicationBean> result = new ArrayList<>();

    for (ApplicationBean bean : beans) {
      if (!isReachable(frames, bean)) {
        result.add(bean);
      }
    }
    return result;
  }

  private boolean isReachable(Deque<StackInfo.Frame> frames, ApplicationBean bean) {
    for (StackInfo.Frame frame : frames) {
      List<ApplicationBean> rootBeans = frame.getParameters();
      if (isReachableUtil(rootBeans, bean)) {
        return true;
      }
    }
    return false;
  }

  private boolean isReachableUtil(Collection<ApplicationBean> rootBeans, ApplicationBean bean) {
    if (rootBeans.contains(bean)) {
      return true;
    }
    for (ApplicationBean beanFromFrame : rootBeans) {
      Collection<ApplicationBean> childBeans = beanFromFrame.getFieldValues().values();
      if (isReachableUtil(childBeans, bean)) {
        return true;
      }
    }
    return false;
  }
}
