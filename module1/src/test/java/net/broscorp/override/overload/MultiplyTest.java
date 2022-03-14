package net.broscorp.override.overload;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

class MultiplyTest {

  private final Multiply multiply = new Multiply();

  @Test
  void multiplyWithDouble1Test() {
    assertEquals(20.0d, multiply.calculate(4.0d, 5.0d));
  }

  @Test
  void multiplyWithDouble2Test() {
    assertEquals(20.0d, multiply.calculate(Double.valueOf(4.0d), Double.valueOf(5.0d)));
  }

  @Test
  void multiplyWithIntTest() {
    assertEquals(20, multiply.calculate(4, 5));
  }

  @Test
  void multiplyWithIntegerTest() {
    assertEquals(20, multiply.calculate(Integer.valueOf(4), Integer.valueOf(5)));
  }
}