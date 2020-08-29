package net.broscorp.generics;

import java.util.Arrays;
import java.util.function.Function;

public class MyCoolList<T extends Number> {

  private int size = 0;
  private Object[] elements;

  public MyCoolList() {
    int defaultCapacity = 10;
    elements = new Object[defaultCapacity];
  }

  public MyCoolList(int capacity) {
    elements = new Object[capacity];
  }

  /**
   * Adds new element to list.
   * @param o object to add
   */
  public void add(T o) {
    if (size == elements.length) {
      changeCapacity();
    }

    elements[size++] = o;
  }

  /**
   * Return element by index.
   * @param index index of element
   * @return element
   */
  public T get(int index) {
    if (index >= size || index < 0) {
      throw new IndexOutOfBoundsException();
    }

    return (T) elements[index];
  }

  /**
   * Removes element by index.
   * @param index index of element
   * @return removed element
   */
  public T remove(int index) {
    if (index >= size || index < 0) {
      throw new IndexOutOfBoundsException();
    }

    final T oldValue = (T) elements[index];
    elements[index] = null;

    int tmp = index;
    while (tmp < size) {
      elements[tmp] = elements[tmp + 1];
      elements[tmp + 1] = null;
      tmp++;
    }

    size--;
    return oldValue;
  }

  /**
   * Map method creates new MyCoolList and apply function to each element of original list.
   * @param f function
   * @param <T> desired data type (T extends Number)
   * @return new list
   */
  public <T extends Number> MyCoolList<T> map(Function f) {
    MyCoolList<T> newList = new MyCoolList<T>(elements.length);

    for (int i = 0; i < size; i++) {
      T el = (T) elements[i];
      newList.add((T) f.apply(el));
    }

    return newList;
  }

  /**
   * Returns current size of the list.
   * @return size
   */
  public int size() {
    return size;
  }

  private void changeCapacity() {
    int newSize = elements.length * 2;
    elements = Arrays.copyOf(elements, newSize);
  }

}
