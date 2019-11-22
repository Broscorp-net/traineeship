package net.broscorp.m_override_overload;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class MathOperationSumTest {

  private MathOperationSum operationSum;

  @BeforeEach
  void setUp() {
    operationSum = new MathOperationSum();
  }

  @Test
  void testOperationPrimitivesInt() {
    int a = 5;
    int b = 5;
    assertEquals(10, operationSum.operation(a, b));
  }

  @Test
  void testOperationPrimitivesDouble() {
    double a = 5.5;
    double b = 5.2;
    assertEquals(10.7, operationSum.operation(a, b));
  }

  @Test
  void testOperationInteger() {
    Integer a = 4;
    Integer b = 20;
    assertEquals(24, operationSum.operation(a, b));
  }

  @Test
  void testOperationDouble() {
    Double a = 4.6;
    Double b = 20.3;
    assertEquals(24.9, operationSum.operation(a, b));
  }

  @Test
  void testOperationDoubleAndPrimitives() {
    Double a = 4.6;
    double b = 20.3;
    assertEquals(24.9, operationSum.operation(a, b));
  }
}