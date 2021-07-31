package net.broscorp.override.overload;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

class MathMultiplyTest {

  @Test
  void method() {
    MathMultiply math = new MathMultiply();

    double x = math.doCalc(1.1, 2.2);

    assertEquals(2.42, x, 0.000001);
  }

  @Test
  void testMethod() {

    MathMultiply math = new MathMultiply();

    double x = math.doCalc(1, 5);

    assertEquals(5, x);
  }

  @Test
  void testMethod1() {
    MathMultiply math = new MathMultiply();

    Integer y = 2;
    Integer z = 3;

    double x = math.doCalc(z, y);

    assertEquals(6, x);
  }

  @Test
  void testMethod2() {
    MathMultiply math = new MathMultiply();

    Double y = 2.2;
    Double z = 3.3;

    double x = math.doCalc(z, y);

    assertEquals(7.26, x);
  }
}
