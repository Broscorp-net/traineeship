package net.broscorp.m_override_overload;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class MathOperationMultiplyTest {

  @Test
  void testOperationPrimitivesInt() {
    int a = 5;
    int b = 5;
    assertEquals(25, new MathOperationMultiply().operation(a, b));
  }

  @Test
  void testOperationPrimitivesDouble() {
    double a = 5.3;
    double b = 4.6;
    assertEquals(24.38, new MathOperationMultiply().operation(a, b));
  }

  @Test
  void testOperationInteger() {
    Integer a = 4;
    Integer b = 20;
    assertEquals(80, new MathOperationMultiply().operation(a, b));
  }

  @Test
  void testOperationDouble() {
    Double a = 4.6;
    Double b = 20.3;
    assertEquals(93.38, new MathOperationMultiply().operation(a, b));
  }

  @Test
  void testOperationDoubleAndPrimitives() {
    Double a = 4.6;
    double b = 20.3;
    assertEquals(93.38, new MathOperationMultiply().operation(a, b));
  }
}