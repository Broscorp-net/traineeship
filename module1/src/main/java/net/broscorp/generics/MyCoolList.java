package net.broscorp.generics;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.function.Function;

public class MyCoolList<T extends Number> implements Iterable<T> {
  private List<T> list;

  public MyCoolList() {
    list = new ArrayList();
  }

  public void add(T o) {
    list.add(o);
  }

  public Object get(int index) {
    return list.get(index);
  }

  public Object remove(int index) {
    return list.remove(index);
  }

  /**
   * Convert List from one Type to another.
   *
   * @param f   Function
   * @param <R> Type
   * @return
   */
  public <R extends Number> MyCoolList<R> map(Function f) {
    MyCoolList<R> myCoolList = new MyCoolList<>();
    for (T object : list) {
      myCoolList.add((R) f.apply(object));
    }
    return myCoolList;
  }

  public int size() {
    return list.size();
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
      return count < list.size();
    }

    @Override
    public T next() {
      return list.get(count++);
    }
  }
}
