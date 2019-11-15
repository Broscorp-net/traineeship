package net.broscorp.h_generics;

import java.util.ArrayList;
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
      int newSize = elements.length * 2;
      elements = Arrays.copyOf(elements, newSize);
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
    Object oldValue = elements[index];
    int numIndex = size - index - 1;
    if (numIndex > 0) {
      System.arraycopy(elements, index + 1, elements, index, numIndex);
    }
    elements[--size] = null;
    return (T) oldValue;
  }

  private void getException(int index) {
    if (index >= size) {
      throw new IndexOutOfBoundsException();
    }
  }

    @SuppressWarnings("unchecked")
    public <R> List<R> map(Function<T, R> f) {
      return Arrays.stream(elements).map(t -> {
          try {
              return f.apply((T) t);
          } catch (Exception e) {}
          return null;
      }).collect(Collectors.toList());
    }
}

class Main {

  public static void main(String[] args) {
    MyCoolList<Integer> list1 = new MyCoolList<>();
    list1.add(22);
    list1.add(33);

    Function<Integer, Double> function = aDouble -> (Double) aDouble.doubleValue();

    List<Double> map = list1.map(function);

    System.out.println(map);
  }
}

