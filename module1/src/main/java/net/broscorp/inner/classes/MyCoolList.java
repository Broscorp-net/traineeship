/*
 * Copyright (c) 2021.
 * Danylo Havrylchenko
 * GitHub: @akellanotavailable
 */

package net.broscorp.inner.classes;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.stream.Collectors;

public class MyCoolList<T extends Number> implements Iterable<T> {


  protected List<T> list = new ArrayList<>();
  protected final ListIterator iterator = new ListIterator();

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

  public T remove(T element) {
    list.remove(element);
    return element;
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

  public Iterator<T> iterator() {
    return new ListIterator();
  }

  private class ListIterator implements Iterator<T> {

    @Override
    public void forEachRemaining(Consumer<? super T> action) {
      Iterator.super.forEachRemaining(action);
    }

    private int index = 0;

    @Override
    public boolean hasNext() {
      return list.size() > index;
    }

    @Override
    public T next() {
      return list.get(index++);
    }

    @Override
    public void remove() {
      list.remove(--index);
    }

  }
}
