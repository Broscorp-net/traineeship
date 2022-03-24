package net.broscorp.generics;

import java.util.Arrays;
import java.util.function.Function;

/**
 * Something that extends Number.
 */
public class MyCoolList<T extends Number> {

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
      return removed;
    }
    throw new RuntimeException("Element with this index does not exist");
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

}
