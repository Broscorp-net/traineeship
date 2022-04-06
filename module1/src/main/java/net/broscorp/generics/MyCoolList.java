package net.broscorp.generics;

import java.util.function.Function;

public class MyCoolList<T extends Number> {
  private int init_size = 15;
  private Object[] array = new Object[init_size];
  private int index = 0;

  public void add(T item) {
    if (index == array.length - 1) {
      Object[] newArray = new Object[init_size * 2];
      System.arraycopy(array, 0, newArray, 0, index);
      array = newArray;
    }
    array[index++] = item;
  }

  public T get(int index) {
    return (T) array[index];
  }

  public T remove(int position) {
    Object o = array[position];
    for (int i = position; i < index; i++)
      array[i] = array[i+1];
    array[index] = null;
    index--;
    return (T) o;
  }

  public MyCoolList map(Function f) {
    MyCoolList list = new MyCoolList();
    for (Object obj : array) {
      f.apply(obj);
      list.add((T)obj);
    }
    return list;
  }

  public int size() {
    return index;
  }
}
