package net.broscorp.generics;

import java.util.*;
import java.util.function.Function;

public class MyCoolList<T extends Number> {

  private int size = 10;
  private Object[] array = new Object[size];
  private int counter = 0;

  /**
   * Adds elem to the list.
   * @param o - object to add.
   */
  public void add(T o) {
    if (o == null) {
      throw new NullPointerException();
    }
    if (counter >= size - 1) {
      Object[] tempArr = Arrays.stream(array).filter(Objects::nonNull).toArray(Object[]::new);

      this.size *= 2;
      this.array = Arrays.copyOf(tempArr, this.size);
    }
    this.array[counter] = o;
    ++counter;
  }

  /**
   * Gets element by index.
   * @param index - index of the list.
   * @return - element by index.
   */
  public T get(int index) {
    if (index < size - 1) {
      return (T) this.array[index];
    } else if (this.array[index] == null) {
      throw new NoSuchElementException();
    } else {
      throw new ArrayIndexOutOfBoundsException();
    }
  }

  /**
   * Removes elem by index.
   * @param index - index of the list.
   * @return removed element;
   */
  public T remove(int index) {
    Object temp = this.array[index];

    int nonNullIndex = 0;

    for (int i = index; i < array.length - 1; i++) {
      if (this.array[index] != null) {
        this.array[index] = this.array[index + 1];
      } else {
        nonNullIndex = index - 1;
      }
    }

    this.array[nonNullIndex] = null;

    return (T) temp;
  }

  /**
   * Converts elems of the list according to lambda.
   * @param f - lambda.
   * @param <R> - class type to be converted.
   * @return new list with changed elems.
   */
  public <R extends Number> MyCoolList<R> map(Function<T, R> f) {
    MyCoolList<R> myCoolList = new MyCoolList<>();

    List<T> tempList = new ArrayList<>();

    for (int i = 0; i < this.size(); i++) {
      tempList.add((T) this.get(i));
    }

    for (int i = 0; i < tempList.size(); i++) {
      R r = f.apply(tempList.get(i));
      myCoolList.add(r);
    }

    return myCoolList;
  }

  public int size() {
    return (int) Arrays.stream(this.array).filter(Objects::nonNull).count();
  }


}
