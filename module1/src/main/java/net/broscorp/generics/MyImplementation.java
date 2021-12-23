package net.broscorp.generics;

import java.util.Arrays;
import java.util.function.Function;

public class MyImplementation<T extends Number> implements MyCoolList<T> {
  T[] list;

  public MyImplementation() {
    list = (T[]) new Number[0];
  }

  public MyImplementation(int size) {
    list = (T[]) new Number[size];
  }

  @Override
  public <R extends Number> MyCoolList<R> map(Function<T, R> f) {
    MyCoolList<R> myList = new MyImplementation<>();

    for (T t : list) {
      myList.add(f.apply(t));
    }
    return myList;
  }

  @Override
  public int size() {
    return list.length;
  }

  @Override
  public void add(T t) {
    T[] copyList = Arrays.copyOf(list, list.length);
    list = (T[]) new Number[list.length + 1];
    System.arraycopy(copyList, 0, list, 0, list.length - 1);
    list[list.length - 1] = t;
  }

  @Override
  public T get(int index) {
    return list[index];
  }

  @Override
  public T remove(int i) {
    T value = list[i];
    T[] copy = Arrays.copyOf(list, list.length);
    list = (T[]) new Number[list.length - 1];

    if (i == 0) {
      System.arraycopy(copy, 1, list, 0, list.length);
    } else if (i == copy.length - 1) {
      System.arraycopy(copy, 0, list, 0, list.length);
    } else {
      System.arraycopy(copy, 0, list, 0, i);
      System.arraycopy(copy, i + 1, list, i, list.length - i);
    }
    return value;
  }
}
