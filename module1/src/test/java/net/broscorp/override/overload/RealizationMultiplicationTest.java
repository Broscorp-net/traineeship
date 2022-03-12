package net.broscorp.override.overload;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

class RealizationMultiplicationTest {
  private static final MathOperation operation = new RealizationMultiplication();

  @Test
  void multiplicationPrimitiveInt() {
    Assertions.assertEquals(6, operation.operation(2, 3));
  }

  @Test
  void multiplicationPrimitiveDouble() {
    Assertions.assertEquals(1.25, operation.operation(0.5, 2.5));
  }

  @Test
  void multiplicationInteger() {
    Integer a = new Integer(2);
    Integer b = new Integer(3);
    Assertions.assertEquals(6, operation.operation(a, b));
  }

  @Test
  void multiplicationDouble() {
    Double a = new Double(2.5);
    Double b = new Double(0.5);
    Assertions.assertEquals(1.25, operation.operation(a, b));
  }

}