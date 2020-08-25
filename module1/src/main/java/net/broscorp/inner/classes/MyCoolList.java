package net.broscorp.inner.classes;

import java.util.Iterator;
import java.util.function.Function;

/**
 * Этот лист был взят из прошлого задания с generics.
 *
 * @param <T> из прошлого задания я удалил наследования от Number,
 *            т.к. возникали сложности с итератором.
 */

public class MyCoolList<T> {

  private final int defSize = 10;
  private Object[] array;
  private int size = 0;

  /**
   * Конструктор.
   * @param initialCapacity размер массива задающий при инициализации.
   */
  public MyCoolList(int initialCapacity) {
    if (initialCapacity > 0) {
      this.array = new Object[initialCapacity];
    } else if (initialCapacity == 0) {
      this.array = new Object[defSize];
    } else {
      throw new IllegalArgumentException("Illegal Capacity: "
          + initialCapacity);
    }
  }

  /**
   * Добавление в список.
   * @param element передающий в массив элемент.
   */

  public void add(T element) {
    if (size == array.length - 1) {
      resize((array.length * 3) / 2 + 1);
    }
    array[size++] = element;
  }

  T elementData(int index) {
    return (T) array[index];
  }

  /**
   * Получение элемента по индексу.
   * @param index индекс элемента.
   */

  public T get(int index) {
    return elementData(index);
  }

  /**
   * Удаление элемента по индексу.
   * @param index индекс элемента.
   */

  public void remove(int index) {
    for (int i = index; i < size; i++) {
      array[i] = array[i + 1];
    }
    array[size] = null;
    size--;
  }

  /**
   * Конвертация списка.
   * @param f функция для конвертаций списка.
   */

  public <R extends Number> MyCoolList<R> map(Function f) {
    MyCoolList<R> result = new MyCoolList<>(size);
    for (Object ls : array) {
      if (ls == null) {
        break;
      }
      result.add((R) f.apply(ls));
    }
    return result;
  }

  public int size() {
    return size;
  }

  private void resize(int newLength) {
    Object[] newArray = new Object[newLength];
    System.arraycopy(array, 0, newArray, 0, size);
    array = newArray;
  }

  /**
   * Отображение списка.
   * @return вывод списка на экран.
   */

  public String showList() {
    StringBuilder str = new StringBuilder();
    str.append("[");
    for (int i = 0; i < array.length; i++) {
      if (array[i + 1] == null) {     //!iterable.iterator().hasNext()
        str.append(array[i]);
        break;
      }
      str.append(array[i]).append(", ");
    }
    return str.append("]").toString();
  }

  class ArrayIterable implements Iterable<T> {

    private MyIterator myIterator = new MyIterator();

    @Override
    public Iterator<T> iterator() {
      return myIterator;
    }
  }

  private class MyIterator implements Iterator<T> {
    private T[] arrayList;
    private int currentIndex = 0;

    public MyIterator() {
      this.arrayList = covert(array);
    }

    T[] covert(Object[] arr) {
      return (T[]) arr;
    }

    @Override
    public boolean hasNext() {
      return this.currentIndex < size;
    }

    @Override
    public T next() {
      return (T) arrayList[currentIndex++];
    }

    @Override
    public void remove() {
      throw new UnsupportedOperationException();
    }
  }
}

