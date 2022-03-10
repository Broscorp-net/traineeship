package net.broscorp.primitives;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class MathTest {

  @Test
  public void integerOverFlow() {
    int actual = Integer.MAX_VALUE;
    int expected = Integer.MIN_VALUE;
    Assertions.assertEquals(expected, actual + 1);
  }

  @Test
  public void conversionLongToInt() {
    long actual = 2147483648L;
    int expected = (int) actual;
    Assertions.assertNotEquals(expected, actual);
  }

  @Test
  public void conversionDoubleToFloat() {
    double actual = Double.MAX_VALUE;
    float expected = (float) actual;
    Assertions.assertNotEquals(expected, actual);
  }

  @Test
  public void problemWithFloatingPoint() {
    double actual = 10.0 - 9.9;
    double expected = 0.1;
    Assertions.assertNotEquals(expected, actual);
  }
}
