package net.broscorp.inner.classes;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.function.Function;

public class MyCoolList<T extends Number> implements Iterable {

  private MyIteratorClass myIteratorClass = new MyIteratorClass();
  private List<T> list = new ArrayList<>();

  public void add(T o) {
    list.add(o);
  }

  public Object get(int index) {
    return list.get(index);
  }

  public Object remove(int index) {
    return list.remove(list.get(index));
  }

  /**
   * Method that converted T objects to A objects.
   */
  public <A extends Number> MyCoolList<A> map(Function f) {
    MyCoolList<A> secondMyCoolList = new MyCoolList<>();
    for (Object obj : list) {
      secondMyCoolList.add((A) f.apply(obj));
    }
    return secondMyCoolList;
  }

  public int size() {
    return list.size();
  }

  @Override
  public Iterator iterator() {
    return myIteratorClass;
  }

  /**
   * Вложенные классы делятся на две категории: статические и нестатические. Вложенные классы,
   * объявленные static, просто называются статическими вложенными классами. Нестатические вложенные
   * классы называются внутренними классами. Экземпляр InnerClass может существовать только внутри
   * экземпляра OuterClass и имеет прямой доступ к методам и полям его вмещающего экземпляра. Но
   * если этот InnerClass static, то он имеет доступ только к static полям и методам OuterClass.
   */
  private class MyIteratorClass implements Iterator<T> {

    private int currentIndex = 0;

    @Override
    public boolean hasNext() {
      return this.currentIndex < list.size();
    }

    @Override
    public T next() {
      return list.get(currentIndex++);
    }
  }
}