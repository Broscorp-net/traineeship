package net.broscorp.override.overload;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

class SumTest {

  private final Sum sum = new Sum();

  @Test
  void sumWithDouble1Test() {
    assertEquals(15.0d, sum.calculate(5.0d, 10.0d));
  }

  @Test
  void sumWithDouble2Test() {
    assertEquals(15.0d, sum.calculate(Double.valueOf(5.0d), Double.valueOf(10.0d)));
  }

  @Test
  void sumWithIntTest() {
    assertEquals(15, sum.calculate(5, 10));
  }

  @Test
  void sumWithIntegerTest() {
    assertEquals(15, sum.calculate(Integer.valueOf(5), Integer.valueOf(10)));
  }

  @Test
  void sumWithIntAndDouble() {
    Double d = new Double(5);
    int c = 10;
    assertEquals(15, sum.calculate(d, c));
  }
}