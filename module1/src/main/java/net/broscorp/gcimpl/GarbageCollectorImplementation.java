package net.broscorp.gcimpl;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.Deque;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;

public class GarbageCollectorImplementation implements GarbageCollector {

  @Override
  public List<ApplicationBean> collect(HeapInfo heap, StackInfo stack) {
    Deque<StackInfo.Frame> frames = stack.getStack();
    Set<ApplicationBean> aliveBeans = new HashSet<>();
    //получили ссылки живых со стека
    frames.stream().forEach(i -> aliveBeans.addAll(i.getParameters()));
    Set<ApplicationBean> aliveBeansWithCildren = new HashSet<>();
    //получили ссылки у живых и добавили в наследников
    aliveBeans.forEach(a -> aliveBeansWithCildren.addAll(a.getFieldValues().values()));
    //получили ссылки у наследников и добавили в живые
    aliveBeansWithCildren.forEach(a -> aliveBeans.addAll(a.getFieldValues().values()));
    //переспросили у живых наследников
    aliveBeans.forEach(a -> aliveBeansWithCildren.addAll(a.getFieldValues().values()));
    //собрали вместе живых + наследников
    aliveBeansWithCildren.addAll(aliveBeans);

    Collection<ApplicationBean> beans = heap.getBeans().values();
    beans.removeAll(aliveBeansWithCildren);
    return  beans.stream().collect(Collectors.toList());
  }
}
