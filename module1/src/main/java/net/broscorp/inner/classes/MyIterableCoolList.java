package net.broscorp.inner.classes;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.function.Function;

public class MyIterableCoolList<T extends Number> extends ArrayList<T> {

  @Override
  public boolean add(T t) {
    return super.add(t);
  }

  @Override
  public T get(int index) {
    return super.get(index);
  }

  @Override
  public T remove(int index) {
    return super.remove(index);
  }

  /**
   * map method.
   * @param f - function
   */
  public <C extends Number> MyIterableCoolList<C> map(Function f) {
    MyIterableCoolList<C> myCoolList = new MyIterableCoolList<>();
    for (T t : this) {
      myCoolList.add((C) f.apply(t));
    }
    return myCoolList;
  }

  @Override
  public int size() {
    return super.size();
  }

  @Override
  public Iterator<T> iterator() {
    return new MyIterator();
  }

  /**
   * InnerClass.
   * - имеет доступ ко всем полям и методам внешнего класса
   * - существует только внутри объекта внешнего класса
   *StaticInnerClass.
   * - имеет доступ только к статическим полям и методам внешнего класса
   * - существует независимо от объекта внешнего класса
   */
  private class MyIterator implements Iterator<T> {

    private int index = 0;

    @Override
    public boolean hasNext() {
      return index < MyIterableCoolList.this.size();
    }

    @Override
    public T next() {
      return MyIterableCoolList.this.get(index++);
    }
  }
}
