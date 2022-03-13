package net.broscorp.generics;

import java.util.function.Function;

public class MyCoolList<T extends Number> {

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

  /**
   * Get element of collection by index.
   *
   * @param index int
   * @return Object
   */
  public Object get(int index) {
    checkIndexRange(index);
    return array[index];
  }

  /**
   * Removes a single instance of the specified element from this collection.
   *
   * @param index int
   * @return removed object, if an element was removed
   * @throws NullPointerException if the specified element is null and this
   *                              collection does not permit null elements
   * @throws IndexOutOfBoundsException if index illegal in this collection
   */
  public Object remove(int index) {
    checkIndexRange(index);

    Object removed = get(index);

    int removeIndex = -1;
    Object[] newArray = new Object[array.length];

    for (int i = 0; i < size; i++) {
      if (array[i].equals(removed) || array[i] == removed) {
        removeIndex = i;

        System.arraycopy(array, 0, newArray, 0, removeIndex);
        System.arraycopy(array, removeIndex + 1, newArray, removeIndex,
            size - (removeIndex + 1));

        size = size - 1;
        this.array = newArray;
        break;
      }
    }
    return removed;
  }

  /**
   * Use function for all elements.
   *
   * @param f function
   * @return MyCoolList
   */
  public <R extends Number> MyCoolList<R> map(Function<T, R> f) {
    MyCoolList<R> newList = new MyCoolList<>(size);

    for (int i = 0; i < size; i++) {
      newList.add(f.apply((T) array[i]));
    }

    return newList;
  }

  /**
   * Returns the number of elements in this collection.
   *
   * @return int
   */
  public int size() {
    return size;
  }

  /**
   * additional method for check index range and throw exception if range illegal.
   *
   * @param index int
   * @throws IndexOutOfBoundsException if index illegal in this collection
   */
  private void checkIndexRange(int index) {
    if (index < 0 || index >= size) {
      throw new IndexOutOfBoundsException(
          String.format("Index %s out of bounds for length %s", index,
              size));
    }
  }
}
