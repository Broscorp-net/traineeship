package net.broscorp.h_generics;

import java.util.function.Function;

public interface List<E> {

  public void add(E e);

  public E get(int index);

  public E remove(int index);

  public E map(Function<?, ?> f);

}

