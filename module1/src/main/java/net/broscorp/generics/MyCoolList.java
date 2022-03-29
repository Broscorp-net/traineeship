package net.broscorp.generics;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Objects;
import java.util.function.Function;

public class MyCoolList<T extends Number> {

  private int capacity = 10;
  private Object[] array = new Object[capacity];
  private int counter = 0;

  private int size = 0;
  /**
   * Adds elem to the list.
   *
   * @param o - object to add.
   */
  public void add(T o) {
    if (counter >= capacity) {
      Object[] temp = Arrays.stream(this.array).toArray();
      this.capacity *= 2;

      this.array = Arrays.copyOf(temp, this.capacity);
    }
    ++size;
    this.array[counter] = o;
    ++counter;
    /*if (o == null) {
      throw new NullPointerException();
    }
    if (counter >= size - 1) {
      Object[] tempArr = Arrays.stream(array).filter(Objects::nonNull).toArray(Object[]::new);

      this.size *= 2;
      this.array = Arrays.copyOf(tempArr, this.size);
    }
    this.array[counter] = o;
    ++counter;*/
  }

  /**
   * Gets element by index.
   *
   * @param index - index of the list.
   * @return - element by index.
   */
  public T get(int index) {
    if (index < capacity - 1) {
      return (T) this.array[index];
    } else {
      throw new ArrayIndexOutOfBoundsException();
    }
  }

  /**
   * Removes elem by index.
   *
   * @param index - index of the list.
   * @return removed element;
   */
  public T remove(int index) {
    Object temp = this.array[index];

    for (int i = index; i < size; i++) {
      this.array[i] = this.array[i + 1];
    }

    --size;

    return (T) temp;
  }

  /**
   * Converts elems of the list according to lambda.
   *
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
    return size;
  }
}
