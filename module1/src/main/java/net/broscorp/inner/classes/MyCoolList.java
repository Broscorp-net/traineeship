package net.broscorp.inner.classes;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.NoSuchElementException;
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
   *
   * @param f   function
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

  public Iterator<T> getIterator() {
    return new InnerIterator();
  }

  /**
   * InnerClass has access to all variables and methods of the OuterClass.
   * StaticInnerClass has access only to static variables and static methods of the OuterClass.
   */
  private class InnerIterator implements Iterator<T> {

    private int index;

    public InnerIterator() {
      this.index = 0;
    }

    @Override
    public boolean hasNext() {
      return index < list.size();
    }

    @Override
    public T next() {
      if (hasNext()) {
        return list.get(index++);
      }
      throw new NoSuchElementException();
    }
  }
}
