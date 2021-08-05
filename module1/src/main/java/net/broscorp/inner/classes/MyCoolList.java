package net.broscorp.inner.classes;

import java.util.Arrays;
import java.util.Iterator;
import java.util.Objects;
import java.util.function.Function;

public class MyCoolList<E> implements Iterable<E> {

  private E[] elements;
  private int capacity;
  private static final int DEFAULT_CAPACITY = 10;

  public MyCoolList() {
    this.elements = (E[]) new Object[DEFAULT_CAPACITY];
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
      this.elements = (E[]) new Object[initialCapacity];
      this.capacity = elements.length;
    }
  }

  /**
   * Returns actual number of non-null elements in the list.
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

  public void removeByIndex(int index) {
    verifyIndex(index, capacity);
    elements = deleteItemAtIndex(elements, index, capacity);
  }

  /**
   * Removes first occurance of the element in the list.
   *
   * @param item item to be removed.
   */
  public void removeByValue(E item) {
    verifyNotNull(item);
    verifyArguments(item);
    for (int index = 0; index < size(); index++) {
      if (elements[index].equals(item)) {
        elements = deleteItemAtIndex(elements, index, capacity);
      }
    }
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

  public <T> MyCoolList<T> map(Function<E, T> f) {
    checkIfNotEmpty(elements);
    T[] arr = (T[]) Arrays.stream(elements)
        .filter(Objects::nonNull)
        .map(f)
        .toArray(Object[]::new);
    MyCoolList<T> myCoolList = new MyCoolList<>();
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
    E[] finalArr = (E[]) new Object[newCapacity];
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
    E[] newArr = (E[]) new Object[newCapacity];
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

  /**
   * Method searches for the occurrence of the item in the list.
   *
   * @param e item under check.
   * @return boolean value of check result.
   */
  public boolean contains(E e) {
    verifyNotNull(e);
    for (int i = 0; i < size(); i++) {
      if (elements[i].equals(e)) {
        return true;
      }
    }
    return false;
  }

  private void verifyNotNull(E item) {
    if (item == null) {
      throw new NullPointerException("Can't process nullable elements");
    }
  }

  private void verifyArguments(E item) {
    if (!contains(item)) {
      throw new IllegalArgumentException("The list doesn't contain value " + item.toString());
    }
  }

  private void verifyIndex(int index, int capacity) {
    if (index >= capacity || index < 0) {
      throw new IndexOutOfBoundsException("Index " + index + " is out of Bounds");
    }
  }

  private E[] deleteItemAtIndex(E[] elements, int index, int capacity) {
    E[] newArray = (E[]) new Object[capacity];
    for (int i = 0; i < capacity; i++) {
      if (i == index) {
        newArray = removeRangeOfElements(elements, i, capacity);
      }
    }
    return newArray;
  }

  private E[] eliminateItemByValue(E[] elements, E item, int capacity) {
    E[] newArray = (E[]) new Object[capacity];
    for (int i = 0; i < capacity; i++) {
      if (elements[i].equals(item)) {
        newArray = removeRangeOfElements(elements, i, capacity);
      }
    }
    return newArray;
  }

  /**
   * New piece of code related to inner.classes task. iterator() returns reference to inner class.
   *
   * @return Iterator instance.
   * <p>
   * Non-static nested classes are called inner classes.<br> Their static alternatives are called
   * static nested classes.
   * </p>
   * <p>
   * 1. Access to members and methods of ourer class.
   * <ul>
   *   <li>Inner classes have access to all members and methods (incl. private) of outer class.</li>
   *   <li>Static inner classes cannot access non-static members and methods of base class directly.
   *     They need outer class object reference for it</li>
   * </ul>
   * </p>
   * <p>
   *   2. Access to nested classes.
   * <ul>
   *   <li>Inner classes cannot be accessed without instantiating of outer class</li>
   *   <li>Static nested classes can be accessed through outer class name.</li>
   * </ul>
   * 2. Inner classes cannot be accessed without instantiating of outer class.<br> Static nested
   * classes can be accessed through outer class name.
   * </p>
   * <p>
   *   3. Nested classes static and non-static members and methods
   * <ul>
   *   <li>Inner classes cannot have static members and methods.</li>
   *   <li>Static nested classes can  have both static and non-static fields and methods.</li>
   * </ul>
   * 3. Inner classes cannot have static members and methods. Static nested classes can  have both
   * static and non-static fields and methods.
   * </p>
   */

  @Override
  public Iterator<E> iterator() {
    return new CoolIterator<E>();
  }

  class CoolIterator<E> implements Iterator<E> {

    private int index = 0;
    int size = size();

    @Override
    public boolean hasNext() {
      boolean hasNext = false;
      if (elements[index] != null) {
        hasNext = true;
      }
      return hasNext;
    }

    @Override
    public E next() {
      return (E) elements[index++];
    }

    @Override
    public void remove() {
      removeByIndex(index - 1);
    }
  }
}
