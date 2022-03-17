package net.broscorp.generics;

import java.util.Arrays;
import java.util.function.Function;
import java.util.stream.Stream;

public class MyCoolList<T extends Number> {
  private T[] items;

  public MyCoolList() {
    this.items = (T[]) new Number[0];
  }

  public void add(T item) {
    if (items.length == 0) {
      items = (T[]) new Number[1];
      items[0] = item;
    } else {
      Object[] itemsNew =  Stream.concat(Arrays.stream(items),Stream.of(item)).toArray();
      items = (T[]) new Number[itemsNew.length];
      for (int i = 0; i < items.length; i++) {
        items[i] = (T) itemsNew[i];
      }
    }
  }

  public T get(int index) {
    return items[index];
  }

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

  public <G extends Number> MyCoolList<G> map(Function<T,G> f) {
    MyCoolList<G> myList = new MyCoolList<>();
    for (T item : items) {
      myList.add((G) f.apply(item));
    }
    return myList;
  }

  public int size() {
    return items.length;
  }

}
