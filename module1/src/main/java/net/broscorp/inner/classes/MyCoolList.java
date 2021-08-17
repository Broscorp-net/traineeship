/*
 * Copyright (c) 2021.
 * Danylo Havrylchenko
 * GitHub: @akellanotavailable
 */

package net.broscorp.inner.classes;

import java.util.Arrays;
import java.util.Iterator;
import java.util.function.Function;

/**
 * https://docs.oracle.com/javase/tutorial/java/javaOO/nested.html
 * <p>
 * Nested classes are divided into two categories: non-static and static. Non-static nested classes
 * are called inner classes. Nested classes that are declared static are called static nested
 * classes.
 * </p>
 * <p>
 * As with instance methods and variables, an inner class is associated with an instance of its
 * enclosing class and has direct access to that object's methods and fields. Also, because an inner
 * class is associated with an instance, it cannot define any static members itself.
 * </p>
 * <p>
 * Static nested class cannot refer directly to instance variables or methods defined in its
 * enclosing class: it can use them only through an object reference
 * </p>
 *
 * @param <T> any iterable element.
 */


public class MyCoolList<T extends Number> implements Iterable<T> {


  protected T[] list;

  public MyCoolList() {
    this.list = (T[]) new Number[0];
  }

  public MyCoolList(int size) {
    this.list = (T[]) new Number[size];
  }

  protected final ListIterator iterator = new ListIterator();

  /**
   * Add element in the end of the list.
   *
   * @param o element to be added
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
   * @param index index of element of array.
   * @return returns removed element.
   */
  public T removeElement(int index) {
    T item = list[index];

    T[] temp = Arrays.copyOf(list, list.length);
    list = (T[]) new Number[list.length - 1];

    if (index == 0) {
      System.arraycopy(temp, 1, list, 0, list.length);
    } else if (index == temp.length - 1) {
      System.arraycopy(temp, 0, list, 0, list.length);
    } else {
      System.arraycopy(temp, 0, list, 0, index);
      System.arraycopy(temp, index + 1, list, index, temp.length - index - 1);
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
    for (int i = 0; i < list.length; i++) {
      newList.list[i] = f.apply(list[i]);
    }
    return newList;
  }

  public int size() {
    return this.list.length;
  }

  public Iterator<T> iterator() {
    return new ListIterator();
  }

  private class ListIterator implements Iterator<T> {

    private int index = 0;

    @Override
    public boolean hasNext() {
      return list.length > index;
    }

    @Override
    public T next() {
      return get(index++);
    }

    @Override
    public void remove() {
      removeElement(--index);
    }

  }
}
