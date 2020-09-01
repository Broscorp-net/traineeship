package net.broscorp.generics;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Function;

public class MyCoolList<T extends Number> {
  private List<T> list;

  public MyCoolList() {
    list = new ArrayList();
  }

  public void add(T o) {
    list.add(o);
  }

  public Object get(int index) {
    return list.get(index);
  }

  public Object remove(int index) {
    return list.remove(index);
  }

  /**
   * Convert List from one Type to another.
   *
   * @param f   Function
   * @param <R> Type
   * @return
   */
  public <R extends Number> MyCoolList<R> map(Function f) {
    MyCoolList<R> myCoolList = new MyCoolList<>();
    for (T object : list) {
      myCoolList.add((R) f.apply(object));
    }
    return myCoolList;
  }

  public int size() {
    return list.size();
  }
}
