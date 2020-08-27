package net.broscorp.generics;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.function.Function;


public class MyCoolList<T extends Number> implements Iterable {

  private IteratorClass iteratorClass = new IteratorClass();
  private ArrayList<T> list = new ArrayList<>();

  public void add(T a) {
    list.add(a);
  }

  public Object get(int index) {
    return list.get(index);
  }

  public void remove(int index) {
    list.remove(list.get(index));
  }

  /**
   * map.
   */
  public <R extends Number> MyCoolList<R> map(Function f) {
    MyCoolList<R> myCoolList = new MyCoolList<>();
    for (Object a : list) {
      myCoolList.add((R) f.apply(a));
    }
    return myCoolList;
  }

  public int size() {
    return list.size();
  }

  @Override
  public Iterator iterator() {
    return iteratorClass;
  }

  /**
   * Отличия InnerClass и StaticNestedClass:
   * 1. Объект StaticNestedClass не хранит ссылку на конкретный экземпляр внешнего класса.
   * 2. StaticNestedClass класс может обращаться только к статическим полям внешнего класса.
   * 3. InnerClass не может существовать без объекта "внешнего" класса.
   * 4. Объект InnerClass нельзя создать в статическом методе «внешнего» класса.
   * 5. У объекта InnerClass есть доступ к переменным «внешнего» класса.
   *
   */
  class IteratorClass implements Iterator<T> {

    private int currentIndex = 0;

    @Override
    public boolean hasNext() {
      return this.currentIndex < list.size();
    }

    @Override
    public T next() {
      return list.get(currentIndex++);
    }
  }
}
