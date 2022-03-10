package net.broscorp.primitives;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.Test;

class PrimitivesTest {

  @Test
  void testForNumericTypeOverflowForMax() {
    int maxValue = Integer.MAX_VALUE;
    assertFalse(maxValue < maxValue + 1);
  }

  @Test
  void testForNumericTypeOverflowForMin() {
    int maxValue = Integer.MIN_VALUE;
    assertFalse(maxValue > maxValue + 1);
  }

  @Test
  void testForCastingLongToInt() {
    long longValue = Long.MAX_VALUE;
    int intValue = (int) longValue;
    assertFalse(longValue == intValue);
  }

  @Test
  void testForCastingIntToLong() {
    int intValue = Integer.MAX_VALUE;
    long longValue = (long) intValue;
    assertTrue(longValue == intValue);
  }

  @Test
  void testForCastingDoubleToFloat() {
    double doubleValue = Double.MAX_VALUE;
    float floatValue = (float) doubleValue;
    assertFalse(doubleValue == floatValue);
  }

  @Test
  void testForCastingFloatToDouble() {
    float floatValue = Float.MAX_VALUE;
    double doubleValue = (double) floatValue;
    assertTrue(doubleValue == floatValue);
  }

  @Test
  void testForTypesWithFloatingPoint() {
    double doubleValue = 0.1 + 0.1 + 0.1 + 0.1 + 0.1 + 0.1 + 0.1 + 0.1 + 0.1 + 0.1;
    double expectedDoubleValue = 1;
    float floatValue = 0.1f + 0.1f + 0.1f + 0.1f + 0.1f + 0.1f + 0.1f + 0.1f + 0.1f + 0.1f;
    float expectedFloatValue = 1f;
    assertFalse(doubleValue == expectedDoubleValue);
    assertFalse(floatValue == expectedFloatValue);
  }


}