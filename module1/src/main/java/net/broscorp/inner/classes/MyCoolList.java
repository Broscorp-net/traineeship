package net.broscorp.inner.classes;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;
import java.util.function.Function;
import java.util.stream.Collectors;

public class MyCoolList<T extends Number> implements Iterable<T> {

  private T[] collection;
  private int lastIndex;

  @SuppressWarnings("unchecked")
  public MyCoolList() {
    collection = (T[]) Array.newInstance(java.lang.Number.class, 10);
    lastIndex = -1;
  }

  private MyCoolList(T[] collection) {
    this.collection = collection;
    lastIndex = collection.length - 1;
  }

  /**
   * Appends the object to the end of this list.
   *
   * @param o the object to store.
   */
  public void add(T o) {
    final int allocatedMemory = collection.length;
    if (lastIndex + 1 == allocatedMemory) {
      collection = Arrays.copyOf(collection, allocatedMemory * 2);
    }

    collection[++lastIndex] = o;
  }

  /**
   * Returns the element at the specified position in this list.
   *
   * @param index index of the element to return.
   * @return the element at the specified position in this list.
   * @throws IndexOutOfBoundsException if the index is out of range.
   */
  public T get(int index) {
    if (!isValidIndex(index)) {
      throw new IndexOutOfBoundsException("Index " + index + " is out of range");
    }

    return collection[index];
  }

  /**
   * Removes the element at the specified position in this list.
   *
   * @param index the index of the element to be removed.
   * @return the element previously at the specified position.
   * @throws IndexOutOfBoundsException if the index is out of range.
   */
  public T remove(int index) {
    if (!isValidIndex(index)) {
      throw new IndexOutOfBoundsException("Index " + index + " is out of range");
    }

    T removed = collection[index];
    if (lastIndex - index >= 0) {
      System.arraycopy(collection, index + 1, collection, index, lastIndex - index);
    }

    lastIndex--;
    return removed;
  }

  /**
   * Returns a list consisting of the results of applying the given function to the elements of this
   * list.
   *
   * @param f   the function to apply to each element.
   * @param <R> the element type of the new list.
   * @return the new list.
   */
  @SuppressWarnings("unchecked")
  public <R extends Number> MyCoolList<R> map(Function<T, R> f) {
    final int size = lastIndex + 1;
    R[] mappedCollection = (R[]) Array.newInstance(java.lang.Number.class, size);

    for (int i = 0; i < size; i++) {
      mappedCollection[i] = f.apply(collection[i]);
    }

    return new MyCoolList<>(mappedCollection);
  }

  public int size() {
    return lastIndex + 1;
  }

  @Override
  public Iterator<T> iterator() {
    return new MyCoolListIterator();
  }

  private boolean isValidIndex(int index) {
    return index >= 0 && index < (lastIndex + 1);
  }

  /**
   * The difference between inner classes and static nested classes.
   * <p>
   * An inner class has behavior of a normal class, but is associated with an instance of its
   * enclosing class and has direct access to the outer class's methods and fields. It cant define
   * any static members itself.
   * </p>
   * <p>
   * A static nested class is associated with its enclosing class, but it cant refer directly to
   * members of the outer class, it must use an object reference to do this. A static nested class
   * can access the static members of an outer class.
   * </p>
   */
  private class MyCoolListIterator implements Iterator<T> {

    private int index = 0;

    @Override
    public boolean hasNext() {
      return index <= lastIndex;
    }

    @Override
    public T next() {
      return get(index++);
    }

    @Override
    public void remove() {
      MyCoolList.this.remove(index);
    }
  }

}
