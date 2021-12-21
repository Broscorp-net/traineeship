package net.broscorp.generics;

import java.util.function.Function;

public interface MyCoolList<T> {

  void add(T t);

  T get(int index);

  T remove(int index);

  <R extends Number> MyCoolList<R> map(Function<T, R> f);

  int size();

}
