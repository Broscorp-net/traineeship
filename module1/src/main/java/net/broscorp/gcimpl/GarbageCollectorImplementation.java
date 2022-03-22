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
      boolean parrentFinded = false;
      if (!bean.getFieldValues().isEmpty()) {
        for (Frame frame : frames) {
          for (ApplicationBean parameter : frame.getParameters()) {
            if (bean.equals(parameter)) {
              parrentFinded = true;
              break;
            }
          }
          if (parrentFinded) {
            break;
          }
        }
        if (!parrentFinded) {
          garbage.add(bean);
          for (ApplicationBean value : bean.getFieldValues().values()) {
            boolean childrenFinded = false;
            for (Frame frame : frames) {
              for (ApplicationBean parameter : frame.getParameters()) {
                for (ApplicationBean applicationBean : parameter.getFieldValues().values()) {
                  if (value.equals(applicationBean)) {
                    childrenFinded = true;
                    break;
                  }
                }
                if (childrenFinded) {
                  break;
                }
              }
              if (childrenFinded) {
                break;
              }
            }
            if (!childrenFinded) {
              garbage.add(value);
            }
          }
        }
      }
    }
//    garbage.addAll(findGarbageFrames(beans, frames));
    System.out.println("garbage = " + garbage);
    return garbage.stream().distinct().collect(Collectors.toList());
  }

//  private List<ApplicationBean> findGarbageFrames(Collection<ApplicationBean> beans, Deque<StackInfo.Frame> frames) {
//    List<ApplicationBean> garbage = new ArrayList<>();
//    for (ApplicationBean bean : beans) {
//      a:
//      {
//        if (!bean.getFieldValues().isEmpty()) {
//          for (Frame frame : frames) {
//            for (ApplicationBean parameter : frame.getParameters()) {
//              if (bean.equals(parameter)) {
//                break a;
//              }
//            }
//          }
//          garbage.add(bean);
//        }
//      }
//    }
//    findGarbageBeans(beans, frames, garbage);
//    return garbage;
//  }
//
//  private List<ApplicationBean> findGarbageBeans(Collection<ApplicationBean> beans, Deque<StackInfo.Frame> frames, List<ApplicationBean> framesGarbage) {
//    List<ApplicationBean> garbage = new ArrayList<>(beans);
//
//    for (ApplicationBean bean : beans) {
//      for (ApplicationBean value : bean.getFieldValues().values()) {
//        a:
//        {
//          for (Frame frame : frames) {
//            for (ApplicationBean parameter : frame.getParameters()) {
//              for (ApplicationBean applicationBean : parameter.getFieldValues().values()) {
//                if (value.equals(applicationBean)) {
//                  break a;
//                }
//              }
//            }
//          }
//          garbage.add(value);
//        }
//      }
//    }
//    return garbage;
//  }
}
