package net.broscorp.generics;

import java.util.Arrays;
import java.util.function.Function;

public class MyCoolList<E extends Number> {
  private static final int DEFAULT_CAPACITY = 10;
  private int size = 0;
  transient Number[] elementData;
  private static final Number[] DEFAULT_CAPACITY_EMPTY_ELEMENT_DATA = {};

  public MyCoolList() {
    this.elementData = DEFAULT_CAPACITY_EMPTY_ELEMENT_DATA;
  }

  /**
   * Constructor with initialCapacity.
   * */
  public MyCoolList(int initialCapacity) {
    if (initialCapacity > 0) {
      this.elementData = new Number[initialCapacity];
    } else if (initialCapacity == 0) {
      this.elementData = DEFAULT_CAPACITY_EMPTY_ELEMENT_DATA;
    } else {
      throw new IllegalArgumentException("Illegal Capacity: "
          + initialCapacity);
    }
  }

  /**
   * This method adds a new element to the list.
   * */
  public void add(E o) {
    if (size == elementData.length) {
      elementData = grow(size + 1);
    }
    elementData[size] = o;
    size = size + 1;
  }

  /**
   * returns an element with index.
   * */
  public Number get(int index) {
    if (index < 0 || index > size) {
      throw new IndexOutOfBoundsException();
    }
    return elementData[index];
  }

  /**
   * remove an element with index.
   * */
  public Number remove(int index) {
    final Number[] es = elementData;

    Number oldValue = es[index];
    fastRemove(es, index);

    return oldValue;
  }

  /**
   * returns a new list created by the function.
   * */
  public <R extends Number> MyCoolList<R> map(Function<E, R> f) {
    MyCoolList<R> myCoolList = new MyCoolList<>(size);
    for (int i = 0; i < size; i++) {
      myCoolList.add(f.apply((E) elementData[i]));
    }
    return myCoolList;
  }

  public int size() {
    return size;
  }

  private Number[] grow(int minCapacity) {
    int oldCapacity = elementData.length;
    if (oldCapacity > 0 || elementData != DEFAULT_CAPACITY_EMPTY_ELEMENT_DATA) {
      return elementData = Arrays.copyOf(elementData, minCapacity);
    } else {
      return elementData = new Number[Math.max(DEFAULT_CAPACITY, minCapacity)];
    }
  }

  private void fastRemove(Number[] es, int i) {
    final int newSize;
    if ((newSize = size - 1) > i) {
      System.arraycopy(es, i + 1, es, i, newSize - i);
    }
    es[size = newSize] = null;
  }

}
