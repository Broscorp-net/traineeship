package net.broscorp.generics;

import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.function.Function;

public class MyCoolList<T extends Number> {

  private T[] collection;
  private int lastIndex;
  private int size;

  public MyCoolList() {
    this.collection = malloc(10);
    this.lastIndex = -1;
    this.size = 10;
  }

  private MyCoolList(T[] collection) {
    this.collection = collection;
    this.lastIndex = collection.length - 1;
    this.size = collection.length;
  }

  public void add(T o) {
    if (lastIndex + 1 == size) {
      collection = Arrays.copyOf(collection, size * 2);
    }

    collection[++lastIndex] = o;
  }

  public T get(int index) {
    if (!isValidIndex(index)) {
      throw new RuntimeException();
    }

    return collection[index];
  }

  public T remove(int index) {
    if (!isValidIndex(index)) {
      throw new RuntimeException();
    }

    T removed = collection[index];

    if (lastIndex - index >= 0) {
      System.arraycopy(collection, index + 1, collection, index, lastIndex - index);
    }

    lastIndex--;
    return removed;
  }

  /**
   * Map wrapping.
   * @param f - the function for mapping.
   * @param <R> - the type for the output list.
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
