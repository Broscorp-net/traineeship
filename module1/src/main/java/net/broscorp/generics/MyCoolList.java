package net.broscorp.generics;

/** javadoc. */
import java.util.ArrayList;

import java.util.List;

import java.util.function.Function;

import java.util.stream.Collectors;

/**
 * I could've implement it using native Java array or bi-directional linked list, but since task
 * relates only to generics I made a simple wrapper around class ArrayList.
 */
public class MyCoolList<T extends Number> {

  public List<T> myList = new ArrayList<>();

  public void add(T o) {
    myList.add(o);
  }

  public T get(int index) {
    return myList.get(index);
  }

  public void remove(int index) {
    myList.remove(index);
  }

  /** map. */
  public <P extends Number> MyCoolList<P> map(Function<T, P> f) {
    MyCoolList<P> newList = new MyCoolList<>();
    newList.myList = this.myList.stream().map(f).collect(Collectors.toList());
    return newList;
  }

  public int size() {
    return myList.size();
  }
}
