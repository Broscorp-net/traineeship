package net.broscorp.generics;

import java.util.function.Function;

class MyCoolList<T extends Number> {

  private T[] listNumber;
  private int realSize = 0;

  @SuppressWarnings("unchecked")
  MyCoolList(int size) {
    this.listNumber = (T[]) new Number[size];
  }

  private MyCoolList(T[] collection) {
    this.listNumber = collection;
    this.realSize = collection.length;
  }

  /**
   * Add new object to Array. If necessary, the size of the array will increase.
   * @param o - numeric value.
   */
  void add(T o) {
    if (realSize == listNumber.length - 1) {
      increaseSize();
    }
    listNumber[realSize++] = o;
  }

  @SuppressWarnings("unchecked")
  <R extends Number> MyCoolList<R> map(Function<T, R> f) {
    R[] newCollection = (R[]) new Number[realSize];
    for (int i = 0; i < realSize; i++) {
      newCollection[i] = f.apply(listNumber[i]);
    }
    return new MyCoolList<>(newCollection);
  }

  /**
   * Return size of Array.
   * @return integer value.
   */
  int size() {
    return realSize;
  }

  /**
   * This method increase size of Array.
   */
  @SuppressWarnings("unchecked")
  private void increaseSize() {
    int newLength = listNumber.length * 3 / 2 + 1;
    T[] newArr = (T[]) new Number[newLength];
    System.arraycopy(listNumber, 0, newArr, 0, realSize);
    listNumber = newArr;
  }

  /**
   * getting element from Array by index.
   *
   * @param index - integer value, index of element.
   * @return element's value.
   */
  T get(int index) {
    return listNumber[index];
  }

  /**
   * remove element from Array by index.
   *
   * @param index - integer value, index of element.
   * @return removed element.
   */
  T remove(int index) {
    T removedObject = listNumber[index];
    System.arraycopy(listNumber, index + 1, listNumber, index, realSize - index);
    realSize--;
    return removedObject;
  }

}
