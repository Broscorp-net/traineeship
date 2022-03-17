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

    List<ApplicationBean> garbage = new ArrayList<>();

    for (ApplicationBean bean : beans) {
      System.out.println("bean = " + bean);
      System.out.println("bean.getFieldValues() = " + bean.getFieldValues());
      System.out.println("bean.getFieldValues() = " + bean.getFieldValues().values());
    }

    for (Frame frame : frames) {
      System.out.println("frame = " + frame);
      for (ApplicationBean parameter : frame.getParameters()) {
        System.out.println("parameter = " + parameter);
        System.out.println(
            "parameter.getFieldValues().values() = " + parameter.getFieldValues().values());
      }
    }

    for (ApplicationBean bean : beans) {
      boolean parrentFounded = false;
      if (!bean.getFieldValues().isEmpty()) {
        for (Frame frame : frames) {
          for (ApplicationBean parameter : frame.getParameters()) {
            if (bean.equals(parameter)) {
              parrentFounded = true;
              break;
            }
          }
          if (parrentFounded) {
            break;
          }
        }
        if (!parrentFounded) {
          garbage.add(bean);
          for (ApplicationBean value : bean.getFieldValues().values()) {
            boolean childrenFounded = false;
            for (Frame frame : frames) {
              for (ApplicationBean parameter : frame.getParameters()) {
                for (ApplicationBean applicationBean : parameter.getFieldValues().values()) {
                  if (value.equals(applicationBean)) {
                    childrenFounded = true;
                    break;
                  }
                  if (childrenFounded) {
                    break;
                  }
                }
                if (childrenFounded) {
                  break;
                }
              }
              if (childrenFounded) {
                break;
              }
            }
            if (!childrenFounded) {
              garbage.add(value);
            }
          }
        }
      }
    }
    System.out.println("garbage = " + garbage);
    return garbage.stream().distinct().collect(Collectors.toList());
  }
}
