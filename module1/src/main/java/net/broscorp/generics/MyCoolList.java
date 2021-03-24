package net.broscorp.generics;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Function;

public class MyCoolList<T extends Number> {
  private List<T> list = new ArrayList<>();

  public void add(T number) {
    list.add(number);
  }

  public T get(int index) {
    return list.get(index);
  }

  public T remove(int index) {
    return list.remove(index);
  }

  /**
   * Method for casting a type in a list.
   * @param f function
   * @param <R> required type
   * @return list with required type
   */
  public <R extends Number> MyCoolList<R> map(Function<T, R> f) {
    MyCoolList<R> myCoolList = new MyCoolList();
    list.forEach(x -> myCoolList.add(f.apply(x)));
    return myCoolList;
  }

  public int size() {
    return list.size();
  }
}
