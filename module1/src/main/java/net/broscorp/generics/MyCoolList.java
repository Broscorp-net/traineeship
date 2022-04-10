package net.broscorp.generics;

import java.util.function.Function;

public class MyCoolList<T extends Number> {

  private static final int DEFAULT_CAPACITY = 10;
  private int size;
  private T[] elements;

  @SuppressWarnings("unchecked")
  public MyCoolList() {
    elements = (T[]) new Number[DEFAULT_CAPACITY];
  }

  /**
   * *You can create a list with a specific size.
   * */

  @SuppressWarnings("unchecked")
  public MyCoolList(int capacity) {
    if (capacity > 0) {
      elements = (T[]) new Number[capacity];
    }
  }

  /**
   * Adds a value to the list. Checking list size.
   * If size of a list is not enough will call method growArray in order to resize list.
   */

  public void add(T value) {
    if (size == elements.length) {
      growArray();
    }
    elements[size] = value;
    size++;
  }

  /**
   * Get value by index.
   */

  public T get(int index) {
    checkIndex(index);
    return elements[index];
  }

  /**
   * Remove element by index.
   */

  public T remove(int index) {
    checkIndex(index);
    T value = elements[index];
    System.arraycopy(elements, index + 1, elements, index, size - index - 1);
    size--;
    return value;
  }

  /**
   * Is used to transform one object into other by applying a function.
   */

  public <G extends Number> MyCoolList<G> map(Function<T, G> f) {
    MyCoolList<G> myCoolList = new MyCoolList<>();
    for (T number : elements) {
      myCoolList.add(f.apply(number));
    }
    return myCoolList;
  }

  public int size() {
    return size;
  }

  @SuppressWarnings("unchecked")
  private void growArray() {
    T[] newArray = (T[]) new Number[(int) (elements.length * 1.5)];
    System.arraycopy(elements, 0, newArray, 0, size);
    elements = newArray;
  }

  private void checkIndex(int index) {
    if (index >= size || index < 0) {
      throw new IndexOutOfBoundsException("Index is invalid - " + index);
    }
  }
}
