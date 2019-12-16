package net.broscorp.l_inner_classes;

import java.util.Arrays;
import java.util.Iterator;
import java.util.NoSuchElementException;
import java.util.function.Function;


class MyCoolList<E extends Number> implements Iterable<E> {

  private int size = 0;


  private static final int DEFAULT_CAPACITY = 10;


  private Object elements[];


  public MyCoolList() {
    elements = new Object[DEFAULT_CAPACITY];
  }


  public void add(E e) {
    if (size == elements.length) {
      ensureCapacity();
    }
    elements[size++] = e;
  }


  @SuppressWarnings("unchecked")
  public E get(int i) {
    checkForIndexOutOfBoundException(i);
    return (E) elements[i];
  }


  public void checkForIndexOutOfBoundException(int i) {
    if (i >= size || i < 0) {
      throw new IndexOutOfBoundsException("Index: " + i + ", Size " + size);
    }
  }

  @SuppressWarnings("unchecked")
  public E remove(int i) {
    checkForIndexOutOfBoundException(i);
    Object item = elements[i];
    int numElts = elements.length - (i + 1);
    System.arraycopy(elements, i + 1, elements, i, numElts);
    size--;
    return (E) item;
  }

  public int size() {
    return size;
  }

  private void ensureCapacity() {
    int newSize = elements.length * 2;
    elements = Arrays.copyOf(elements, newSize);
  }


  public MyCoolList<Double> map(Function<E, ?> function) {
    MyCoolList<Double> myVariousList = new MyCoolList<>();
    for (int i = 0; i < size; i++) {
      elements[i] = (E) function.apply((E) elements[i]);
      myVariousList.add((Double) elements[i]);
    }
    return myVariousList;
  }

  @Override
  public Iterator<E> iterator() {
    return new MyCoolListIterator<>();
  }

  /**
   * Differences between static and non-static inner classes
   * <p>
   * 1)Static Inner class doesn't need reference of Outer class but Non static Inner class requires
   * Outer class reference. You can not create instance of Inner class without creating instance of
   * Outer class.
   * <p>
   * 2) Static Inner class is actually static member of class and can be used in static context e.g.
   * static method or static block of Outer class.
   * <p>
   * 3) Another difference between static and non static Inner classes is that you can not access
   * non static members e.g. method and field into nested static class directly. If you do so you
   * will get error like "non static member can not be used in static context". Non-static inner
   * class has access as well as reference to all fields and functions his Outer Class.
   *
   * @author
   */
  public class MyCoolListIterator<E> implements Iterator<E> {

    private int index;

    public MyCoolListIterator() {
      index = 0;
    }

    @Override
    public boolean hasNext() {
      return index < size;
    }

    @Override
    public E next() {
      if (!hasNext()) {
        throw new NoSuchElementException();
      }
      return (E) elements[index++];
    }
  }

}


