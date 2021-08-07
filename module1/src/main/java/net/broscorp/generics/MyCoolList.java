package net.broscorp.generics;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Function;
import sun.reflect.generics.reflectiveObjects.NotImplementedException;

/**
 * В Java можно создавать классы в других классах, такие классы называются вложенными
 *Эти классы делятся на 2 вида - не статические классы (Non-static nested classes) или внутренние
 * классы (inner classes) и статические вложенные классы (Static nested classes).
 *Внутренние классы делятся на:
 * 1. Не статический класс-член (nonstatic member class).
 * 2. Анонимный класс (anonymous class).
 * 3. Локальный класс (local class).
 * Вложенные классы создаются только для обслуживания внешнего класса.
 * Статический класс - из него видны статические свойства и методы внешнего класса, из его
 * экземпляра видны все свойства и методы внешнего класса, и статические и обычные. Его видно
 * согласно модификатора доступа. Может имплементировать интерфейсы. Может содержать как
 * статические, так и не статические свойства и методы. Для создания экземпляра не нужен объект
 * внешнего класа.
 * Внутренний класс - его объект связан с объектом внешнего класса. Он имеет доступ к статическим и
 * не статическим членам внешнего класса и может ссылаться на них, но не может определять
 * статические члены.
 * Анонимный класс - не имеет названия. Объявляются внутри методов основного класса. Не могут
 * содержать определения статических полей и методов. С его помощью можно решить проблему
 * множественного наследования.
 * Локальный класс - объявляется внутри блока наружного класса и не является членом наружного
 * класса, а принадлежит блоку. Он не доступен за пределами внешнего класса. Время его жизни
 * ограничено блоком. Имеет доступ ко всем свойствам и методам наружного класса
 */
public class MyCoolList<T extends Number> {

  List<T> listInt;
  InnerIterator iterator = this.new InnerIterator();

  MyCoolList() {
    this.listInt = new ArrayList<>();
  }

  public class InnerIterator {

    int nextIndex = 0;

    public boolean hasNext() {
      return (nextIndex <= size() - 1);
    }

    /**
     * Return next element from ArrayList.
     *
     * @return next element type T.
     */
    T next() {
      T retValue = listInt.get(nextIndex);
      nextIndex++;
      return retValue;
    }

    void remove() {
      if (nextIndex >= listInt.size()) {
        nextIndex = listInt.size() - 1;
      }
      listInt.remove(nextIndex);
      if (nextIndex != 0) {
        nextIndex--;
      }
    }
  }

  void add(T o) {
    listInt.add(o);
  }

  /**
   * getting element from ArrayList by index.
   *
   * @param index - index of element.
   * @return element's value or stroke "Wrong index".
   */
  Object get(int index) {
    try {
      return listInt.get(index);
    } catch (IndexOutOfBoundsException e) {
      System.out.println("Wrong index, it should be in the range 0..." + (listInt.size() - 1));
      return "Wrong index";
    }
  }

  /**
   * remove element from ArrayList by index.
   *
   * @param index - index of element.
   * @return removed element or stroke "Wrong index".
   */
  Object remove(int index) {
    Object removedObject = this.get(index);
    if (removedObject != "Wrong index") {
      listInt.remove(index);
    }
    return removedObject;
  }

  public MyCoolList<T> map(Function f) {
    throw new NotImplementedException();
  }

  int size() {
    return listInt.size();
  }

}
