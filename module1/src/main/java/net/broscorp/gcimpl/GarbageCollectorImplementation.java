package net.broscorp.gcimpl;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Deque;
import java.util.List;
import java.util.stream.Collectors;
import net.broscorp.gcimpl.StackInfo.Frame;

public class GarbageCollectorImplementation implements GarbageCollector {

  @Override
  public List<ApplicationBean> collect(HeapInfo heap, StackInfo stack) {

    Collection<ApplicationBean> beans = heap.getBeans().values();
    Deque<StackInfo.Frame> frames = stack.getStack();
    ArrayList<ApplicationBean> bin = new ArrayList<>();
    Boolean childPresence = false;
    Boolean parentPresence = false;

    for (ApplicationBean bean : beans) {
      if (!bean.getFieldValues().isEmpty()) {

        for (Frame frame : frames) {
          parentPresence = containsAppBeanParams(frame.getParameters(), bean);

          if (parentPresence) {
            break;
          }
        }

        if (!parentPresence) {
          bin.add(bean);
          for (ApplicationBean appBean : bean.getFieldValues().values()) {
            for (Frame frame : frames) {

              for (ApplicationBean parameter : frame.getParameters()) {
                childPresence = containsAppBeanParams(parameter.getFieldValues().values(), appBean);

                if (childPresence) {
                  break;
                }
              }

              if (childPresence) {
                break;
              }
            }
            if (!childPresence) {
              bin.add(appBean);
            }
          }
        }
      }
    }
    return bin.stream().distinct()
        .collect(Collectors.toCollection(ArrayList::new));
  }

  private boolean containsAppBeanParams(Collection<ApplicationBean> frameParams,
      ApplicationBean bean) {
    for (ApplicationBean parameter : frameParams) {

      if (bean.equals(parameter)) {
        return true;
      }
    }
    return false;
  }


}
