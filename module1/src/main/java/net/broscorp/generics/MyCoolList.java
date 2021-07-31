package net.broscorp.generics;

import java.util.ArrayList;

import java.util.List;

import java.util.function.Function;

import java.util.stream.Collectors;

/**
 * I could've implement it using native Java array or bi-directional linked list, but since task
 * relates only to generics I made a simple wrapper around class ArrayList.
 */
public class MyCoolList<T> {

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

  public MyCoolList<T> map(Function<T, T> f) {
    MyCoolList<T> newList = new MyCoolList<>();
    newList.myList = this.myList.stream().map(f).collect(Collectors.toList());
    return newList;
  }

  public int size() {
    return myList.size();
  }
}
