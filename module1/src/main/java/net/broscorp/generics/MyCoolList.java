package net.broscorp.generics;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.function.Function;

public class MyCoolList<E extends Number> {

  private Object[] array;
  private int size = 0;

  public MyCoolList() {
    Object[] array = new Object[size];
  }

  public static void main(String[] args) {
    MyCoolList<Integer> myCoolList = new MyCoolList<>();
  }

  /**
   * Method that add elements into list.
   */
  public <T extends E> void add(T t) {
    if (size == 0) {
      size++;
      array = new Object[]{t};
    } else {
      Object[] newArray = Arrays.copyOf(array, ++size);
      array = Arrays.copyOf(newArray, size);
      array[size - 1] = t;
    }
  }

  /**
   * Method that gives elements from list.
   */
  public E get(int index) {
    try {
      return (E) array[index];
    } catch (IndexOutOfBoundsException ex) {
      ex.printStackTrace();
      return null;
    }
  }

  /**
   * Method that delete elements from list.
   */
  public E remove(int index) {
    E deletedObject = null;
    try {
      if (size != 0) {
        Object[] newArray = new Object[--size];
        if (index == 0) {
          deletedObject = (E) array[0];
          System.arraycopy(array, 1, newArray, 0, size);
        } else if (index == size) {
          deletedObject = (E) array[size];
          System.arraycopy(array, 0, newArray, 0, size);
        } else {
          deletedObject = (E) array[index];
          System.arraycopy(array, 0, newArray, 0, index);
          System.arraycopy(array, index + 1, newArray, index, size - index);
        }
        array = Arrays.copyOf(newArray, size);
      }
    } catch (ArrayIndexOutOfBoundsException ex) {
      ex.printStackTrace();
    }
    return deletedObject;
  }

  /**
   * Method that converting elements in a list.
   */
  public MyCoolList<E> map(Function<E, E> f) {
    MyCoolList<E> myCoolList = new MyCoolList<>();
    for (int i = 0; i < this.size(); i++) {
      myCoolList.add(f.apply(this.get(i)));
    }
    return myCoolList;
  }

  /**
   * Method that return count of elements in list.
   */
  public int size() {
    return size;
  }

}
