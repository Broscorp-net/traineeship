package net.broscorp.generics;

import java.util.function.Function;

public class MyCoolList<T extends Number> {

  private Object[] myCoolList;
  private int curSize = 0;
  private int defSize = 5;

  public MyCoolList() {
    myCoolList = new Object[defSize];
  }

  public MyCoolList(Integer size) {
    myCoolList = new Object[size];
    defSize = size;
  }

  /**
   * Array adding method.
   *
   * @param o - object for add
   */
  public void add(T o) {
    if (curSize == myCoolList.length) {
      defSize = size() * 2;
      Object[] arr = new Object[defSize];
      System.arraycopy(myCoolList, 0, arr, 0, size());
      arr[curSize++] = o;
      myCoolList = arr;
    } else {
      myCoolList[curSize++] = o;
    }
  }

  /**
   * Method for getting object by index.
   *
   * @param index index getting element
   * @return getting object by index or exception
   */
  public T get(int index) {
    if (index < 0 || index > size() - 1) {
      throw new ArrayIndexOutOfBoundsException();
    } else {
      return (T) myCoolList[index];
    }
  }

  /**
   * Method to remove an element from an array.
   *
   * @param index - index for delete
   * @return - deleted object by index
   */
  public T remove(int index) {
    int el = size();
    if (index >= size() || index < 0) {
      System.out.println("Error!");
      throw new ArrayIndexOutOfBoundsException();
    } else {
      Object[] cop = new Object[size() - 1];
      int k = 0;
      for (int i = 0; i < el; i++) { //copy
        if (i != index) {
          cop[k] = myCoolList[i];
          k++;
        }
      }
      T deletedObj = (T) myCoolList[index];
      myCoolList = cop;
      curSize--;
      return deletedObj;
    }
  }

  /**
   * Converting one value to another.
   *
   * @param f   - function variable
   * @param <R> - result type received from T
   * @return - list
   */
  public <R extends Number> MyCoolList<R> map(Function<T, R> f) {
    MyCoolList<R> listR = new MyCoolList<>();
    for (int i = 0; i < size(); i++) {
      listR.add(f.apply((T) myCoolList[i]));
    }
    return listR;
  }

  public int size() {
    return curSize;
  }

}
