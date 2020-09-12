package net.broscorp.generics;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.function.Function;

public class MyCoolList<T extends Number> implements Iterable<T> {
  private T[] values;
  private int firstFreeIndex;

  public MyCoolList() {
    this.values = (T[]) new Number[10];
    this.firstFreeIndex = 0;
  }

  /**
   * Method add Value.
   * @param o value
   */
  public void add(T o) {
    if (this.firstFreeIndex == this.values.length) {
      grow();
    }

    this.values[this.firstFreeIndex] = o;
    this.firstFreeIndex++;
  }

  private void grow() {
    int newSize = this.values.length + this.values.length / 2;
    T[] newValues = (T[]) new Number[newSize];
    for (int i = 0; i < this.values.length; i++) {
      newValues[i] = this.values[i];
    }
    this.values = newValues;
  }

  /**
   * Method get Value.
   * @param index index of Value
   * @return Value
   */
  public T get(int index) {
    if (index > size()) {
      throw new ArrayIndexOutOfBoundsException();
    }
    return values[index];
  }

  /**
   * Method remove Value.
   * @param index index of Value
   * @return Value
   */
  public T remove(int index) {
    T value = get(index);
    for (int i = index; i < this.firstFreeIndex - 1; i++) {
      this.values[i] = this.values[i + 1];
    }
    this.firstFreeIndex--;
    return value;
  }

  /**
   * Convert List from one Type to another.
   *
   * @param f   Function
   * @param <R> Type
   * @return
   */
  public <R extends Number> MyCoolList<R> map(Function<T, ? extends Number> f) {

    MyCoolList<R> myCoolList = new MyCoolList<>();
    for (T object : values) {
      myCoolList.add((R) f.apply(object));
    }
    return myCoolList;
  }

  public int size() {
    //list.size();
    return this.firstFreeIndex;
  }

  @Override
  public Iterator<T> iterator() {
    return new MyCoolListIteratr();
  }

  /**
   * Статический и не статический вложенный класс.
   * Статический:
   * экзепляр создается без создания экземпляра внешнего класса.
   * Имеет доступ к статическим полям и методам внешнего класса.
   * Не связан с конкретным экземпляром внешнего класса.
   * Из его экземпляра можно полкчить все поля и методы внешнего класса.
   * Нестатический:
   * экзепляр создается в экземпляре внешнего класса.
   * Из него видны все поля и методы внешнего класса.
   * Связан с конкретным экземляром внешнего класса.
   * Не может содержать статические методы.
   */
  public class MyCoolListIteratr implements Iterator<T> {
    int count = 0;

    @Override
    public boolean hasNext() {
      return count < size();
    }

    @Override
    public T next() {
      return values[count++];
    }
  }
}
