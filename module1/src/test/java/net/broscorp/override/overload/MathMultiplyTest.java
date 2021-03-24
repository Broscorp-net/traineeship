package net.broscorp.override.overload;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

class MathMultiplyTest {
  private final MathMultiply mathMultiply = new MathMultiply();

  @Test
  void consumesIntTest() {
    int a = 2;
    int b = 2;
    assertEquals(mathMultiply.consumes(a, b), 4);
  }

  @Test
  void consumesPrimitiveDoubleTest() {
    double a = 2.0;
    double b = 2.0;
    assertEquals(mathMultiply.consumes(a, b), 4.0);
  }

  @Test
  void consumesDoubleTest() {
    Double a = 2.0;
    Double b = 2.0;
    assertEquals(mathMultiply.consumes(a, b), 4.0);
  }

  @Test
  void consumesIntegerTest() {
    Integer a = 2;
    Integer b = 2;
    assertEquals(mathMultiply.consumes(a, b), 4);
  }

  /**
   * compilation error.
   */
  @Test
  void consumesIntegerIntCheckTest() {
    Integer a = 1;
    int b = 1;
    //assertEquals(mathMultiply.consumes(a, b) , 2);
  }
}
