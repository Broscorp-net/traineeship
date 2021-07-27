package net.broscorp.primitives;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;


class PrimitivesCheckTest {

  PrimitivesCheck primitive;

  @BeforeEach
  void init() {
    primitive = new PrimitivesCheck();
  }

  /**
   * This test is indicative for all numeric types.
   */
  @Test
  void typeOverflowTest() {
    byte expected = Byte.MAX_VALUE;
    byte actual = primitive.typeOverflow(expected);
    Assertions.assertEquals(expected, actual);
  }

  @Test
  void longToIntConversionTest() {
    long expected = Long.MAX_VALUE;
    int actual = primitive.longToIntConversion(expected);
    Assertions.assertEquals(expected, actual);
  }

  @Test
  void floatToDoubleConversionTest() {
    float expected = Float.MIN_VALUE;
    double actual = primitive.floatToDoubleConversion(expected);
    Assertions.assertEquals(expected, actual);
  }


  /**
   * погрешность при работе с числами с плавающей точкой.
   */

  @Test
  void internalBinaryRepresentationOfNumbers() {
    double expected = 0.1;
    double actual = primitive.internalBinaryRepresentationOfNumbers(0.5, 0.4);
    Assertions.assertEquals(expected, actual);
  }

  @Test
  void smallestValueForTypeDoubleTest() {
    double minFirst = Double.MIN_VALUE;
    double minSecond = 0.0;
    Assertions.assertEquals(minFirst, minSecond);
  }

  @Test
  void floatingPointAdditionErrorTest() {
    float f1 = 0.4f;
    float f2 = 0.3f;
    float num = 0.7f;
    float res = f1 + f2;
    Assertions.assertEquals(num, res);
  }
}