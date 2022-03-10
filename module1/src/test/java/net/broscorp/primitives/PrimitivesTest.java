package net.broscorp.primitives;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;

import org.junit.jupiter.api.Test;

class PrimitivesTest {

  @Test
  void integerOverflowTest() {
    int x = 2147483647;

    assertEquals(x + 1, -2147483648);
  }

  @Test
  void shouldConvertLongToInt() {
    long l = 123415L;
    int i = 123415;

    assertEquals(l, i);
  }

  @Test
  void shouldConvertLongToIntIfLongVeryBig() {
    long l = 34299732874445L;
    int i = (int) l;

    assertNotEquals(l, i);
  }

  @Test
  void shouldConvertFloatToDouble() {
    float f = 345f;

    assertEquals(f, 345d);
  }

  @Test
  void shouldConvertDoubleToFloatIfDoubleBig() {
    float f = 345.90f;

    assertNotEquals(f, 345.90d);
  }

  @Test
  void wrongFloatingPointFirstTest() {
    float f = 1.333f;

    assertNotEquals(3.999, f * 3);
  }

  @Test
  void wrongFloatingPointSecondTest() {
    double d = 1.333d;

    assertEquals(3.9989999999999997, d * 3);
  }
}