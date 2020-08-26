package net.broscorp.generics;

import java.util.Arrays;
import java.util.function.Function;

public class MyCoolList<T extends Number> {

  private T[] objectArray;
  private int size;

  public MyCoolList() {
    size = 0;
    objectArray = (T[]) new Number[size];
  }

  public void add(T object) {
    resize(++size);
    objectArray[size - 1] = object;
  }

  public T get(int index) {
    return objectArray[index];
  }

  /**
   * remove method.
   * @param index - index
   */
  public void remove(int index) {
    if (index >= 0 && index < size) {
      for (int i = index; i < size - 1; i++) {
        objectArray[i] = objectArray[i + 1];
      }
      resize(--size);
    } else {
      throw new ArrayIndexOutOfBoundsException();
    }
  }

  /**
   * map method.
   * @param f - function
   * @param <R> - type
   * @return new CoolList
   */
  public <R extends Number> MyCoolList<R> map(Function f) {
    MyCoolList<R> myCoolList = new MyCoolList<>();
    for (T t: objectArray) {
      myCoolList.add((R) f.apply(t));
    }
    return myCoolList;
  }

  public int size() {
    return size;
  }

  private void resize(int newSize) {
    objectArray = Arrays.copyOf(objectArray, newSize);
  }
}
