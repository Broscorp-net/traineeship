package net.broscorp.inner.classes;

import java.util.Arrays;
import java.util.Iterator;
import java.util.NoSuchElementException;
import java.util.function.Function;
import java.util.stream.Stream;

/**
 * Вложенные классы делятся на статические и нестатические (как у нас).
 * Нестатические называют - внутренние классы (inner classes).
 * Статические вложенные классы, не имеют доступа к нестатическим полям и методам
 * обрамляющего класса, что похоже на статические методы.
 * Доступ к нестатическим полям и методам может осуществляться только через ссылку на экземпляр
 * обрамляющего класса. В этом плане статические (static nested) классы очень похожи
 * на любые другие классы верхнего уровня, а также они имеют доступ ко все статическим методам
 * обрамляющего класса, в том числе и приватным.
 * @author Найдено на просторах интернета и пересказано своими словами.
 *
 */
public  class MyCoolList<T extends Number> implements Iterable<T> {
  private T[] items;

  public MyCoolList() {
    this.items = (T[]) new Number[0];
  }


  /**
   *  {@inheritDoc}
   *  */
  public void add(T item) {
    if (items.length == 0) {
      items = (T[]) new Number[1];
      items[0] = item;
    } else {
      Object[] itemsNew =  Stream.concat(Arrays.stream(items),Stream.of(item)).toArray();
      items = (T[]) new Number[itemsNew.length];
      for (int i = 0; i < items.length; i++) {
        items[i] = (T) itemsNew[i];
      }
    }
  }

  public T get(int index) {
    return items[index];
  }

  /**
   *  {@inheritDoc}
   *  */
  public T remove(int index) {
    final T removeItem = items[index];
    T[] itemsNew = (T[]) new Number[items.length - 1];
    int i = 0;
    while (i < index) {
      itemsNew[i] = items[i];
      i++;
    }
    while (i < items.length - 1) {
      itemsNew[i] = items[i + 1];
      i++;
    }
    items = itemsNew;
    return removeItem;
  }


  /**
   *  {@inheritDoc}
   *  */
  public <G extends Number> MyCoolList<G> map(Function<T,G> f) {
    MyCoolList<G> myList = new MyCoolList<>();
    for (T item : items) {
      myList.add((G) f.apply(item));
    }
    return myList;
  }

  public int size() {
    return items.length;
  }


  @Override
  public Iterator<T> iterator() {
    return new MyIterator();
  }


  class MyIterator implements Iterator<T> {
    private int it = 0;

    /**
     *  {@inheritDoc}
     *  */
    @Override
    public boolean hasNext() {
      return it < size();

    }

    /**
     *  {@inheritDoc}
     *  */
    @Override
    public T next() {
      if (hasNext()) {
        return get(it++);
      } else {
        throw new NoSuchElementException();
      }
    }
  }

}
