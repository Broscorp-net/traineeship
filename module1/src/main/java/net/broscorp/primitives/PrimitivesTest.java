package net.broscorp.primitives;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

public class PrimitivesTest {

  @Test
  void givenByteMinValue_whenSubtractOne_thenByteMaxValueReturned() {
    byte expected = Byte.MAX_VALUE;

    byte actual = (byte) (Byte.MIN_VALUE - 1);

    assertEquals(expected, actual);
  }

  @Test
  void givenByteMaxValue_whenAddOne_thenByteMinValueReturned() {
    byte expected = Byte.MIN_VALUE;

    byte actual = (byte) (Byte.MAX_VALUE + 1);

    assertEquals(expected, actual);
  }

  @Test
  void givenShortMaxValue_whenAddOne_thenShortMinValueReturned() {
    short expected = Short.MIN_VALUE;

    short actual = (short) (Short.MAX_VALUE + 1);

    assertEquals(expected, actual);
  }

  @Test
  void givenShortMinValue_whenSubtractOne_thenShortMaxValueReturned() {
    short expected = Short.MAX_VALUE;

    short actual = (short) (Short.MIN_VALUE - 1);

    assertEquals(expected, actual);
  }

  @Test
  void givenIntegerMaxValue_whenAddOne_thenIntegerMinValueReturned() {
    int expected = Integer.MIN_VALUE;

    int actual = Integer.MAX_VALUE + 1;

    assertEquals(expected, actual);
  }

  @Test
  void givenIntegerMinValue_whenSubtractOne_thenIntegerMaxValueReturned() {
    int expected = Integer.MAX_VALUE;

    int actual = Integer.MIN_VALUE - 1;

    assertEquals(expected, actual);
  }

  @Test
  void givenFloatValue_whenDivideByZero_thenFloatNegativeInfinityReturned() {
    float expected = Float.NEGATIVE_INFINITY;

    float actual = (float) (-1.0 / 0.0);

    assertEquals(expected, actual);
  }

  @Test
  void givenFloatMinValue_whenMultipleByTwo_thenFloatPositiveInfinityReturned() {
    float expected = Float.POSITIVE_INFINITY;

    float actual = Float.MAX_VALUE * 2;

    assertEquals(expected, actual);
  }


  @Test
  void givenDoubleMaxValue_whenMultipleByTwo_thenDoublePositiveInfinityReturned() {
    double expected = Double.POSITIVE_INFINITY;

    double actual = Double.MAX_VALUE * 2;

    assertEquals(expected, actual);
  }

  @Test
  void givenDoubleValue_whenDivideByZero_thenDoubleNegativeInfinityReturned() {
    double expected = Double.NEGATIVE_INFINITY;

    double actual = -1.0 / 0.0;

    assertEquals(expected, actual);
  }

  @Test
  void givenLongMinValue_whenSubtractOne_thenLongMaxValueReturned() {
    long expected = Long.MAX_VALUE;

    long actual = Long.MIN_VALUE - 1;

    assertEquals(expected, actual);
  }

  @Test
  void givenLongMaxValue_whenAddOne_thenLongMinValueReturned() {
    long expected = Long.MIN_VALUE;

    long actual = Long.MAX_VALUE + 1;

    assertEquals(expected, actual);
  }

  @Test
  void givenLongValue_whenConvertToInt_thenDataLoss() {
    long value = 2147483648L;

    int actual = (int) value;

    assertEquals(Integer.MIN_VALUE, actual);
  }

  @Test
  void givenFloatValue_whenConvertToDouble_thenAutomaticallyConverted() {
    float expected = Float.MAX_VALUE;

    double actual = expected;

    assertEquals(expected, actual);
  }

  @Test
  void givenDoubleValue_whenSubtractOperation_thenSumValuesNumberError() {
    double expected = 0.8999999999999999d;

    double actual = 2.0 - 1.1;

    assertEquals(expected, actual);
  }

  @Test
  void givenFloatValue_whenSubtractOperation_thenSumValuesNumberError() {
    float expected = 1.0000001f;

    float actual = 0.1f + 0.1f + 0.1f + 0.1f + 0.1f + 0.1f + 0.1f + 0.1f + 0.1f + 0.1f;

    assertEquals(expected, actual);
  }

}
