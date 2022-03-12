package net.broscorp.generics;

import java.util.Iterator;
import java.util.NoSuchElementException;
import java.util.function.Function;

public class MyCoolList<T extends Number> implements Iterable<T> {

  private int size;

  private static final int DEFAULT_CAPACITY = 10;
  private T[] array;


  public MyCoolList() {
    array = (T[]) new Number[DEFAULT_CAPACITY];
  }

  private MyCoolList(int capacity) {
    array = (T[]) new Number[capacity];
  }

  public void add(T object) {
    add(object, size);
  }

  /**
   * Receives the object and its index inside array.
   */
  public void add(T object, int index) {
    if (size + 1 == array.length) {
      resizeList();
    }
    array[index] = object;
    size++;
  }

  /**
   * Multiply array size by 2. Method is private for security reasons.
   */
  private void resizeList() {
    T[] newarray = (T[]) new Number[size + 1 * 2];
    for (int i = 0; i < size; i++) {
      newarray[i] = array[i];
    }
    array = newarray;
  }

  public T get(int index) {
    return array[index];
  }

  /**
   * Removes element and index and resizes the array. Returns the removed element as in ArrayList.
   */
  public T remove(int index) {
    //This field is final mostly due to checkstyle (VariableDeclarationUsageDistance)
    //@SuppressWarnings is not allowed
    final T removedElement = array[index];
    for (int i = index; i < array.length - 1; i++) {
      array[i] = array[i + 1];
    }
    array[size] = null;
    size--;
    return removedElement;
  }

  /**
   * Returns the copy of list.
   */
  public MyCoolList copyList() {
    MyCoolList<T> newlist = new MyCoolList();
    for (int i = 0; i < size; i++) {
      newlist.add(array[i]);
    }
    return newlist;
  }


  public void set(T e, int i) {
    array[i] = e;
  }

  //Java 8 shenanigans

  /**
   * apply R apply(T t) Applies this function to the given argument. Parameters: t - the function
   * argument Returns: the function result
   */
  public MyCoolList<T> map(Function<T, T> f) {
    MyCoolList<T> list = this.copyList();
    for (int i = 0; i < size; i++) {
      //I dislike this, but the only other solution I see is to set array[] to protected
      T element = list.get(i);
      element = f.apply(list.get(i));
      list.set(element, i);
    }
    return list;
  }

  public int size() {
    return size;
  }

  public ListIterator iterator() {
    return new ListIterator();
  }

  /**
   * Inner classes exist only inside an object of class. Therefore they are unavailable outside of
   * this instance. Another important detail is that inner classes cannot have static declarations.
   * Static nested classes on the other hand are unable to access non-static fields and methods
   * without a reference of outer class.
   * Static nested classes are more efficient memory-wise and they are also useful for the purposes
   * of encapsulation.
   */
  protected class ListIterator implements Iterator<T> {

    private int current = 0;

    public boolean hasNext() {
      return (array[current + 1] != null);
    }

    /**
     * Returns next list element if it exists.
     */
    public T next() {
      if (!hasNext()) {
        throw new NoSuchElementException();
      } else {
        current++;
        return array[current];
      }
    }

    public void remove() {
      MyCoolList.this.remove(current);
      current--;
    }
  }

}
