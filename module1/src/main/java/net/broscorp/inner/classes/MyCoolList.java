package net.broscorp.inner.classes;

import java.util.Iterator;
import java.util.function.Function;

/**
 * В Java можно создавать классы внутри других классов, такие классы называются вложенными Эти
 * классы делятся на 2 вида - не статические классы (Non-static nested classes) или внутренние
 * классы (inner classes) и статические вложенные классы (Static nested classes). Внутренние классы
 * делятся на:
 * 1. Не статический класс-член (nonstatic member class).
 * 2. Анонимный класс (anonymous class).
 * 3. Локальный класс (local class).
 * Вложенные классы создаются только для обслуживания внешнего класса.
 * Статический класс - из него видны статические поля и методы внешнего класса без упоминания
 * имени класса, для доступа к нестатическим полям и методам необходим экземпляр внешнего
 * класса Его видно согласно модификатора доступа. Может имплементировать интерфейсы. Может
 * содержать как статические, так и не статические свойства и методы. Для создания экземпляра не
 * нужен объект внешнего класа.
 * Внутренний класс - его объект связан с объектом внешнего класса. Он имеет доступ к статическим
 * и не статическим членам внешнего класса и может ссылаться на них, но не может определять
 * статические члены.
 * Анонимный класс - не имеет названия. Объявлятся внутри методов основного класса. Не может
 * содержать определения статических полей и методов. С его помощью можно решить проблему
 * множественного наследования.
 * Локальный класс - объявляется внутри блока наружного класса и не является членом наружного
 * класса, а принадлежит блоку. Он не доступен за пределами внешнего класса. Время его жизни
 * ограничено блоком. Имеет доступ ко всем свойствам и методам наружного класса.
 */

class MyCoolList<T extends Number> implements Iterable<T> {

  private T[] listNumber;
  private int realSize = 0;

  @SuppressWarnings("unchecked")
  MyCoolList(int size) {
    this.listNumber = (T[]) new Number[size];
  }

  private MyCoolList(T[] collection) {
    this.listNumber = collection;
    this.realSize = collection.length;
  }

  @Override
  public InnerIterator iterator() {
    return new InnerIterator();
  }

  public class InnerIterator implements Iterator<T> {

    int ind = -1;

    /**
     * It checks if there is next element.
     *
     * @return boolean value.
     */
    @Override
    public boolean hasNext() {
      return (ind + 1 < size());
    }

    /**
     * Return next element from list.
     *
     * @return next element type T.
     */
    @Override
    public T next() {
      return get(++ind);
    }

    /**
     * Remove current element from list.
     */
    @Override
    public void remove() {
      MyCoolList.this.remove(ind);
    }

  }

  /**
   * Add new object to Array. If necessary, the size of the array will increase.
   *
   * @param o - numeric value.
   */
  void add(T o) {
    if (realSize == listNumber.length - 1) {
      increaseSize();
    }
    listNumber[realSize++] = o;
  }

  @SuppressWarnings("unchecked")
  <R extends Number> MyCoolList<R> map(Function<T, R> f) {
    R[] newCollection = (R[]) new Number[realSize];
    for (int i = 0; i < realSize; i++) {
      newCollection[i] = f.apply(listNumber[i]);
    }
    return new MyCoolList<>(newCollection);
  }

  /**
   * Return number elements of Array.
   *
   * @return integer value.
   */
  int size() {
    return realSize;
  }

  /**
   * This method increase size of Array.
   */
  @SuppressWarnings("unchecked")
  private void increaseSize() {
    int newLength = listNumber.length * 3 / 2 + 1;
    T[] newArr = (T[]) new Number[newLength];
    System.arraycopy(listNumber, 0, newArr, 0, realSize);
    listNumber = newArr;
  }

  /**
   * getting element from Array by index.
   *
   * @param index - integer value, index of element.
   * @return element's value.
   */
  T get(int index) {
    return listNumber[index];
  }

  /**
   * remove element from Array by index.
   *
   * @param index - integer value, index of element.
   * @return removed element.
   */
  T remove(int index) {
    T removedObject = listNumber[index];
    System.arraycopy(listNumber, index + 1, listNumber, index, realSize - index);
    realSize--;
    return removedObject;
  }

}
