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
        List<ApplicationBean> frameParams = frame.getParameters();
        if (checkReferenced(bean, frameParams)) {
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

  boolean checkReferenced(ApplicationBean checkedBean, Collection<ApplicationBean> frameParams) {

    if (frameParams.contains(checkedBean)) {
      return true;
    }

    // recursively check if checkedBean is present in the list or its children (fields)
    for (ApplicationBean frameParamBean : frameParams) {

      Collection<ApplicationBean> fieldsValues =
          (Collection<ApplicationBean>)frameParamBean.getFieldValues().values();
      if (checkReferenced(checkedBean, fieldsValues)) {
        return true;
      }
    }

    return false;
  }
}
