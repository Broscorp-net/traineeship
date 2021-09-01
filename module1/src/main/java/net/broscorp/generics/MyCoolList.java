package net.broscorp.generics;

import java.util.Arrays;
import java.util.Objects;
import java.util.function.Function;

public class MyCoolList<E extends Number> {

  private E[] elements;
  private int capacity;
  private static final int DEFAULT_CAPACITY = 10;

  public MyCoolList() {
    this.elements = (E[]) new Number[DEFAULT_CAPACITY];
    this.capacity = elements.length;
  }

  /**
   * Creates list with initial parameter as supplied.
   *
   * @param initialCapacity positive integer number.
   */
  public MyCoolList(int initialCapacity) {
    if (initialCapacity < 0) {
      throw new IllegalArgumentException("Capacity can't be negative");
    } else {
      this.elements = (E[]) new Number[initialCapacity];
      this.capacity = elements.length;
    }
  }

  /**
   * Returns actual number of f non-null elements in the list.
   *
   * @return positive elements count.
   */

  public int size() {
    return checkLoad(elements);
  }

  /**
   * Counts all elements of the list including nullable.
   *
   * @return actual capacity of the list.
   */

  public int capacity() {
    return capacity;
  }

  /**
   * Adds element to the end of the list. Increases the capacity of the list if added element
   * exceeds current capacity.
   */
  public void add(E e) {
    int load = size();
    if (load == 0) {
      elements[0] = e;
    } else if (load > 0 && load < capacity) {
      elements = insertElement(elements, load, e);
    } else {
      elements = extendElementsThanAdd(elements, load, e);
    }
  }

  /**
   * Removes element at the given index.
   *
   * @throws IndexOutOfBoundsException if index is less than 0 or greater than list capacity.
   */

  public void remove(int index) {
    verifyIndex(index, capacity);
    elements = eliminateItemAtIndex(elements, index, capacity);
  }

  /**
   * Removes elements within the index range.
   *
   * @param start inclusively.
   * @param end   not including.
   * @throws IndexOutOfBoundsException if start or end index is less than 0 or greater than list
   *                                   capacity.
   */

  public void removeRange(int start, int end) {
    verifyIndex(start, capacity);
    verifyIndex(end, capacity);
    elements = removeRangeOfElements(elements, start, end);
  }

  /**
   * Maps incoming type to another type according to function passed as parameter.
   *
   * @param <T> MyCoolList return type.
   * @param f   mapping function to be executed in the method.
   * @throws NullPointerException if array the value of which to be converted is empty.
   */

  public <T extends Number> MyCoolList<T> map(Function<E, T> f) {
    checkIfNotEmpty(elements);
    T[] arr = (T[]) Arrays.stream(elements)
        .filter(Objects::nonNull)
        .map(f)
        .toArray(Number[]::new);
    MyCoolList<T> myCoolList = new MyCoolList<T>();
    for (T el : arr) {
      myCoolList.add(el);
    }
    return myCoolList;
  }

  private E[] removeRangeOfElements(E[] elements, int start, int end) {
    E[] beforeStart = Arrays.copyOfRange(elements, 0, start);
    E[] afterEnd = Arrays.copyOfRange(elements, start + 1, end);
    int first = beforeStart.length;
    int second = afterEnd.length;
    int newCapacity = first + second;
    E[] finalArr = (E[]) new Number[newCapacity];
    System.arraycopy(beforeStart, 0, finalArr, 0, first);
    System.arraycopy(afterEnd, 0, finalArr, first, second);
    return finalArr;
  }

  private void checkIfNotEmpty(E[] elements) {
    if (checkLoad(elements) == 0) {
      throw new NullPointerException("Operation on empty or null element");
    }
  }

  private E[] extendElementsThanAdd(E[] elements, int load, E e) {
    int oldCapacity = capacity();
    int newCapacity = oldCapacity + (oldCapacity / 2);
    E[] newArr = (E[]) new Number[newCapacity];
    System.arraycopy(elements, 0, newArr, 0, elements.length);
    capacity = newCapacity;
    return insertElement(newArr, load, e);
  }

  private E[] insertElement(E[] elements, int load, E e) {
    elements[load] = e;
    return elements;
  }

  private int checkLoad(E[] elements) {
    int count = 0;
    for (E el : elements) {
      if (el != null) {
        count++;
      }
    }
    return count;
  }

  public E get(int index) {
    verifyIndex(index, capacity);
    return elements[index];
  }

  private void verifyIndex(int index, int capacity) {
    if (index >= capacity || index < 0) {
      throw new IndexOutOfBoundsException("Index " + index + " is out of Bounds");
    }
  }

  private E[] eliminateItemAtIndex(E[] elements, int index, int capacity) {
    E[] newArray = (E[]) new Number[capacity];
    for (int i = 0; i < capacity; i++) {
      if (i != index) {
        newArray[i] = elements[i];
      }
    }
    return Arrays.copyOf(newArray, capacity);
  }
}
