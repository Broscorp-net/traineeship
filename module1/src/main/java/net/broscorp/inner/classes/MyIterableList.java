package net.broscorp.inner.classes;

import java.util.Arrays;
import java.util.Iterator;
import java.util.function.Function;

public class MyIterableList<T extends Number> implements Iterable<T> {

  private int size = 0;
  private Object[] elements;

  public MyIterableList() {
    int defaultCapacity = 10;
    elements = new Object[defaultCapacity];
  }

  public MyIterableList(int capacity) {
    elements = new Object[capacity];
  }

  /**
   * Adds new element to list.
   * @param o object to add
   */
  public void add(T o) {
    if (size == elements.length) {
      changeCapacity();
    }

    elements[size++] = o;
  }

  /**
   * Return element by index.
   * @param index index of element
   * @return element
   */
  public T get(int index) {
    if (index >= size || index < 0) {
      throw new IndexOutOfBoundsException();
    }

    return (T) elements[index];
  }

  /**
   * Removes element by index.
   * @param index index of element
   * @return removed element
   */
  public T remove(int index) {
    if (index >= size || index < 0) {
      throw new IndexOutOfBoundsException();
    }

    final T oldValue = (T) elements[index];
    elements[index] = null;

    int tmp = index;
    while (tmp < size) {
      elements[tmp] = elements[tmp + 1];
      elements[tmp + 1] = null;
      tmp++;
    }

    size--;
    return oldValue;
  }

  /**
   * Map method creates new MyCoolList and apply function to each element of original list.
   * @param f   function
   * @param <T> desired data type (T extends Number)
   * @return new list
   */
  public <T extends Number> MyIterableList<T> map(Function f) {
    MyIterableList<T> newList = new MyIterableList<T>(elements.length);

    for (int i = 0; i < size; i++) {
      T el = (T) elements[i];
      newList.add((T) f.apply(el));
    }

    return newList;
  }

  /**
   * Returns current size of the list.
   * @return size
   */
  public int size() {
    return size;
  }

  private void changeCapacity() {
    int newSize = elements.length * 2;
    elements = Arrays.copyOf(elements, newSize);
  }

  @Override
  public Iterator<T> iterator() {
    return new CoolIterator();
  }

  /**
   * Inner classes and their public fields are hidden from other classes.
   * Inner classes cannot have static fields or methods.
   * Non-static inner object can access/modify the fields of the outer object.
   * Public non-static inner classes are visible outside of the outer class.
   * Non-static inner class is accessed by name OuterClass.new InnerClass
   * Static inner class cannot use fields of the outer class.
   * Static inner class is accessed using the enclosing class name OuterClass.InnerClass
   */
  private class CoolIterator implements Iterator<T> {
    // current position in a list
    private int index;

    public CoolIterator() {
      index = 0;
    }

    @Override
    public boolean hasNext() {
      return index < size();
    }

    @Override
    public T next() {
      index++;
      return get(index - 1);
    }

    @Override
    public void remove() {
      throw new UnsupportedOperationException();
    }
  }
}

