package net.broscorp.generics;

import java.util.Arrays;
import java.util.Iterator;
import java.util.function.Consumer;
import java.util.function.Function;

public class MyCoolList<E extends Number> implements Iterable<E> {

  /**
   * Нестатические внутренные классы служат для групирования логики внутки внешнего класса. Они
   * исполняют определённую логику внутри класса и к ним нельзя доступится откуда-то кроме внешнего
   * класса. Статические вложенные классы решают задачу агрегации, и позволяют выделять обьекты
   * внутри других обьектов. К таким обьектам можно достучаться извне через внешний класс.
   */

  private Object[] array;
  private int size = 0;

  public MyCoolList() {
    Object[] array = new Object[size];
  }

  /**
   * Method that add elements into list.
   */
  public <T extends E> void add(T t) {
    if (size == 0) {
      size++;
      array = new Object[]{t};
    } else {
      Object[] newArray = Arrays.copyOf(array, ++size);
      array = Arrays.copyOf(newArray, size);
      array[size - 1] = t;
    }
  }

  /**
   * Method that gives elements from list.
   */
  public E get(int index) {
    try {
      return (E) array[index];
    } catch (IndexOutOfBoundsException ex) {
      ex.printStackTrace();
      return null;
    }
  }

  /**
   * Method that delete elements from list.
   */
  public E remove(int index) {
    E deletedObject = null;
    try {
      if (size != 0) {
        Object[] newArray = new Object[--size];
        if (index == 0) {
          deletedObject = (E) array[0];
          System.arraycopy(array, 1, newArray, 0, size);
        } else if (index == size) {
          deletedObject = (E) array[size];
          System.arraycopy(array, 0, newArray, 0, size);
        } else {
          deletedObject = (E) array[index];
          System.arraycopy(array, 0, newArray, 0, index);
          System.arraycopy(array, index + 1, newArray, index, size - index);
        }
        array = Arrays.copyOf(newArray, size);
      }
    } catch (ArrayIndexOutOfBoundsException ex) {
      ex.printStackTrace();
    }
    return deletedObject;
  }

  /**
   * Method that converting elements in a list.
   */
  public MyCoolList<E> map(Function<E, E> f) {
    MyCoolList<E> myCoolList = new MyCoolList<>();
    for (int i = 0; i < this.size(); i++) {
      myCoolList.add(f.apply(this.get(i)));
    }
    return myCoolList;
  }

  /**
   * Method that return count of elements in list.
   */
  public int size() {
    return size;
  }

  @Override
  public Iterator<E> iterator() {
    return new CustomIterator();
  }

  class CustomIterator implements Iterator<E> {

    int index = 0;

    @Override
    public boolean hasNext() {
      return index < size();
    }

    @Override
    public E next() {
      if (hasNext()) {
        return get(index++);
      }
      return null;
    }

    @Override
    public void remove() {
      MyCoolList.this.remove(index);
    }

    @Override
    public void forEachRemaining(Consumer<? super E> action) {
      Iterator.super.forEachRemaining(action);
    }
  }
}
