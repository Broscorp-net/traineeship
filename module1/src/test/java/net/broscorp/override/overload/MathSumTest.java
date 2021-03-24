package net.broscorp.override.overload;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

class MathSumTest {
  private final MathSum mathSum = new MathSum();

  @Test
  void consumesIntTest() {
    int a = 1;
    int b = 1;
    assertEquals(mathSum.consumes(a, b), 2);
  }

  @Test
  void consumesPrimitiveDoubleTest() {
    double a = 1.0;
    double b = 1.0;
    assertEquals(mathSum.consumes(a, b), 2.0);
  }

  @Test
  void consumesDoubleTest() {
    Double a = 1.0;
    Double b = 1.0;
    assertEquals(mathSum.consumes(a, b), 2.0);
  }

  @Test
  void consumesIntegerTest() {
    Integer a = 1;
    Integer b = 1;
    assertEquals(mathSum.consumes(a, b), 2);
  }

  /**
   * compilation error.
   */
  @Test
  void consumesIntegerIntCheckTest() {
    Integer a = 1;
    int b = 1;
    //assertEquals(mathSum.consumes(a, b) , 2);
  }
}
