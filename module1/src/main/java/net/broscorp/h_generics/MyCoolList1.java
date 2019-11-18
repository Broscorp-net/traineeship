package net.broscorp.h_generics;

import java.util.function.Function;


public class MyCoolList1<E extends Number> implements List<E> {


  private int size = 0;


  private static final int DEFAULT_CAPACITY = 10;


  private Object elements[];


  public MyCoolList1() {
    elements = new Object[DEFAULT_CAPACITY];
  }

  @Override
  public void add(E e) throws IndexOutOfBoundsException {
    if (size >= DEFAULT_CAPACITY) {
      throw new IndexOutOfBoundsException("Element: " + e + ", Array size " + size);
    }

    elements[size++] = e;

  }


  @SuppressWarnings("unchecked")
  @Override
  public E get(int index) {

    if (index >= size || index < 0) {
      throw new IndexOutOfBoundsException("Index: " + index + ", Size " + size);
    }
    return (E) elements[index];
  }


  @SuppressWarnings("unchecked")
  @Override
  public E remove(int index) {
    if (index >= size || index < 0) {
      throw new IndexOutOfBoundsException("Index: " + index + ", Size " + size);
    }
    Object item = elements[index];
    int numElts = elements.length - (index + 1);
    System.arraycopy(elements, index + 1, elements, index, numElts);
    size--;
    return (E) item;
  }

  @SuppressWarnings("unchecked")
  @Override
  public E map(Function<?, ?> f) throws NullPointerException {

    E element = (E) f;
    return element;
  }

}
