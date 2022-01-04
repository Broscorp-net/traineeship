package net.broscorp.generics;

import java.util.Iterator;
import java.util.NoSuchElementException;
import java.util.function.Function;


public class MyCoolList<T extends Number> implements Iterable<T> {

  int curr;
  T[] arr;

  // code for data structure
  public Iterator<T> iterator() {
    return new MyCoolIterator();
  }

  /**
   * Now the difference between Static and Non-Static Nested Class in Java:
   * 1. The static inner class can access the static members of the outer class directly.
   *    But, to access the instance members of the outer class you need to instantiate the
   *    outer class.
   * 2. Nested static class does not need a reference of Outer class but a nonstatic nested class
   *    or Inner class requires Outer class reference.
   * 3. A non-static nested class has full access to the members of the class within which it
   *    is nested. A static nested class does not have a reference to a nesting instance,
   *    so a static nested class cannot invoke non-static methods or access non-static fields
   *    of an instance of the class within which it is nested.
   * 4. Another difference between static and non-static nested class is that you can not access
   *    non-static members e.g. method and field into nested static class directly. If you do you
   *    will get errors like “nonstatic member can not be used in the static context”. While the
   *    Inner class can access both static and non-static members of the Outer class.
   */
  class MyCoolIterator implements Iterator<T> {

    int pos = 0;
    boolean canBeRemoved = false;

    public boolean hasNext() {
      return pos <= size() - 1;
    }

    public T next() {
      if (hasNext()) {
        T t = get(pos++);
        canBeRemoved = true;
        return t;
      } else {
        throw new NoSuchElementException();
      }
    }

    public void remove() {
      if (canBeRemoved) {
        MyCoolList.this.remove(pos - 1);
        canBeRemoved = false;
      } else {
        throw new IllegalStateException();
      }
    }
  }

  /**
   * Default constructor.
   */
  public MyCoolList() {
    // non initialized array (has no elements)
    this.curr = -1;
    this.arr = null;
  }

  /**
   * Add object o to the collection.
   * @param o - object to add to the collection.
   */
  public void add(T o) {
    if (arr != null && this.curr <= this.arr.length - 2) {
      this.arr[++this.curr] = o;
    } else {
      this.increaseArray();
      this.add(o);
    }
  }

  private void increaseArray() {
    if (this.arr == null) { // initialize array with size 1
      this.arr = (T[])new Number[1];
    } else { // double array size and copy elements

      // TBD: add check if newLength becomes greater than MAX_INTEGER

      int newLength = this.arr.length * 2;
      T[] arrTmp = this.arr;
      this.arr = (T[])new Number[newLength];
      System.arraycopy(arrTmp, 0, arr, 0, arrTmp.length - 1 + 1);
    }
  }

  /**
   * Fetches the element at position index.
   * @param index - position to fetch the element
   * @return the fetched element
   */
  public T get(int index) {

    if (isValidIndex(index)) {
      return this.arr[index];
    } else {
      throw new IllegalArgumentException();
    }
  }

  /**
   * Removes element at position index.
   * @param index - position of the element to be removed.
   * @return the removed element.
   */
  public T remove(int index) {

    if (isValidIndex(index)) {
      T o = this.get(index);

      if (this.arr.length - index >= 0) {
        System.arraycopy(this.arr, index + 1, this.arr, index, curr - index);
      }
      this.curr--;
      return o;
    } else {
      throw new IllegalArgumentException();
    }
  }

  private boolean isValidIndex(int index) {
    if (this.arr == null) {
      return false;
    } else {
      return index >= 0 && index <= this.curr;
    }
  }

  /**
   * Returns a list which is the result of applying function f to the current list.
   * @param f - function to be applied to list elements
   * @param <N> - returned type is of type numeric
   * @return a list which the result of applying function f
   */
  public <N extends Number> MyCoolList<N> map(Function<T, N> f) {
    MyCoolList<N> mappedList = new MyCoolList<>();

    for (T t : this.arr) {
      mappedList.add(f.apply(t));
    }
    return mappedList;
  }

  public int size() {
    return this.curr + 1;
  }
}
