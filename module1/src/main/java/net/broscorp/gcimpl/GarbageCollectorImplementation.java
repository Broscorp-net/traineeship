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

    //Collecting all Application Beans
    garbage = beans.stream().distinct().collect(Collectors.toList());

    //Taking object references from stack
    for (StackInfo.Frame b : frames) {
      for (ApplicationBean c : b.getParameters()) {
        //When object reference is found - we have to find everything that's referenced
        //inside of this object
        alive.addAll(getChildren(c, new ArrayList<ApplicationBean>()));
      }
    }

    //Removing objects that are referenced inside of Stack from garbage pile
    garbage.removeAll(alive);

    return garbage;
  }

  /** getChildren() is responsible for collection of all inner ApplicationBeans.
   * @param bean     accepts the root of your search
   * @param distinct collects distinct object references
   * @return List of all objects referenced inside of bean.
   */
  private List<ApplicationBean> getChildren(ApplicationBean bean,
      ArrayList<ApplicationBean> distinct) {
    List<ApplicationBean> children = new ArrayList<>();
    children.add(bean);
    bean.getFieldValues()
        .forEach(
            (key, value) -> {
              if (!(distinct.contains(value))) {
                distinct.add(value);
                children.addAll(getChildren(value, distinct));
              }
            });
    return children;
  }
}
