package net.broscorp.inner.classes;

import java.util.NoSuchElementException;

public class MyCoolList<T extends Number> {

  /**
   * Difference between inner static and inner classes:
   *<p></p>
   * -an outer class object is not required to create a static nested class object.
   * -from an object of a static nested class, you cannot access non-static members of the enclosing
   * class directly, but only through a reference to an instance of the outer class.
   * -ordinary nested classes cannot contain static methods, initialization blocks, and classes.
   * Static nested classes - can.
   * -an ordinary nested class object holds a reference to the outer class object. There is no such
   * reference inside a static one.
   */
  //initial array default capacity
  private static final int INITIAL_ARRAY_CAPACITY = 10;
  //initial array
  private Object[] array;
  //collection size
  private int size;

  /**
   * constructor with custom capacity.
   */
  public MyCoolList(int capacity) {
    this.array = new Object[capacity];
  }

  /**
   * default constructor.
   */
  public MyCoolList() {
    this.array = new Object[INITIAL_ARRAY_CAPACITY];
  }

  /**
   * Returns an iterator over the elements in this collection.
   *
   * @return Iterator
   */
  public MyCoolListIterator iterator() {
    return new MyCoolListIterator();
  }

  /**
   * Class of iterator.
   */
  public class MyCoolListIterator {
    private int currentIndex;

    //default constructor
    public MyCoolListIterator() {
    }

    /**
     * Returns {@code true} if the iteration has more elements.
     *
     * @return boolean
     */
    public boolean hasNext() {
      return currentIndex != size;
    }

    /**
     * Returns the next element in the iteration.
     *
     * @return collection's element
     * @throws NoSuchElementException if the iteration has no more elements
     */
    public T next() {
      if (currentIndex >= size) {
        throw new NoSuchElementException();
      }
      int i = currentIndex;
      currentIndex += 1;
      return (T) array[i];
    }
  }

  /**
   * add object to collection.
   *
   * @param o element whose presence in this collection is to be ensured
   */
  public void add(Object o) {
    if (size == array.length) {
      Object[] newArray = new Object[array.length * 2];
      System.arraycopy(array, 0, newArray, 0, array.length);
      array = newArray;
    }
    array[size] = o;
    size = size + 1;
  }
}
