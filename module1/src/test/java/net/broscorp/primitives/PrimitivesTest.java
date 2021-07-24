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
    assertTrue(Integer.MAX_VALUE + 1 == Integer.MIN_VALUE);
  }

  @DisplayName("Negative overflow Integer type")
  @Test
  void testNegativeOverflowNumberTypes() {
    assertTrue((Integer.MIN_VALUE - 10) > Integer.MIN_VALUE);
    assertTrue(Integer.MIN_VALUE - 1 == Integer.MAX_VALUE);
  }

  @DisplayName("Conversion long to integer errors are possible")
  @Test
  void testConversionLongToInt() {
    long xLong = Integer.MAX_VALUE + 10L;
    int xInt = (int) xLong;
    assertNotEquals(xLong, xInt);
  }

  @DisplayName("Conversion integer to long - no errors")
  @Test
  void testConversionIntToLong() {
    int xInt = Integer.MAX_VALUE;
    long xLong;
    xLong = xInt;
    assertEquals(xLong, xInt);
  }

  @DisplayName("Conversion double to float errors are possible")
  @Test
  void testConversionDoubleTofFoat() {
    double xdouble = Double.MAX_VALUE + 10.;
    float xfloat = (int) xdouble;
    assertNotEquals(xdouble, xfloat);
  }

  @DisplayName("Conversion float to double - no errors")
  @Test
  void testConversionFloatToDouble() {
    float xfloat = Float.MAX_VALUE;
    double xdouble;
    xdouble = xfloat;
    assertEquals(xdouble, xfloat);
  }

  @DisplayName("Conversion int to float - loss of precision possible")
  @Test
  void testConversionIntToFloat() {
    int xInt = 1234567890;
    float xFloat = xInt;
    assertNotEquals((int) xFloat, xInt);
  }

  @DisplayName("Error with floating point")
  @Test
  void testFloatingPointError() {
    float xFloat = 0.1111111f;
    assertNotEquals(0.5555555, xFloat * 5);
  }
}
