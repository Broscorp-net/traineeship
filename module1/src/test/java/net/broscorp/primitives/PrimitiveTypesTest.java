package net.broscorp.primitives;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;

import org.junit.jupiter.api.Test;

public class PrimitiveTypesTest {

  @Test
  public void byteOverflow() {
    //given
    byte byteType = Byte.MAX_VALUE;
    //when
    byteType++;
    //then
    assertEquals(byteType, Byte.MIN_VALUE);
  }

  @Test
  public void shortOverflow() {
    //given
    short shortType = Short.MAX_VALUE;
    //when
    shortType++;
    //then
    assertEquals(shortType, Short.MIN_VALUE);
  }

  @Test
  public void integerOverflow() {
    //given
    int intType = Integer.MAX_VALUE;
    //when
    intType++;
    //then
    assertEquals(intType, Integer.MIN_VALUE);
  }

  @Test
  public void longOverflow() {
    //given
    long longType = Long.MAX_VALUE;
    //when
    longType++;
    //then
    assertEquals(longType, Long.MIN_VALUE);
  }

  @Test
  public void floatPositiveInfinityOverflow() {
    //given
    float floatType = Float.MAX_VALUE;
    //when
    floatType *= 2; //increase one of the significant bits
    //then
    assertEquals(floatType, Float.POSITIVE_INFINITY);
  }

  @Test
  public void floatNegativeInfinityOverflow() {
    //given
    float floatType = Float.MAX_VALUE;
    //when
    floatType *= (-2); //decrease one of the significant bits
    //then
    assertEquals(floatType, Float.NEGATIVE_INFINITY);
  }

  @Test
  public void doublePositiveInfinityOverflow() {
    //given
    double doubleType = Double.MAX_VALUE;
    //when
    doubleType *= 2;
    //then
    assertEquals(doubleType, Double.POSITIVE_INFINITY);
  }

  @Test
  public void doubleNegativeInfinityOverflow() {
    //given
    double doubleType = Double.MAX_VALUE;
    //when
    doubleType *= (-2);
    //then
    assertEquals(doubleType, Double.NEGATIVE_INFINITY);
  }

  @Test
  public void byteUnderflow() {
    //given
    byte byteType = Byte.MIN_VALUE;
    //when
    byteType--;
    //then
    assertEquals(byteType, Byte.MAX_VALUE);
  }

  @Test
  public void shortUnderflow() {
    //given
    short shortType = Short.MIN_VALUE;
    //when
    shortType--;
    //then
    assertEquals(shortType, Short.MAX_VALUE);
  }

  @Test
  public void intUnderflow() {
    //given
    int intType = Integer.MIN_VALUE;
    //when
    intType--;
    //then
    assertEquals(intType, Integer.MAX_VALUE);
  }

  @Test
  public void longUnderflow() {
    //given
    long longType = Long.MIN_VALUE;
    //when
    longType--;
    //then
    assertEquals(longType, Long.MAX_VALUE);
  }

  @Test
  public void doublePositiveUnderflow() {
    //given
    //when
    double result = Math.pow(2, -1075); // -1074 is the minimum exponent for a double
    //then
    assertEquals(result, 0.0);
  }

  @Test
  public void doubleNegativeUnderflow() {
    //given
    //when
    double result = Math.pow(-2, -1075);
    //then
    assertEquals(result, -0.0);
  }

  // Primitive types casting
  // the larger number will lose some of the bits and would be represented incorrectly

  @Test
  public void convertPositiveLongToInt() {
    //given
    long longType = Long.MAX_VALUE;
    int intType;
    //when
    intType = (int) longType;
    //then
    assertNotEquals(intType, longType);
    assertEquals(intType, -1);
  }

  @Test
  public void convertNegativeLongToInt() {
    //given
    long longType = Long.MIN_VALUE;
    int intType;
    //when
    intType = (int) longType;
    //then
    assertNotEquals(intType, longType);
    assertEquals(intType, 0);
  }

  @Test
  public void convertPositiveDoubleToFloat() {
    //given
    double doubleType = Double.MAX_VALUE;
    float floatType;
    //when
    floatType = (float) doubleType;
    //then
    assertNotEquals(floatType, doubleType);
    assertEquals(floatType, Float.POSITIVE_INFINITY);
  }

  @Test
  public void convertNegativeDoubleToFloat() {
    //given
    double doubleType = Double.MIN_VALUE;
    float floatType;
    //when
    floatType = (float) doubleType;
    //then
    assertNotEquals(floatType, doubleType);
    assertEquals(floatType, 0.0);
  }

  // Precision Errors

  @Test
  public void floatSumRoundingError() {
    //given
    float x = 0.4f;
    float y = 0.3f;
    //when
    float result = x + y;
    //then
    assertNotEquals(0.7f, result);
  }

  @Test
  public void twoDoublesNotEquals() {
    //given
    double x = 0.8;
    double y = 0.10;
    //when
    double sumResult = x + 0.1;
    double subResult = y - 0.1;
    //then
    assertNotEquals(sumResult, subResult);
  }

  @Test
  public void doubleMultiplicationPrecisionError() {
    //given
    //when
    double result = 0.2 * 0.2;
    //then
    assertNotEquals(result, 0.04);
  }
}
