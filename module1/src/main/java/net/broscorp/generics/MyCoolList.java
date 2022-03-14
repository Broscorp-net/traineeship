package net.broscorp.generics;

import java.util.Arrays;
import java.util.Iterator;
import java.util.function.Function;

/**
 * Something that extends Number.
 */
public class MyCoolList<T extends Number> implements Iterable<T> {

  private T[] numbers;
  private int size;

  public MyCoolList() {
    this.numbers = (T[]) new Number[0];
    this.size = 0;
  }

  /**
   * Adding an object.
   */
  public void add(T o) {
    size++;
    numbers = extendList();
    numbers[size - 1] = o;
    System.gc();
  }

  /**
   * Getting with index that was given.
   */
  public T get(int index) {

    if (index < size) {
      return numbers[index];
    }

    return null;
  }

  /**
   * Removing element.
   */
  public T remove(int index) {
    if (index < size) {
      int newSize = size - 1;
      T[] newList = Arrays.copyOf(numbers, newSize);

      for (int j = index; j < newSize; j++) {
        newList[j] = numbers[j + 1];
      }

      size = newSize;
      T removed = get(index);
      numbers = newList;
      System.gc();
      return removed;
    }
    return null;
  }

  /**
   * Extending the array.
   */
  private T[] extendList() {
    return Arrays.copyOf(numbers, size);
  }

  /**
   * Mapping of array.
   */
  public <R extends Number> MyCoolList<R> map(Function<T, R> f) {
    MyCoolList<R> myList = new MyCoolList<>();

    for (T num : numbers) {
      myList.add(f.apply(num));
    }
    return myList;
  }

  public int size() {
    return size;
  }

  @Override
  public Iterator<T> iterator() {
    return new MyIterator();
  }

  /**
   *  * The static inner class can access the static members of the outer class directly.
   *    But, to access the instance members of the outer class you
   *    need to instantiate the outer class.
   *  * Nested static class doesn’t need a reference of Outer class but a nonstatic nested class
   *    or Inner class requires Outer class reference.
   *  * A non-static nested class has full access to the members of the class within
   *    which it is nested. A static nested class does not have a reference to a nesting instance,
   *    so a static nested class cannot invoke non-static methods or access non-static fields
   *    of an instance of the class within which it is nested.
   *  * Another difference between static and non-static nested class is that
   *    you can not access non-static members e.g. method and field
   *    into nested static class directly.
   */
  class MyIterator implements Iterator<T> {

    private int pointer = 0;

    public boolean hasNext() {
      return pointer < size;
    }

    public T next() {
      if (hasNext()) {
        return get(pointer++);
      } else {
        throw new MyCoolListException("No such element with index #" + pointer);
      }
    }

    public void remove() {
      try {
        MyCoolList.this.remove(pointer);
      } catch (IndexOutOfBoundsException e) {
        throw new MyCoolListException("No such element with index #" + pointer);
      }
    }
  }
}
