package net.broscorp.gcimpl;

import java.util.Collection;
import java.util.Deque;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

public class GarbageCollectorImplementation implements GarbageCollector {
  @Override
  public List<ApplicationBean> collect(HeapInfo heap, StackInfo stack) {
    Collection<ApplicationBean> beans = heap.getBeans().values();
    Deque<StackInfo.Frame> frames = stack.getStack();

    Set<ApplicationBean> garbage = new HashSet<>(beans);//сет для фильтрации бинов

    //проходимся по всем фреймам и бинам
    for (StackInfo.Frame frame : frames) {
      for (ApplicationBean frameBean : frame.getParameters()) {
        //рекурсивно убираем живые бины и их наследников
        removeReachable(frameBean, garbage);
      }
    }

    //возвращаем мусор
    return garbage.stream().collect(Collectors.toList());
  }

  private void removeReachable(ApplicationBean bean, Set<ApplicationBean> beanSet) {
    beanSet.remove(bean);
    for (ApplicationBean subBean : bean.getFieldValues().values()) {
      if (beanSet.isEmpty()) {
        break;
      } else {
        removeReachable(subBean, beanSet);
      }
    }
  }
}
