package net.broscorp.primitives;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

class PrimitivesTest {

  @Test
  void byteShouldBeNegative() {
    byte b = 120;
    b += 19;
    Assertions.assertEquals(-117, b);
  }

  @Test
  void byteShouldBePositive() {
    byte b = -120;
    b += -19;
    Assertions.assertEquals(117, b);
  }

  @Test
  void longShouldCastToIntWhichNonEqualLong() {
    long first = 9847483649L;
    int i = (int) first;
    Assertions.assertNotEquals(first, i);
  }

  @Test
  void longShouldCastToIntWhichShouldBeAnother() {
    long l = 9847483649L;
    int i = (int) l;
    Assertions.assertEquals(1257549057, i);
  }

  @Test
  void doubleShouldCastToFloatWhichNonEqualDouble() {
    double d = 10.11111111111;
    float f = (float) d;
    Assertions.assertNotEquals(d, f);
  }

  @Test
  void floatAndDoubleShouldBeDifferent() {
    int a = 10;
    int b = 3;
    float f = (float) a / b;
    double d = (double) a / b;
    Assertions.assertNotEquals(f, d);
  }
}
