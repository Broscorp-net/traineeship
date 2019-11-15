package net.broscorp.h_generics;

import java.util.Arrays;
import java.util.List;
import java.util.function.Function;
import java.util.stream.Collectors;

public class MyCoolList<T extends Number> {

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
    return Arrays.stream(elements).map(t -> {
      try {
        return f.apply((T) t);
      } catch (Exception e) {
      }
      return null;
    }).collect(Collectors.toList());
  }

  private void getException(int index) {
    if (index >= size) {
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
}

