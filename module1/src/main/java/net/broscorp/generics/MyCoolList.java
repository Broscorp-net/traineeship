package net.broscorp.generics;

import java.util.Arrays;
import java.util.Iterator;
import java.util.function.Function;

public class MyCoolList<T extends Number> implements Iterable<T> {

  private Number[] storeArray = {};

  public void setStoreArray(Number[] storeArray) {
    this.storeArray = storeArray;
  }

  /**
   * Appends the specified element to the end of this list.
   *
   * @param newElement element to be appended to this list
   */
  public void add(T newElement) {
    Number[] newStoreArray = new Number[(int) (storeArray.length + 1)];
    System.arraycopy(storeArray, 0, newStoreArray, 0, storeArray.length);
    storeArray = newStoreArray;
    storeArray[storeArray.length - 1] = newElement;
  }

  /**
   * Returns the element at the specified position in this list.
   *
   * @param index – index of the element to return
   * @return the element at the specified position in this list
   */
  public T get(int index) {
    try {
      return (T) storeArray[index];
    } catch (ArrayIndexOutOfBoundsException ex) {
      return null;
    }
  }

  /**
   * Removes the element at the specified position in this list.
   *
   * @param index – index of the element to remove
   * @return the removed element
   */
  public T remove(int index) {
    try {
      final T removedElement = (T) storeArray[index];
      System.arraycopy(storeArray, index + 1, storeArray, index, storeArray.length - (index + 1));
      storeArray = Arrays.copyOfRange(storeArray, 0, storeArray.length - 1);
      return removedElement;
    } catch (ArrayIndexOutOfBoundsException ex) {
      return null;
    }
  }

  /**
   * Applies the specified function to each element in this list.
   *
   * @param f – function to be applied
   * @return the new list in which the elements are the results of the function
   */
  public <R extends Number> MyCoolList<R> map(Function<T, R> f) {
    MyCoolList<R> mappedList = new MyCoolList<>();
    mappedList.setStoreArray(
        Arrays.stream(storeArray).map(n -> f.apply((T) n)).toArray(Number[]::new));
    return mappedList;
  }

  public int size() {
    return storeArray.length;
  }

  @Override
  public String toString() {
    return Arrays.toString(storeArray);
  }

  @Override
  public Iterator<T> iterator() {
    return new MyCoolListIterator();
  }

  /**
   * The difference between a static nested class and an inner class is as follows: 1) an object of
   * a regular inner class stores a reference to an object of an outer class, but one of static
   * nested class does not; 2) an object of a static nested class can be created without creating an
   * object of an outer class; 3) from an object of a static nested class it is impossible to access
   * the non-static members of the outer class directly, but only through a reference to an instance
   * of the outer class; 4) inner classes cannot have static declarations.
   */
  class MyCoolListIterator implements Iterator<T> {
    private int nextIndex;
    private T nextElement;
    private int returnedByNextElementIndex;

    public MyCoolListIterator() {
      nextElement = get(nextIndex);
    }

    @Override
    public boolean hasNext() {
      return nextElement != null;
    }

    @Override
    public T next() {
      returnedByNextElementIndex = nextIndex;
      T returnedByNextElement = nextElement;
      nextIndex++;
      nextElement = get(nextIndex);
      return returnedByNextElement;
    }

    @Override
    public void remove() {
      MyCoolList.this.remove(returnedByNextElementIndex);
    }
  }
}
