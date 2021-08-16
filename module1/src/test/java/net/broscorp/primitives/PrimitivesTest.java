package net.broscorp.primitives;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;

import org.junit.jupiter.api.Test;

public class PrimitivesTest {

  @Test
  void byteOverflowIncrementationTest() {
    byte b = 127;
    assertEquals(Byte.MIN_VALUE, ++b);
  }

  @Test
  void intOverflowMultiplicationTest() {
    int min = Integer.MIN_VALUE;
    int max = Integer.MAX_VALUE;

    assertEquals(-2147483648, min * max);
    assertEquals(1, max * max);
  }

  @Test
  void longToIntConversionProblemTest() {
    long l = Long.MAX_VALUE;
    int i = (int) l;

    assertNotEquals(l, i);
    assertEquals(-1, i);
  }

  @Test
  void floatToDoubleConversionProblemTest() {
    float f = 2;
    double aDiv = Math.sqrt(f); // expected result  1.41421356237309504

    assertEquals(1.4142135623730951, aDiv, 0);
  }

  @Test
  void floatingPointErrorTest() {
    double a = 0.6000001;
    float b = 0.3999999f;
    double sum = a + b;

    assertEquals(0.999999986751175, sum, 0);
  }
}
