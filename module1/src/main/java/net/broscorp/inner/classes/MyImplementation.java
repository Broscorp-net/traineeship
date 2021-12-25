package net.broscorp.inner.classes;

import java.util.Arrays;
import java.util.Iterator;
import java.util.function.Function;

import net.broscorp.generics.MyCoolList;

public class MyImplementation<T extends Number> implements MyCoolList<T> {

  T[] list;

  public MyImplementation() {
    list = (T[]) new Number[0];
  }

  public MyImplementation(int size) {
    list = (T[]) new Number[size];
  }

  @Override
  public void add(T t) {
    T[] copy = Arrays.copyOf(list, list.length);
    list = (T[]) new Number[list.length + 1];
    System.arraycopy(copy, 0, list, 0, list.length - 1);
    list[list.length - 1] = t;
  }

  @Override
  public T get(int index) {
    return list[index];
  }

  /***<p>
   * 1.Статический класс может напрямую обращаться к статическим членам
   * внешнего класса. Но для доступа к членам экземпляра внешнего класса
   * необходимо создать экземпляр внешнего класса.
   * 2.Вложенный статический класс не требует ссылки на внешний класс, но нестатический
   * вложенный класс или внутренний класс требует ссылки на внешний класс.
   * 3.Нестатический вложенный класс имеет полный доступ к членам класса, в котором он
   * вложен.
   * Статический вложенный класс не имеет ссылки на экземпляр вложения, поэтому
   * статический вложенный класс не может вызывать нестатические методы или получать
   * доступ к нестатическим полям экземпляра класса, в котором он вложен.
   * 4.Еще одно различие между статическим и нестатическим вложенным классом
   * заключается в том, что вы не можете получить доступ к нестатическим членам,
   * например. метод и поле напрямую во вложенный статический класс. Если вы это
   * сделаете, вы получите такие ошибки, как «нестатический член не может
   * использоваться в статическом контексте». В то время как внутренний класс
   * может получить доступ как к статическим, так и нестатическим членам внешнего
   * класса.
   * </p>
   */

  public T removeOneItem(int i) {
    T value = list[i];
    T[] copy = Arrays.copyOf(list, list.length);
    list = (T[]) new Number[list.length - 1];

    if (i == 0) {
      System.arraycopy(copy, 1, list, 0, list.length);
    } else if (i == copy.length - 1) {
      System.arraycopy(copy, 0, list, 0, list.length);
    } else {
      System.arraycopy(copy, 0, list, 0, i);
      System.arraycopy(copy, i + 1, list, i, list.length - i);
    }
    return value;
  }

  @Override
  public MyCoolList<T> map(Function<T, T> f) {
    MyCoolList<T> myList = new MyImplementation<>();

    for (T t : list) {
      myList.add(f.apply(t));
    }
    return myList;
  }

  @Override
  public int size() {
    return list.length;
  }

  public Iterator<T> iterator() {
    return new MyIterator();
  }

  private class MyIterator implements Iterator<T> {

    private int item = 0;

    @Override
    public void remove() {
      removeOneItem(--item);
    }

    @Override
    public boolean hasNext() {
      return list.length > item;
    }

    @Override
    public T next() {
      return get(item++);
    }
  }
}
