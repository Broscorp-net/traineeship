package net.broscorp.generics;

import java.util.Arrays;
import java.util.function.Function;

public class MyCoolList<T extends Number> {

  T[] arrList;

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

}
