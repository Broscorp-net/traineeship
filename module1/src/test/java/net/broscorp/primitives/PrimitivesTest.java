package net.broscorp.primitives;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;


class PrimitivesTest {

  @Test
  void overflow() {
    int a = Integer.MAX_VALUE + 1;
    assertEquals(Integer.MIN_VALUE, a);
  }

  @Test
  void longToInt() {
    long a = Long.MAX_VALUE;
    int b = (int) a;
    assertEquals(-1, b);
  }

  @Test
  void floatToDouble() {
    float a = Float.MAX_VALUE;
    double b = (double) a;
    assertEquals(a, b);
  }

  @Test
  void floatPoint() {
    double a = 0.1 + 0.2;
    assertEquals(0.30000000000000003, a);
  }
}