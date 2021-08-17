package net.broscorp.generics;

import java.util.Arrays;
import java.util.function.Function;

public class MyCoolList<T extends Number> {

  //protected List<T> list = new ArrayList<>();
  protected T[] list;

  public MyCoolList() {
    this.list = (T[]) new Number[0];
  }

  public MyCoolList(int size) {
    this.list = (T[]) new Number[size];
  }

  /**
   * Add element in the end of list.
   *
   * @param o element to be added.
   */
  public void add(T o) {
    T[] temp = Arrays.copyOf(list, list.length);
    list = (T[]) new Number[list.length + 1];
    list[list.length - 1] = o;
    System.arraycopy(temp, 0, list, 0, list.length - 1);
  }

  public T get(int index) {
    return list[index];
  }

  /**
   * Remove element by index.
   *
   * @param index index of element in array.
   * @return returns removed element.
   */
  public T remove(int index) {
    T item = list[index];

    T[] temp = Arrays.copyOf(list, list.length);
    list = (T[]) new Number[list.length - 1];

    if (index == 0) {
      System.arraycopy(temp, 1, list, 0, list.length);
    } else if (index == list.length - 1) {
      System.arraycopy(temp, 0, list, 0, list.length);
    } else {
      System.arraycopy(temp, 0, list, 0, index - 1);
      System.arraycopy(temp, index + 1, list, index, list.length);
    }
    return item;
  }

  /**
   * Applies passed function to every element of list.
   *
   * @param f function to be applied.
   * @return return new exemplar of object with new list.
   */
  public MyCoolList<T> map(Function<T, T> f) {
    MyCoolList<T> newList = new MyCoolList(list.length);
    //newList.list = (T[]) Arrays.asList(list).stream().map(f).toArray();
    for (int i = 0; i < list.length; i++) {
      newList.list[i] = f.apply(list[i]);
    }
    return newList;
  }

  public int size() {
    return this.list.length;
  }

}
