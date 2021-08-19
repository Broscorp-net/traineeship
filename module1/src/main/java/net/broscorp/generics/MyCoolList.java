package net.broscorp.generics;

import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.function.Function;

public class MyCoolList<T extends Number> {

  private T[] collection;
  private int lastIndex;

  public MyCoolList() {
    collection = malloc(10);
    lastIndex = -1;
  }

  private MyCoolList(T[] collection) {
    this.collection = collection;
    lastIndex = collection.length - 1;
  }

  /**
   * Appends the object to the end of this list.
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
   * @param index index of the element to return.
   * @return the element at the specified position in this list.
   * @throws IndexOutOfBoundsException if the index is out of range.
   */
  public T get(int index) {
    if (!isValidIndex(index)) {
      throw new IndexOutOfBoundsException();
    }

    return collection[index];
  }

  /**
   * Removes the element at the specified position in this list.
   * @param index the index of the element to be removed.
   * @return the element previously at the specified position.
   * @throws IndexOutOfBoundsException if the index is out of range.
   */
  public T remove(int index) {
    if (!isValidIndex(index)) {
      throw new IndexOutOfBoundsException();
    }

    T removed = collection[index];
    if (lastIndex - index >= 0) {
      System.arraycopy(collection, index + 1, collection, index, lastIndex - index);
    }

    lastIndex--;
    return removed;
  }

  /**
   * Returns a list consisting of the results of applying the given
   * function to the elements of this list.
   * @param f the function to apply to each element.
   * @param <R> the element type of the new list.
   * @return the new list.
   */
  public <R extends Number> MyCoolList<R> map(Function<T, R> f) {

    final int size = lastIndex + 1;
    R[] mappedCollection = malloc(size);

    for (int i = 0; i < size; i++) {
      mappedCollection[i] = f.apply(collection[i]);
    }

    return new MyCoolList<>(mappedCollection);
  }

  public int size() {
    return lastIndex + 1;
  }

  private boolean isValidIndex(int index) {
    return index >= 0 && index < (lastIndex + 1);
  }

  @SuppressWarnings("unchecked")
  private <E extends Number> E[] malloc(int size) {
    return (E[]) Array.newInstance(java.lang.Number.class, size);
  }

}
