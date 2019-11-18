package net.broscorp.h_generics;

import java.util.function.Function;

public class FunctionClass implements Function<Object, Integer> {

  @Override
  public Integer apply(Object t) {

    if (t == null) {
      throw new NullPointerException();
    }
    Double b = (Double) t;
    Integer k = b.intValue();
    return k;
  }


}
