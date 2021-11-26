package net.broscorp.inner.classes;

import java.util.Arrays;
import java.util.Iterator;
import java.util.function.Function;

public class MyCoolListImpl<T extends Number> implements MyCoolList<T> {

  T[] arr;

  public MyCoolListImpl() {
    arr = (T[]) new Number[0];
  }

  public MyCoolListImpl(int size) {
    arr = (T[]) new Number[size];
  }

  @Override
  public void add(T t) {
    T[] copy = Arrays.copyOf(arr, arr.length);
    arr = (T[]) new Number[arr.length + 1];
    System.arraycopy(copy, 0, arr, 0, arr.length - 1);
    arr[arr.length - 1] = t;
  }

  @Override
  public T get(int index) {
    return arr[index];
  }

  @Override
  public T removeElem(int index) {
    T valToRemove = arr[index];
    T[] copy = Arrays.copyOf(arr, arr.length);
    arr = (T[]) new Number[arr.length - 1];

    if (index == 0) {
      System.arraycopy(copy, 1, arr, 0, arr.length);
    } else if (index == copy.length - 1) {
      System.arraycopy(copy, 0, arr, 0, arr.length);
    } else {
      System.arraycopy(copy, 0, arr, 0, index);
      System.arraycopy(copy, index + 1, arr, index, arr.length - index);
    }
    return valToRemove;
  }

  @Override
  public MyCoolList<T> map(Function<T, T> f) {
    MyCoolList<T> myCoolList = new MyCoolListImpl<>();

    for (T t : arr) {
      myCoolList.add(f.apply(t));
    }
    return myCoolList;
  }

  @Override
  public int size() {
    return arr.length;
  }

  public Iterator<T> iterator() {
    return new MyCoolListIterator();
  }

  private class MyCoolListIterator implements Iterator<T> {

    private int index = 0;

    @Override
    public void remove() {
      removeElem(--index);
    }

    @Override
    public boolean hasNext() {
      return arr.length > index;
    }

    @Override
    public T next() {
      return get(index++);
    }
  }
}
