package net.broscorp.generics;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Function;

public class MyCoolList<T extends Number> {

  private List<T> objectArray;

  public MyCoolList() {
    objectArray = new ArrayList<>();
  }

  public void add(T object) {
    objectArray.add(object);
  }

  public T get(int index) {
    return objectArray.get(index);
  }

  /**
   * remove method.
   * @param index - index
   */
  public void remove(int index) {
    objectArray.remove(index);
  }

  /**
   * map method.
   * @param f - function
   * @param <R> - type
   * @return new CoolList
   */
  public <R extends Number> MyCoolList<R> map(Function f) {
    MyCoolList<R> myCoolList = new MyCoolList<>();
    for (T t: objectArray) {
      myCoolList.add((R) f.apply(t));
    }
    return myCoolList;
  }

  public int size() {
    return objectArray.size();
  }
}
