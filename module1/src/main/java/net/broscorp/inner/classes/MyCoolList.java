package net.broscorp.inner.classes;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.function.Function;

public class MyCoolList<T extends Number> implements Iterable<T> {

  private final List<T> myCoolList = new ArrayList<>();

  public void add(T o) {
    myCoolList.add(o);
  }

  public T get(int index) {
    return myCoolList.get(index);
  }

  public T remove(int index) {
    return myCoolList.remove(index);
  }

  /**
   * Converting one value to another.
   *
   * @param f   - function variable
   * @param <R> - result type received from T
   * @return - list
   */
  public <R extends Number> MyCoolList<R> map(Function<T, R> f) {
    MyCoolList<R> listR = new MyCoolList<>();
    for (T t : myCoolList) {
      listR.add(f.apply(t));
    }
    return listR;
  }

  public int size() {
    return myCoolList.size();
  }

  @Override
  public Iterator<T> iterator() {
    return new MyIterator();
  }

  /**
   *  InnerClass имеет доступ ко всем полям внешнего класса, в том числе и закрытым.
   *  Объект InnerClass не может существовать без объекта внешнего класса.
   *  Для StaticInnerClass же иначе, может существовать сам по себе, но при создании такого класса
   *  нужно указать название внешнего. Например MyCoolList.MyIterator = new MyCoolList.MyIterator().
   *  StaticInnerClass может обращаться только к статическим полям(переменные и методы)
   *  внешнего класса.
   */
  private class MyIterator implements Iterator<T> {

    int cursor;

    @Override
    public boolean hasNext() {
      return cursor != size();
    }

    @Override
    public T next() {
      if (cursor >= size()) {
        throw new NoSuchElementException();
      }
      cursor++;
      return get(cursor - 1);
    }
  }
}
