package net.broscorp.primitives;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;


class PrimitivesTest {

  @DisplayName("Positive overflow Integer type")
  @Test
  void testPositiveOverflowNumberTypes() {
    assertTrue((Integer.MAX_VALUE + 10) < Integer.MAX_VALUE);
    assertEquals(Integer.MAX_VALUE + 1, Integer.MIN_VALUE);
  }

  @DisplayName("Negative overflow Integer type")
  @Test
  void testNegativeOverflowNumberTypes() {
    assertTrue((Integer.MIN_VALUE - 10) > Integer.MIN_VALUE);
    assertEquals(Integer.MIN_VALUE - 1, Integer.MAX_VALUE);
  }

  @DisplayName("Conversion long to integer errors are possible")
  @Test
  void testConversionLongToInt() {
    long varLong = Integer.MAX_VALUE + 10L;
    int varInt = (int) varLong;
    assertNotEquals(varLong, varInt);
  }

  @DisplayName("Conversion integer to long - no errors")
  @Test
  void testConversionIntToLong() {
    int varInt = Integer.MAX_VALUE;
    long varLong;
    varLong = varInt;
    assertEquals(varLong, varInt);
  }

  @DisplayName("Conversion double to float errors are possible")
  @Test
  void testConversionDoubleTofFoat() {
    double varDouble = Double.MAX_VALUE + 10.;
    float varFloat = (int) varDouble;
    assertNotEquals(varDouble, varFloat);
  }

  @DisplayName("Conversion float to double - no errors")
  @Test
  void testConversionFloatToDouble() {
    float varFloat = Float.MAX_VALUE;
    double varDouble;
    varDouble = varFloat;
    assertEquals(varDouble, varFloat);
  }

  @DisplayName("Conversion int to float - loss of precision possible")
  @Test
  void testConversionIntToFloat() {
    int varInt = 1234567890;
    float varFloat = varInt;
    assertNotEquals((int) varFloat, varInt);
  }

  @DisplayName("Error with floating point")
  @Test
  void testFloatingPointError() {
    float varFloat = 0.1111111f;
    assertNotEquals(0.5555555, varFloat * 5);
  }
}
