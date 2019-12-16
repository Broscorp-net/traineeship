package net.broscorp.h_generics;

import java.util.Arrays;
import java.util.function.Function;


public class MyCoolList<E extends Number> {

  private int size = 0;


  private static final int DEFAULT_CAPACITY = 10;


  private Object elements[];


  public MyCoolList() {
    elements = new Object[DEFAULT_CAPACITY];
  }


  public void add(E e) {
    if (e == null) {
      throw new IllegalArgumentException("Null element");
    }
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

}

