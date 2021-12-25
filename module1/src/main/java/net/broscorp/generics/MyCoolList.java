package net.broscorp.generics;

import java.util.function.Function;

public interface MyCoolList<T> extends Iterable<T> {

  void add(T t);

  T get(int index);

  T removeOneItem(int index);

  MyCoolList<T> map(Function<T, T> f);

  int size();

}

