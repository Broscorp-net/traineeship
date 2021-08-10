package net.broscorp.inner.classes;

import java.util.Iterator;
import java.util.function.Function;

public class MyCoolList<T extends Number> implements Iterable<T> {

  T[] arrList;
  private int index = 0;


  public MyCoolList(int size) {
    this.arrList = (T[]) new Number[size];
  }

  int full = 0;

  /**
   * method add.
   */
  public void add(T t) {
    if (full + 1 == arrList.length) {
      T[] temp = (T[]) new Number[arrList.length * 2];
      System.arraycopy(arrList, 0, temp, 0, arrList.length);
      arrList = temp;
    }
    arrList[full] = t;
    full++;
  }

  /**
   * method get.
   */
  public T get(int index) {
    return arrList[index];
  }

  /**
   * method remove.
   */
  public T remove(int index) {
    T value = get(index);
    if (full - 1 - index >= 0) {
      System.arraycopy(arrList, index + 1, arrList, index, full - 1 - index);
    }
    full--;
    return value;
  }

  /**
   * method map.
   */
  public <R extends Number> MyCoolList<R> map(Function<T, R> f) {
    MyCoolList<R> myCoolList = new MyCoolList<>(arrList.length);
    for (T t : arrList) {
      if (t != null) {
        myCoolList.add(f.apply(t));
      }
    }
    return myCoolList;
  }

  /**
   * method size.
   */
  public int size() {
    int size = 0;
    for (int i = 0; i < arrList.length; i++) {
      if (arrList[i] != null) {
        size++;
      }
    }
    return size;
  }

  @Override
  public Iterator<T> iterator() {
    return new InnerIterator();
  }

  /**
   * Внутренние классы(Inner classes) - расположены внутри класса оболочки. Имеют доступ ко всем
   * полям и методам внешнего класса т.к. являются его частью. Объект внутреннего класса может
   * существовать только внутри объекта внешнего класса.
   * Вложенные классы(static Nested classes) - так же расположены внутри класса оболочки, но имеют
   * модификатор static. Из вложенного класса можно обращаться только к статическим полям и методам
   * внешнего класса. Для создания объекта статического внутреннего класса не нужен объект внешнего
   * класса.
   */

  class InnerIterator implements Iterator<T> {

    @Override
    public boolean hasNext() {
      return index < size();
    }

    @Override
    public T next() {
      return get(index++);
    }
  }
}
