package net.broscorp.generics;

import java.util.Arrays;
import java.util.ConcurrentModificationException;
import java.util.Iterator;
import java.util.NoSuchElementException;
import java.util.function.Function;

public class MyCoolList<T extends Number> {

  private Number[] coolList;
  private static final int DEFAULT_CAPACITY = 16;
  private int size = 0;


  /**
   * . Constructor Create CoolList with default capacity;
   */
  public MyCoolList() {
    this.coolList = new Number[DEFAULT_CAPACITY];
  }

  /**
   * . Constructor Create CoolList with user capacity
   */
  public MyCoolList(int capacity) {
    if (capacity > 0) {
      this.coolList = new Number[capacity];
    } else {
      throw new IllegalArgumentException("Not illegal argument " + capacity);
    }
  }

  /**
   * .
   *
   * @param o - added object If the array is full, a new array will be created with a capacity
   *          greater than 1.5 See: extendsUp() method
   */
  public void add(Number o) {
    if (size == coolList.length) {
      coolList = extendUpList();
    }
    coolList[size] = o;
    size++;
  }

  public Number get(int index) {
    checkedIndex(index);
    return coolList[index];
  }

  /**.
   * @param index index in array
   * @return removed element.
   */
  public Number remove(int index) {
    Number removeObject = get(index);
    int numMoved = size - index - 1;
    if (numMoved > 0) {
      System.arraycopy(coolList, index + 1, coolList, index,
          numMoved);
    }
    coolList[--size] = null; // clear to let GC do its work

    return removeObject;
  }

  /**.
   * @return new collection.
   */
  public <R extends Number> MyCoolList<R> map(Function<T, R> f) {
    MyCoolList<R> myCoolList = new MyCoolList<>(size);

    for (int i = 0; i < size; i++) {
      myCoolList.add(f.apply((T) coolList[i]));
    }
    return myCoolList;
  }

  public int size() {
    return size;
  }

  private Number[] extendUpList() {
    return Arrays.copyOf(coolList, (int) (size * 1.5));
  }

  private void checkedIndex(int index) {
    if (index < 0 || index > size) {
      throw new IndexOutOfBoundsException();
    }
  }

  /**
   * . Разница в между статическим и обычным вложенным классом заключается в том, что: -
   * нестатический вложенный класс может получить доступ к экземпляру внешнего класса, а статический
   * не может. - татический класс не нуждается в ссылке на внешний класс, нестатический вложенный
   * класс требует ссылки на внешний класс.
   */

  public Iterator<T> iterator() {
    return new Iter();
  }

  class Iter<T> implements Iterator<T> {

    int cursor = 0;


    @Override
    public boolean hasNext() {
      return cursor < size;
    }

    @Override
    public T next() {
      if (hasNext()) {
        return (T) get(cursor++);
      } else {
        throw new NoSuchElementException();
      }
    }

    @Override
    public void remove() {
      try {
        MyCoolList.this.remove(cursor);
      } catch (IndexOutOfBoundsException ex) {
        throw new ConcurrentModificationException();
      }
    }
  }
}
