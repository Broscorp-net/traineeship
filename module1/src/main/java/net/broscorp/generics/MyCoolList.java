package net.broscorp.generics;

import java.util.Arrays;
import java.util.ConcurrentModificationException;
import java.util.Iterator;
import java.util.NoSuchElementException;
import java.util.function.Function;

public class MyCoolList<E extends Number> implements Iterable<E> {
  private static final int DEFAULT_CAPACITY = 10;
  private int size = 0;
  transient E[] elementData;

  public MyCoolList() {
    this.elementData = (E[])new Number[0];
  }

  /**
   * Constructor with initialCapacity.
   * */
  public MyCoolList(int initialCapacity) {
    if (initialCapacity > 0) {
      this.elementData = (E[])new Number[initialCapacity];
    } else if (initialCapacity == 0) {
      this.elementData = (E[])new Number[0];
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
  public E get(int index) {
    if (index < 0 || index > size) {
      throw new IndexOutOfBoundsException();
    }
    return elementData[index];
  }

  /**
   * remove an element with index.
   * */
  public E remove(int index) {
    final E[] es = elementData;
    E oldValue = es[index];
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

  private E[] grow(int minCapacity) {
    int oldCapacity = elementData.length;
    if (oldCapacity > 0 || !Arrays.equals(elementData, new Number[0])) {
      return elementData = Arrays.copyOf(elementData, minCapacity);
    } else {
      return elementData = (E[]) new Number[Math.max(DEFAULT_CAPACITY, minCapacity)];
    }
  }

  private void fastRemove(Number[] es, int i) {
    final int newSize;
    if ((newSize = size - 1) > i) {
      System.arraycopy(es, i + 1, es, i, newSize - i);
    }
    es[size = newSize] = null;
  }

  public Iterator<E> iterator() {
    return new MyCoolIterator();
  }

  /**
   * Difference between Static and Non-Static Nested Class.
   * -> The static inner class can access the static members of the outer class directly.
   * But, to access the instance members of the outer class you need to instantiate the outer class.
   * -> Nested static class doesn’t need a reference of Outer class but a nonstatic nested class or
   * Inner class requires Outer class reference.
   * -> A non-static nested class has full access to the members of the class within which it is
   * nested. A static nested class does not have a reference to a nesting instance, so a static
   * nested class cannot invoke non-static methods or access non-static fields of an instance of the
   * class within which it is nested.
   * -> Another difference between static and non-static nested class is that you can not access
   * non-static members e.g. method and field into nested static class directly. If you do you will
   * get errors like “nonstatic member can not be used in the static context”. While the Inner class
   * can access both static and non-static members of the Outer class.
   * */

  class MyCoolIterator implements Iterator<E> {
    int cursor = 0;

    public boolean hasNext() {
      return cursor < size;
    }

    public E next() {
      if (hasNext()) {
        return get(cursor++);
      } else {
        throw new NoSuchElementException();
      }
    }

    public void remove() {
      try {
        MyCoolList.this.remove(cursor);
      } catch (IndexOutOfBoundsException e) {
        throw new ConcurrentModificationException();
      }
    }
  }

}

