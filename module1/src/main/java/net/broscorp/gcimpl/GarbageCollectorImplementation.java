package net.broscorp.gcimpl;

import java.util.Collection;
import java.util.Collections;
import java.util.Deque;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

public class GarbageCollectorImplementation implements GarbageCollector {

  @Override
  public List<ApplicationBean> collect(HeapInfo heap, StackInfo stack) {
    Collection<ApplicationBean> beans = heap.getBeans().values();
    Deque<StackInfo.Frame> frames = stack.getStack();

    List<ApplicationBean> markedForDeletion = new LinkedList<>();

    // go over beans, if not referenced by any stack entries - should be marked for deletion
    for (ApplicationBean bean : beans) {
      boolean isReferenced = false;
      for (StackInfo.Frame frame : frames) {
        if (frame.getParameters().contains(bean)) {
          isReferenced = true;
          break;
        }
      }
      if (!isReferenced) {
        markedForDeletion.add(bean);
      }
    }
    return markedForDeletion;
  }
}
