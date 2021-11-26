package net.broscorp.generics;

import java.util.function.Function;

public interface MyCoolList<T> {

  public void add(T t);

  public T get(int index);

  public T remove(int index);

  public MyCoolList<T> map(Function<T, T> f);

  public int size();

}
