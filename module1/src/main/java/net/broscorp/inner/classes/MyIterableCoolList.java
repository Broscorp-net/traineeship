package net.broscorp.inner.classes;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.function.Function;

public class MyIterableCoolList<T extends Number> implements Iterable<T> {

  private List<T> coolList = new ArrayList<>();

  public void add(T t) {
    coolList.add(t);
  }

  public T get(int index) {
    return coolList.get(index);
  }

  public T remove(int index) {
    return coolList.remove(index);
  }

  /**
   * map method.
   *
   * @param f - function
   */
  public <C extends Number> MyIterableCoolList<C> map(Function f) {
    MyIterableCoolList<C> myCoolList = new MyIterableCoolList<>();
    for (T t : coolList) {
      myCoolList.add((C) f.apply(t));
    }
    return myCoolList;
  }

  public int size() {
    return coolList.size();
  }

  @Override
  public Iterator<T> iterator() {
    return new MyIterator();
  }

  /**
   * InnerClass. - имеет доступ ко всем полям и методам внешнего класса - существует только внутри
   * объекта внешнего класса StaticInnerClass. - имеет доступ только к статическим полям и методам
   * внешнего класса - существует независимо от объекта внешнего класса
   */
  private class MyIterator implements Iterator<T> {

    private int index;

    public MyIterator() {
      index = 0;
    }

    @Override
    public boolean hasNext() {
      return index < coolList.size();
    }

    @Override
    public T next() {
      return coolList.get(index++);
    }
  }
}
