package net.broscorp.generics;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Function;

public class MyCoolList<T extends Number> {

  private final List<T> myCoolList = new ArrayList<>();

  public void add(T o) {
    myCoolList.add(o);
  }

  public T get(int index) {
    return myCoolList.get(index);
  }

  public T remove(int index) {
    return myCoolList.remove(index);
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
    for (T t : myCoolList) {
      listR.add(f.apply(t));
    }
    return listR;
  }

  public int size() {
    return myCoolList.size();
  }

}
