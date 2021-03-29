package net.broscorp.generics;

import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;
import java.util.function.Function;

public class MyCoolList<E extends Number> implements List<E> {

  private final int defaultSize = 16;
  private Object[] array = new Object[defaultSize];
  private int currentPosition = -1;

  /**
   * Returns the element at index.
   * @param index position element
   * @return value element at index
   */
  public E get(int index) {
    if ((index > -1) && (index <= currentPosition)) {
      return (E)array[index];
    }
    return null;
  }

  @Override
  public E set(int index, E element) {
    if ((index > -1) && (index <= currentPosition)) {
      array[index] = element;
      return (E)array[index];
    }
    return null;
  }

  @Override
  public boolean add(E element) {
    if (++currentPosition <= array.length - 1) {
      array[currentPosition] = element;
      return true;
    }
    if (currentPosition > array.length - 1) {
      Object[] arrayBiger = new Object[array.length * 2];
      System.arraycopy(array, 0, arrayBiger, 0, array.length);
      array = arrayBiger;
      array[currentPosition] = element;
      return true;
    } else {
      currentPosition--;
      return false;
    }
  }

  @Override
  public void add(int index, E element) {

    if (++currentPosition <= array.length - 1) {
      System.arraycopy(array, index, array, index + 1, currentPosition - index - 1);
      array[index] = element;
    }
    if (currentPosition > array.length - 1) {
      Object[] arrayBiger = new Object[array.length * 2];
      System.arraycopy(array, 0, arrayBiger, 0, array.length);
      array = arrayBiger;
      System.arraycopy(array, index, array, index + 1, currentPosition - index - 1);
      array[index] = element;

    } else {
      currentPosition--;
    }
  }

  /**
   * Removes the element at index.
   * @param index position element
   * @return removed element
   */
  public E remove(int index) {
    if ((index > -1) && (index <= currentPosition)) {
      Object removedElement = array[index];
      System.arraycopy(array, index + 1, array, index, currentPosition - index);
      currentPosition--;
      return (E)removedElement;
    }
    return null;
  }

  @Override
  public boolean remove(Object o) {
    return false;
  }

  @Override
  public int indexOf(Object o) {
    return 0;
  }

  @Override
  public int lastIndexOf(Object o) {
    return 0;
  }

  @Override
  public ListIterator<E> listIterator() {
    return null;
  }

  @Override
  public ListIterator<E> listIterator(int index) {
    return null;
  }

  @Override
  public List<E> subList(int fromIndex, int toIndex) {
    return null;
  }

  /**
   * Applies a function to elements.
   * @param f function (lambda expression)
   * @return modified list
   */
  public MyCoolList<E> map(Function<E, E> f) {
    for (int i = 0; i <= currentPosition; i++) {
      array[i] = f.apply((E)array[i]);
    }
    return this;
  }

  public int size() {
    return currentPosition + 1;
  }

  @Override
  public boolean isEmpty() {
    if (currentPosition == -1) {
      return true;
    }
    return false;
  }

  @Override
  public boolean contains(Object o) {
    return false;
  }

  @Override
  public Iterator<E> iterator() {
    return null;
  }

  @Override
  public Object[] toArray() {
    return new Object[0];
  }

  @Override
  public <T> T[] toArray(T[] a) {
    return null;
  }

  @Override
  public boolean containsAll(Collection<?> c) {
    return false;
  }

  @Override
  public boolean addAll(Collection<? extends E> c) {
    return false;
  }

  @Override
  public boolean addAll(int index, Collection<? extends E> c) {
    return false;
  }

  @Override
  public boolean removeAll(Collection<?> c) {
    return false;
  }

  @Override
  public boolean retainAll(Collection<?> c) {
    return false;
  }

  @Override
  public void clear() {

  }

}