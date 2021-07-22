package net.broscorp.primitives;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNotEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

public class PrimitivesTest {

  /**
   * Test overflow and underflow for primitives byte, short, int and long.
   */

  @Test
  void testByteOverflow() {
    assertTrue((byte) (Byte.MAX_VALUE + 1) == Byte.MIN_VALUE);
  }

  @Test
  void testShortOverflow() {
    assertTrue((short) (Short.MAX_VALUE + 1) == Short.MIN_VALUE);
  }

  @Test
  void testIntOverflow() {
    assertTrue(Integer.MAX_VALUE + 1 == Integer.MIN_VALUE);
  }

  @Test
  void testLongOverflow() {
    assertTrue((long) (Long.MAX_VALUE + 1) == Long.MIN_VALUE);
  }

  @Test
  void testByteUnderflow() {
    assertTrue((byte) (Byte.MIN_VALUE - 1) == Byte.MAX_VALUE);
  }

  @Test
  void testShortUnderflow() {
    assertTrue((short) (Short.MIN_VALUE - 1) == Short.MAX_VALUE);
  }

  @Test
  void testIntUnderflow() {
    assertTrue(Integer.MIN_VALUE - 1 == Integer.MAX_VALUE);
  }

  @Test
  void testLongUnderflow() {
    assertTrue((long) (Integer.MIN_VALUE - 1) == Integer.MAX_VALUE);
  }

  /**
   * Assert that casting to a larger range primitive (upcasting) is save and does not lead to
   * precision loss.
   */

  @ParameterizedTest
  @ValueSource(bytes = {1, 5, 100, Byte.MAX_VALUE, Byte.MIN_VALUE, -100, -50, -5})
  void testByteToShortIsOk(byte b) {
    assertEquals(b, (short) b);
  }

  @ParameterizedTest
  @ValueSource(shorts = {1000, 10000, 20000, Short.MAX_VALUE, Short.MIN_VALUE, -1000, -10000,
      -20000})
  void testShortToIntIsOk(short s) {
    assertEquals(s, (int) s);
  }

  @ParameterizedTest
  @ValueSource(ints = {100000, 1000000, Integer.MAX_VALUE, Integer.MIN_VALUE, -100000, -1000000})
  void testIntToLongIsOk(int s) {
    assertEquals(s, (long) s);
  }

  /**
   * Assert that casting to a larger range primitive (upcasting) is implicit
   */

  @ParameterizedTest
  @ValueSource(bytes = {1, 5, 100, Byte.MAX_VALUE, Byte.MIN_VALUE, -100, -50, -5})
  void testByteToShortIsImplicit(byte b) {
    short s = b;
    assertEquals(b, s);
  }

  @ParameterizedTest
  @ValueSource(shorts = {1000, 10000, 20000, Short.MAX_VALUE, Short.MIN_VALUE, -1000, -10000,
      -20000})
  void testShortToIntIsImplicit(short s) {
    int i = s;
    assertEquals(s, i);
  }

  @ParameterizedTest
  @ValueSource(ints = {100000, 1000000, Integer.MAX_VALUE, Integer.MIN_VALUE, -100000, -1000000})
  void testIntToLongIsImplicit(int s) {
    long l = s;
    assertEquals(s, l);
  }

  /**
   * Assert that casting to a smaller range primitive (downcasting) is not save and may result in
   * precision loss if converted primitive's range exceeds target type. We can only downcast
   * explicitly. Failure to explicitly downcast results in compile error.
   */

  @ParameterizedTest
  @ValueSource(longs = {Long.MAX_VALUE, Long.MIN_VALUE})
  void testCastingLongToIntResultsInPrecisionLoss(long l) {
    assertNotEquals(l, (int) l);
  }

  @ParameterizedTest
  @ValueSource(ints = {Integer.MAX_VALUE, Integer.MIN_VALUE})
  void testCastingIntToShortResultsInPrecisionLoss(int i) {
    assertNotEquals(i, (short) i);
  }

  @ParameterizedTest
  @ValueSource(shorts = {Short.MAX_VALUE, Short.MIN_VALUE})
  void testCastingShortToByteResultsInPrecisionLoss(short s) {
    assertNotEquals(s, (byte) s);
  }

  @ParameterizedTest
  @ValueSource(doubles = {15.0000, 20.0000000, -15.00, -100.00, 51616.00})
  void testDoubleToIntResultsInNoLossOfPrecisionIfDecimalsAreZeroes(double d) {
    assertTrue(d == (int) d);
  }

  @Test
  void testDoubleToIntRoundsDown() {
    double d = 15.75;
    assertEquals(15, (int) d);
    assertNotEquals(16, (int) d);
  }

  @ParameterizedTest
  @ValueSource(floats = {15.16f, Float.MAX_VALUE, Float.MIN_VALUE})
  void testFloatToDoubleIsImplicit(float f) {
    double d = f;
    assertEquals(d, f);
  }

  @ParameterizedTest
  @ValueSource(doubles = {Double.MAX_VALUE, Double.MIN_VALUE})
  void testDoubleToFloatIsNotSafe(double d) {
    assertNotEquals(d, (float) d);
  }

  /**
   * Floating point.
   */

  @Test
  void testImplicitRoundingIntToZero() {
    int i = 27;
    int b = 27 / 2;
    assertNotEquals(i % 2, 0);
    assertEquals(13, b);
  }

  @Test
  void testImplicitRoundingDoubleToZero() {
    int i = 13;
    double b = 13 / 3;
    assertNotEquals(i % 2, 0);
    assertNotEquals(4.33333333333, 4.0);
    assertEquals(4.0, b);
  }

  @Test
  void testRoundingErrorWithSum() {
    double a = 0.7;
    double b = 0.1;
    double sum = a + b;
    assertEquals(0.7999999999999999, sum);
  }

  @Test
  void testDifferentRoundingModeForSumAndSubstaction() {
    double a = 0.7;
    double b = 0.9;
    double c = 0.1;
    double x = a + c;
    double y = b - c;
    assertEquals(0.7999999999999999, x);
    assertEquals(0.8, y);
    assertFalse(x == y);
  }

  @Test
  void testRoundingOffErrorWhenUsingMathRoundMethod() {
    double d = 13.56;
    double rounded = Math.round(d);
    assertEquals(rounded, 14);
  }

  @Test
  void testRoundingOffErrorWhenUsingMathRoundMethod2() {
    double d = 13.49;
    double rounded = Math.round(d);
    assertEquals(rounded, 13);
  }
}

