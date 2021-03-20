package net.broscorp.primitives;

import java.util.function.BinaryOperator;
import java.util.function.Function;

public class OperationsOnPrimitives {

  public <T> T getSameTypeResultBinaryMethod(
      T firstParameter, T secondParameter, BinaryOperator<T> operator) {
    return operator.apply(firstParameter, secondParameter);
  }

  public <T, R> R getOtherTypeResultUnaryMethod(
      T originalPrimitiveParameter, Function<T, R> function) {
    return function.apply(originalPrimitiveParameter);
  }
}
