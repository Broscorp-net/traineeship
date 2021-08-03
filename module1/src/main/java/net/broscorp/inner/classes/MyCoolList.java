package net.broscorp.inner.classes;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.function.Function;
import java.util.stream.Collectors;

public class MyCoolList<T extends Number> implements Iterable<T> {

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
   *
   * @param f   - the function for mapping.
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

  @Override
  public Iterator<T> iterator() {
    return new MyCoolListIterator();
  }

  private void setList(List<T> list) {
    this.list = list;
  }

  /** The difference between inner classes and static nested classes.
   *  <p>
   *  An inner class has behavior of a normal class, but is associated with
   *  an instance of its enclosing class and has direct access to the outer
   *  class's methods and fields. It cant define any static members itself.
   *  </p>
   *  <p>
   *  A static nested class is associated with its enclosing class, but it cant
   *  refer directly to members of the outer class, it must use an object reference to do this.
   *  A static nested class can access the static members of an outer class.
   *  </p>
   */
  private class MyCoolListIterator implements Iterator<T> {

    private int index = 0;

    @Override
    public boolean hasNext() {
      return index <= (size() - 1);
    }

    @Override
    public T next() {
      T item = list.get(index);
      index += 1;
      return item;
    }

    @Override
    public void remove() {
      list.remove(index);
    }
  }

}
