package net.broscorp.h_generics;

import java.util.Arrays;
import java.util.function.Function;



public class MyCoolList<E extends Number> {
  // Size of list
  private int size = 0;

  // Default capacity of list is 10
  private static final int DEFAULT_CAPACITY = 10;

  // This array will store all elements added to list
  private Object elements[];

  // Default constructor
  public MyCoolList() {
    elements = new Object[DEFAULT_CAPACITY];
  }

  // Add method
  public void add(E e) {
    if (size == elements.length) {
      ensureCapacity();
    }
    if (e == null) {
      throw new NullPointerException();
    }
    elements[size++] = e;
  }

  // Get method
  @SuppressWarnings("unchecked")
  public E get(int i) {
    getIndexOutOfBoundException(i);
    return (E) elements[i];
  }

  // Duplicated code as separate method
  public void getIndexOutOfBoundException(int i) {
    if (i >= size || i < 0)
      throw new IndexOutOfBoundsException("Index: " + i + ", Size " + i);
  }

  // Remove method
  @SuppressWarnings("unchecked")
  public E remove(int i) {
    getIndexOutOfBoundException(i);
    Object item = elements[i];
    int numElts = elements.length - (i + 1);
    System.arraycopy(elements, i + 1, elements, i, numElts);
    size--;
    return (E) item;
  }

  // Get Size of list
  public int size() {
    return size;
  }

  // Increase capacity
  private void ensureCapacity() {
    int newSize = elements.length * 2;
    elements = Arrays.copyOf(elements, newSize);
  }

  @SuppressWarnings("unchecked")
  public MyCoolList<Double> map(Function<E, ?> function) {
    MyCoolList<E> myVariousList = new MyCoolList<>();
    for (int i = 0; i < size; i++) {
      elements[i] = (E) function.apply((E) elements[i]);
      myVariousList.add((E) elements[i]);
    }
    return (MyCoolList<Double>) myVariousList;
  }

}
