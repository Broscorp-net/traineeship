package net.broscorp.generics;

import java.util.Arrays;
import java.util.function.Function;

public class MyCoolList<E extends Number> {

  private Object[] array;
  private int size = 0;

  /**
   * Method that add elements into list.
   */
  public <T> void add(E e) {
    if (size == 0) {
      size++;
      array = new Object[]{e};
    } else {
      Object[] newArray = Arrays.copyOf(array, ++size);
      array = Arrays.copyOf(newArray, size);
      array[size - 1] = e;
    }
  }

  /**
   * Method that gives elements from list.
   */
  public E get(int index) {
    try {
      return (E) array[index];
    } catch (ArrayIndexOutOfBoundsException ex) {
      throw new ArrayIndexOutOfBoundsException(
          "Trying to get element " + index + " but last index is " + size());
    }
  }

  /**
   * Method that delete elements from list.
   */
  public E remove(int index) {
    E deletedObject = null;
    if (index < size()) {
      if (size != 0) {
        Object[] newArray = new Object[--size];
        deletedObject = (E) array[index];
        if (index == 0) {
          System.arraycopy(array, 1, newArray, 0, size);
        } else if (index == size) {
          System.arraycopy(array, 0, newArray, 0, size);
        } else {
          System.arraycopy(array, 0, newArray, 0, index);
          System.arraycopy(array, index + 1, newArray, index, size - index);
        }
        array = Arrays.copyOf(newArray, size);
      }
    } else {
      throw new ArrayIndexOutOfBoundsException(
          "Trying to remove element " + index + " but last index is " + size());
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
