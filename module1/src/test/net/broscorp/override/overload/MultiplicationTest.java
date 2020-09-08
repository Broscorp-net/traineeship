package net.broscorp.override.overload;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

class MultiplicationTest {

  Multiplication multiplication = new Multiplication();

  @Test
  void doublePrimitivesMultiplicationTest() {
    double d1 = 10.0;
    double d2 = 2.0;
    double expect = 20.0;
    double result = multiplication.calculate(d1, d2);
    assertEquals(expect, result);
  }

  @Test
  void doublePrimitivesMultiplicationWithCastingTest() {
    double d1 = 10.0;
    double d2 = 2.0;
    double expect = 20.0;
    double result = multiplication.calculate((Double) d1, (Double) d2);
    assertEquals(expect, result);
  }

  @Test
  void intPrimitivesMultiplicationTest() {
    int i1 = 10;
    int i2 = 2;
    double expect = 20.0;
    double result = multiplication.calculate(i1, i2);
    assertEquals(expect, result);
  }

  @Test
  void intPrimitivesMultiplicationWithCastingTest() {  double d1 = 10.0;
    int i1 = 10;
    int i2 = 2;
    double expect = 20.0;
    double result = multiplication.calculate((Integer) i1, (Integer) i2);
    assertEquals(expect, result);
  }
}
