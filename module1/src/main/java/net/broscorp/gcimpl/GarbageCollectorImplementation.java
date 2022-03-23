package net.broscorp.gcimpl;

import java.util.Collection;
import java.util.Deque;
import java.util.LinkedList;
import java.util.List;

public class GarbageCollectorImplementation implements GarbageCollector {
  List<ApplicationBean> candidatesForRemoval;

  /**
   * The principle of operation:
   * 1. Creating a list of candidates to remove from the heap
   * 2. I go through the chain of links in StackInfo.
   * 3. Now I'm checking for a link in the list of candidates for removal.
   * 4. If it is present, then the object is reachable and it is removed from
   * the list of candidates for removal.
   */
  @Override
  public List<ApplicationBean> collect(HeapInfo heap, StackInfo stack) {
    Collection<ApplicationBean> beans = heap.getBeans().values();
    Deque<StackInfo.Frame> frames = stack.getStack();
    candidatesForRemoval = new LinkedList<>(beans);

    for (StackInfo.Frame frame : frames) {
      for (ApplicationBean beanFromFrame : frame.getParameters()) {
        isReachable(beanFromFrame);
      }
    }

    return candidatesForRemoval;
  }

  private void isReachable(ApplicationBean bean) {
    while (candidatesForRemoval.remove(bean)) {
      // Here is an empty loop body to remove duplicate objects from the delete list.
    }
    for (ApplicationBean childBean : bean.getFieldValues().values()) {
      if (candidatesForRemoval.size() == 0) {
        break;
      }
      isReachable(childBean);
    }
  }

}
