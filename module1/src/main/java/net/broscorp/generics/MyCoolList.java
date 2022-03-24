package net.broscorp.generics;

import java.util.function.Function;

public class MyCoolList<T extends Number> {

  private int size;
  private static final int DEFAULT_CAPACITY = 10;
  private T[] array;

  public MyCoolList() {
    array = (T[]) new Number[DEFAULT_CAPACITY];
  }

  public void add(T object) {
    add(object, size);
  }

  /**
   * Receives the object and its index inside array.
   */
  public void add(T object, int index) {
    if (index > size || index < 0) {
      throw new RuntimeException("Index out of bounds at MyCoolList.remove()");
    } else if (index == size && index + 1 == array.length) {
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

    if (index > size || index < 0) {
      throw new RuntimeException("Index out of bounds at MyCoolList.remove()");
    }

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

  //Java 8 shenanigans

  /**
   * Apply R(T t). Applies this function to the given argument. Parameters: t - the function
   * argument. Returns: the function result
   */
  public <R extends Number> MyCoolList<R> map(Function<T, R> f) {
    MyCoolList<R> list = this.copyList();
    for (int i = 0; i < size; i++) {
      //I dislike this, but the only other solution I see is to set array[] to protected
      R element = list.get(i);
      element = f.apply((T)list.get(i));
      list.array[i] = element;
    }
    return list;
  }

  public int size() {
    return size;
  }

}
