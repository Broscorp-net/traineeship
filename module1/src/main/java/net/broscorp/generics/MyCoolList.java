package net.broscorp.generics;

import java.util.Arrays;
import java.util.function.Function;

public class MyCoolList<T extends Number> {

  private Number[] coolList;
  private final int DEFAULT_CAPACITY = 16;
  private int size = 0;


  /**
   * Constructor Create CoolList with default capacity;
   */
  public MyCoolList() {
    this.coolList = new Number[DEFAULT_CAPACITY];
  }

  /**
   * Constructor Create CoolList with user capacity
   */
  public MyCoolList(int capacity) {
    if (capacity > 0) {
      this.coolList = new Number[capacity];
    } else {
      throw new IllegalArgumentException("Not illegal argument " + capacity);
    }
  }

  /**
   * @param o - added object If the array is full, a new array will be created with a capacity
   *          greater than 1.5 See: extendsUp() method
   */
  public void add(Number o) {
    if (size == coolList.length) {
      coolList = extendUpList();
    }
    coolList[size] = o;
    size++;
  }

  public Number get(int index) {
    checkedIndex(index);
    return coolList[index];
  }

  public Number remove(int index) {
    Number removeObject = get(index);

    int numMoved = size - 1;
    if (numMoved > 0) {
      System.arraycopy(coolList, index + 1, coolList, index,
          numMoved);
    }
    coolList[--size] = null;

    return removeObject;
  }

  public <R extends Number> MyCoolList<R> map(Function<T, R> f) {
    MyCoolList<R> myCoolList = new MyCoolList<>(size);

    for (int i = 0; i < size; i++) {
      myCoolList.add(f.apply((T) coolList[i]));
    }
    return myCoolList;
  }

  public int size() {
    return size;
  }

  private Number[] extendUpList() {
    return Arrays.copyOf(coolList, (int) (size * 1.5));
  }

  private void checkedIndex(int index) {
    if (index < 0 || index > size) {
      throw new IndexOutOfBoundsException();
    }
  }

}
