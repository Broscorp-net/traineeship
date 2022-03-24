package net.broscorp.primitives;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;

class PrimitivesTest {

  @Test
  public void shouldThrowWhenOverflowingInt() {
    assertThrows(ArithmeticException.class, () -> {
      int value = Integer.MAX_VALUE;
      value = Math.addExact(value, 1);
    });
  }

  @Test
  public void shouldBeNotEqualWhenConvertingBigLongToInt() {
    long expected = Long.MAX_VALUE;
    int actual = (int) expected;
    assertNotEquals(expected, actual);
  }

  @Test
  public void shouldBeNotEqualWhenConvertingBigDoubleToFloat() {
    double expected = Double.MAX_VALUE;
    float actual = (float) expected;
    assertNotEquals(expected, actual);
  }

  @Test
  public void shouldBeNotEqualWhenRunningOutOfMantissaSize() {
    double expected = 0.3;
    double actual = 0.1 + 0.2;
    assertNotEquals(expected, actual);
  }

}