package net.broscorp.generics;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Function;
import java.util.stream.Collectors;

public class MyCoolList<T extends Number> {

  protected List<T> list = new ArrayList<>();

  public void add(T o) {
    list.add(o);
  }

  public T get(int index) {
    return list.get(index);
  }

  /**
   * Remove element by index.
   *
   * @param index index of element of array.
   * @return returns removed element.
   */
  public T remove(int index) {
    T item = list.get(index);
    list.remove(index);
    return item;
  }

  /**
   * Applies passed function to every element of list.
   *
   * @param f function to be applied.
   * @return return new exemplar of object with new list.
   */
  public MyCoolList<T> map(Function<T, T> f) {
    MyCoolList<T> newList = new MyCoolList<>();
    newList.list = list.stream().map(f).collect(Collectors.toList());
    return newList;
  }

  public int size() {
    return this.list.size();
  }

}
