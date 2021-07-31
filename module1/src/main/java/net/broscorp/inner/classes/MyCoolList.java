package net.broscorp.inner.classes;

/** javadoc. */
import java.util.ArrayList;

import java.util.Iterator;
import java.util.List;

import java.util.NoSuchElementException;
import java.util.function.Function;

import java.util.stream.Collectors;

/**
 * I could've implement it using native Java array or bi-directional linked list, but since task
 * relates only to generics I made a simple wrapper around class ArrayList.
 */
public class MyCoolList<T> implements Iterable {

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
  public MyCoolList<T> map(Function<T, T> f) {
    MyCoolList<T> newList = new MyCoolList<>();
    newList.myList = this.myList.stream().map(f).collect(Collectors.toList());
    return newList;
  }

  public int size() {
    return myList.size();
  }

  @Override
  public Iterator iterator() {

    return new Itr();
  }

  /**
   * a static nested class has access to the fields of the external class only with the static modifier
   * or by accessing the name of the implemented object of the outer class,
   * and not the static one can access all the fields of the external class
   */
  class Itr implements Iterator<T> {
    int cursor;

    @Override
    public boolean hasNext() {
      return cursor != myList.size();
    }

    @Override
    public T next() {
      int i = cursor;
      if (i >= myList.size()) {
        throw new NoSuchElementException();
      }
      int currCursor = cursor;
      cursor++;
      return myList.get(currCursor);
    }
  }
}
