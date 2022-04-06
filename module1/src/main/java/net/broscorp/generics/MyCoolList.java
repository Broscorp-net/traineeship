package net.broscorp.generics;

import java.util.Iterator;
import java.util.function.Function;

public class MyCoolList<T extends Number> implements Iterable {

  private int initSize = 15;
  private Object[] array = new Object[initSize];
  private int index = 0;

  /**
   * add item to list.
   * @param item is an item which will be aded to list.
   */
  public void add(T item) {
    if (index == array.length - 1) {
      Object[] newArray = new Object[initSize * 2];
      System.arraycopy(array, 0, newArray, 0, index);
      array = newArray;
    }
    array[index++] = item;
  }

  /**
   * show an item in positiion in a list.
   * @param index is a position of item in a list
   * @return the item.
   */
  public T get(int index) {
    return (T) array[index];
  }

  /**
   * Delete an item in a list.
   * @param position is a position of item.
   * @return deleted item.
   */

  public T remove(int position) {
    final Object obj = array[position];
    for (int i = position; i < index; i++) {
      array[i] = array[i + 1];
    }
    array[index] = null;
    index--;
    return (T) obj;
  }

  /**
   * use a given function to all elements of a list.
   * @param f is a function which will be used.
   * @return a new list with  modified elements.
   */
  public MyCoolList map(Function f) {
    MyCoolList list = new MyCoolList();
    for (Object obj : array) {
      f.apply(obj);
      list.add((T)obj);
    }
    return list;
  }

  public int size() {
    return index;
  }

  public Iterator<T> iterator() {
    return new ListIterator().iterator();
  }

  /**
   * В целом внутрений класс позволяет групировать код и делать его читабельным.
   * Доступ к нему можно получить через обьект внешнего класса.
   * Можно создать его отдельный обьект если модификатор доступа позволяет.
   */
  private class ListIterator implements Iterable<T> {
    @Override
    public Iterator<T> iterator() {
      return new Iterator<T>() {
        @Override
        public boolean hasNext() {
          if (index < size()) {
            return true;
          }
          return false;
        }

        @Override
        public T next() {
            return get(index++);
        }
      };
    }
  }

}
