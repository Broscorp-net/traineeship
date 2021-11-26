package net.broscorp.inner.classes;

import java.util.function.Function;

public interface MyCoolList<T> extends Iterable<T>{

  void add(T t);

  T get(int index);

  T removeElem(int index);

  MyCoolList<T> map(Function<T, T> f);

  int size();

}
