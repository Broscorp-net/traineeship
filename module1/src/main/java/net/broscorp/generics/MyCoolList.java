package net.broscorp.generics;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Function;
import java.util.stream.Collectors;

public class MyCoolList<T extends Number> {

  private List<T> list = new ArrayList<>();

  public void add(T o) {
    this.list.add(o);
  }

  public T get(int index) {
    return this.list.get(index);
  }

  public T remove(int index) {
    return this.list.remove(index);
  }

  /**
   * Map wrapping.
   * @param f - the function for mapping.
   * @param <R> - the type for the output list.
   * @return the new list.
   */
  public <R extends Number> MyCoolList<R> map(Function<T, R> f) {
    MyCoolList<R> mappedList = new MyCoolList<>();
    mappedList.setList(
        list.stream().map(f).collect(Collectors.toList())
    );
    return mappedList;
  }

  public int size() {
    return this.list.size();
  }

  private void setList(List<T> list) {
    this.list = list;
  }

}
