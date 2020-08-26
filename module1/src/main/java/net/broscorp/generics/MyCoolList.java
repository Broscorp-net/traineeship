package net.broscorp.generics;

import java.util.ArrayList;
import java.util.function.Function;


public class MyCoolList<T extends Number> {

  private ArrayList<T> list = new ArrayList<>();

  public void add(T a) {
    list.add(a);
  }

  public Object get(int index) {
    return list.get(index);
  }

  public void remove(int index) {
    list.remove(list.get(index));
  }

  /**
   * map.
   *
   */
  public <R extends Number> MyCoolList<R> map(Function f) {
    MyCoolList<R> myCoolList = new MyCoolList<>();
    for (Object a : list) {
      myCoolList.add((R) f.apply(a));
    }
    return myCoolList;
  }

  public int size() {
    return list.size();
  }

}
