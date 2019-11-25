package net.broscorp.h_generics;

import java.util.Arrays;
import java.util.Iterator;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.Objects;
import java.util.function.Function;
import java.util.stream.Collectors;

public class MyCoolList<T extends Number> implements Iterable<T> {

  private int size = 0;
  private static final int DEFAULT_CAPACITY = 10;
  private Object[] elements;

  public MyCoolList() {
    elements = new Object[DEFAULT_CAPACITY];
  }

  public void add(T e) {
    if (size == elements.length) {
      changeSize(elements.length * 2);
    }
    elements[size++] = e;
  }

  @SuppressWarnings("unchecked")
  public T get(int index) {
    getException(index);
    return (T) elements[index];
  }

  @SuppressWarnings("unchecked")
  public T remove(int index) {
    getException(index);
    T oldElement = (T) elements[index];
    for (int i = index; i < size - 1; i++) {
      elements[i] = elements[i + 1];
    }
    size--;
    cuttingArray();
    return oldElement;
  }

  @SuppressWarnings("unchecked")
  public <R> List<R> map(Function<T, R> f) {
    return Arrays.stream(elements).
        filter(Objects::nonNull).
        map(t -> f.apply((T) t)).
        collect(Collectors.toList());
  }

  private void getException(int index) {
    if (index >= size || index < 0) {
      throw new IndexOutOfBoundsException();
    }
  }

  private void changeSize(int newLength) {
    Object[] newArray = new Object[newLength];
    System.arraycopy(elements, 0, newArray, 0, size);
    elements = newArray;
  }

  private void cuttingArray() {
    if (elements.length > DEFAULT_CAPACITY && size < elements.length / 2) {
      changeSize(elements.length / 2);
    }
  }

  public Iterator<T> iterator() {
    return new IteratorImpl<>();
  }

  /**
   * Внутрение классы бывают внутреними статическими и внутреними не
   * статическими. Не статические внутрение классы деляться на три подвида:
   * -- Простой внутрений класс
   * -- Локальный - может быть объявлен внтури метода или блока инициализации
   * -- Анонимный - внутрений класс без имени класса, наследуемый от какого либо класса.
   *
   * Объект внутреннего класса не может существовать без объекта внешнего класса.
   * У объекта внутреннего класса есть доступ к методам и полям внешнего класса. Даже к приватным.
   * Но у него нет доступа к статическим методам и полям внешнего класса.
   * Объект внутреннего класса можно создать в статическом методе внешнего класса,
   * но нужен экземляр внешнего класса. Пример:
   *
   * public static void example() {
   *       MyCoolList<Integer> myList = new MyCoolList<>();
   *       myList.new IteratorImpl<Integer>();
   * }
   *
   * Внутренний класс не может содержать статические переменные и методы.
   * Объект внутреннего класса может иметь все модификатора доступа.
   *
   * Статические вложенный классы: Объект статического класса не хранит
   * ссылку на конкретный экземпляр внешнего класса. Статический вложенный класс может
   * обращаться только к статическим полям и методам внешнего класса. Объекты  вложенного
   * класса static не содержат ссылок на объекты внешнего класса. Самих объектов внутренего класса
   * можем создать сколько угодно.
   */
  private class IteratorImpl<T> implements Iterator<T> {

    int index = 0;

    @Override
    public boolean hasNext() {
      return index < size && elements[index] != null;
    }

    @SuppressWarnings("unchecked")
    @Override
    public T next() {
      if (!hasNext()) {
        throw new NoSuchElementException();
      }
      return (T) elements[index++];
    }

    @Override
    public void remove() {
      throw new UnsupportedOperationException();
    }
  }
}



