package net.broscorp.generics;

import java.util.function.Function;

public class MyCoolList<T extends Number> {

  private Object[] myCoolList;

  public MyCoolList() {
    myCoolList = new Object[0];
  }

  public MyCoolList(Integer size) {
    myCoolList = new Object[size];
  }

  public void add(T o) {
    Object[] arr = new Object[size() + 1];
    System.arraycopy(myCoolList, 0, arr, 0, arr.length - 1);
    arr[arr.length - 1] = o;
    myCoolList = arr;
  }

  public T get(int index) {
    return (T) myCoolList[index];
  }

  public T remove(int index) {
    int el = size();
    if (index >= size() || index < 0) {
      System.out.println("Error!");
      return null;
    } else {
      Object[] cop = new Object[size() - 1];
      int k = 0;
      for (int i = 0; i < el; i++) { //copy
        if (i != index) {
          cop[k] = myCoolList[i];
          k++;
        }
      }
      T deletedIndex = (T) myCoolList[index];
      myCoolList = cop;
      return deletedIndex;
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
    for (Object t : myCoolList) {
      listR.add(f.apply((T) t));
    }
    return listR;
  }

  public int size() {
    return myCoolList.length;
  }

}
