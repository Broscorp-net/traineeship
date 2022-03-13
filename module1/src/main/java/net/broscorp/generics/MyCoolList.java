package net.broscorp.generics;

import java.util.Arrays;
import java.util.function.Function;

public class MyCoolList<T extends Number> {

  private T[] numbers;
  private int size;
  private Function func;

  public MyCoolList() {
    this.numbers = (T[]) new Number[0];
    this.size = 0;
  }

  public void add(T o) {
    size++;
    numbers = extendList();
    numbers[size - 1] = o;
    System.gc();
  }

  public T get(int index) {

    if (index < size) {
      return numbers[index];
    }

    return null;
  }

  public T remove(int index) {
    int newSize = size - 1;
    T[] newList = Arrays.copyOf(numbers, newSize);
    T removed = get(index);

    for (int j = index; j < newSize; j++) {
      newList[j] = numbers[j + 1];
    }

    numbers = newList;
    size = newSize;
    System.gc();
    return removed;
  }

  private T[] extendList() {
    return Arrays.copyOf(numbers, size);
  }

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
