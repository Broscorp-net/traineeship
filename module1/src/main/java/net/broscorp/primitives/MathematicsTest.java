package net.broscorp.primitives;

import org.junit.Test;
import org.junit.jupiter.api.Assertions;

public class MathematicsTest {

  @Test
  public void integerValueOverflow() {
    int actual = Integer.MAX_VALUE + 1;
    int expected = -2147483648;
    Assertions.assertEquals(expected, actual);
  }

  @Test
  public void longToInt() {
    long actual = 2147483649L;
    int expected = (int) actual;
    Assertions.assertNotEquals(expected, actual);
  }

  @Test
  public void doubleToFloat() {
    double actual = 3.1415926535897932384626433832795028841971693993751058209749445923078164062862;
    float expected = (float) actual;
    Assertions.assertNotEquals(expected, actual);
  }

  @Test
  public void faultFloatingPoint() {
    double actual = 3.0 - 2.1;
    double expected = 0.9;
    Assertions.assertNotEquals(expected, actual);
  }
}
