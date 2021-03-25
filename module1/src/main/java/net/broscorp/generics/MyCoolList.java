package net.broscorp.generics;

import java.util.Arrays;
import java.util.function.Function;

public class MyCoolList<T extends Number> {
  private static final int DEFAULT_CAPACITY = 10;
  private Object[] elements;
  private int size = 0;

  public MyCoolList() {
    this.elements = new Object[DEFAULT_CAPACITY];
  }

  /**
   * Method add element to list.
   * @param number input
   */
  public void add(T number) {
    if (size == elements.length) {
      ensureCapacity();
    }
    elements[size++] = number;
  }

  /**
   * Method get element by index from list.
   * @param index input
   * @return
   */
  public T get(int index) {
    checkSize(index);
    return (T) elements[index];
  }

  /**
   * Method remove element by index from list.
   * @param index input
   * @return
   */
  public T remove(int index) {
    checkSize(index);
    Object item = elements[index];
    int numElements = elements.length - (index + 1);
    System.arraycopy(elements, index + 1, elements, index, numElements);
    size--;
    return (T) item;
  }

  /**
   * Method for casting a type in a list.
   *
   * @param f   function
   * @param <R> required type
   * @return list with required type
   */
  public <R extends Number> MyCoolList<R> map(Function<T, R> f) {
    MyCoolList<R> myCoolList = new MyCoolList();
    for (int i = 0; i < elements.length; i++) {
      myCoolList.add(f.apply((T) elements[i]));
    }
    return myCoolList;
  }

  public int size() {
    return size;
  }

  private void checkSize(int index) {
    if (index >= size || index < 0) {
      throw new IndexOutOfBoundsException("Index: " + index + ", Size " + index);
    }
  }

  private void ensureCapacity() {
    int newSize = elements.length * 2;
    elements = Arrays.copyOf(elements, newSize);
  }
}
