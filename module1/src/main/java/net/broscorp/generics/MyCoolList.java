package net.broscorp.generics;

import java.util.Arrays;
import java.util.function.Function;

public class MyCoolList<T extends Number> {
  private T[] items;

  public MyCoolList() {
    this.items = (T[]) new Number[0];
  }


  /**
   *  {@inheritDoc}
   *  */
  public void add(T item) {
    if (items.length == 0) {
      items = (T[]) new Number[1];
      items[0] = item;
    } else {
      items = Arrays.copyOf(items, items.length + 1);
      items[items.length - 1] = item;
    }
  }

  public T get(int index) {
    return items[index];
  }

  /**
   *  {@inheritDoc}
   *  */
  public T remove(int index) {
    final T removeItem = items[index];
    T[] itemsNew = (T[]) new Number[items.length - 1];
    int i = 0;
    while (i < index) {
      itemsNew[i] = items[i];
      i++;
    }
    while (i < items.length - 1) {
      itemsNew[i] = items[i + 1];
      i++;
    }
    items = itemsNew;
    return removeItem;
  }


  /**
   *  {@inheritDoc}
   *  */
  public <G extends Number> MyCoolList<G> map(Function<T,G> f) {
    for (int i = 0; i < items.length; i++) {
      items[i] = (T) f.apply(items[i]);
    }
    return (MyCoolList<G>) MyCoolList.this;
  }

  public int size() {
    return items.length;
  }

}
