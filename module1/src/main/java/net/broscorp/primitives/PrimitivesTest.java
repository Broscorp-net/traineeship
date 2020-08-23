package net.broscorp.primitives;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;

import org.junit.jupiter.api.Test;

class PrimitivesTest {

  @Test
  void overflowMaxByteTest() {
    byte byteMax = Byte.MAX_VALUE;

    assertEquals(Byte.MIN_VALUE, ++byteMax);
  }

  @Test
  void overflowMinByteTest() {
    byte byteMin = Byte.MIN_VALUE;

    assertEquals(Byte.MAX_VALUE, --byteMin);
  }

  @Test
  void overflowMaxShortTest() {
    short shortMax = Short.MAX_VALUE;

    assertEquals(Short.MIN_VALUE, ++shortMax);
  }

  @Test
  void overflowMinShortTest() {
    short shortMin = Short.MIN_VALUE;

    assertEquals(Short.MAX_VALUE, --shortMin);
  }

  @Test
  void overflowMaxIntTest() {
    int intMax = Integer.MAX_VALUE;

    assertEquals(Integer.MIN_VALUE, ++intMax);
  }

  @Test
  void overflowMinIntTest() {
    int intMin = Integer.MIN_VALUE;

    assertEquals(Integer.MAX_VALUE, --intMin);
  }


  @Test
  void overflowMaxLongTest() {
    long longMax = Long.MAX_VALUE;

    assertEquals(Long.MIN_VALUE, ++longMax);
  }

  @Test
  void overflowMinLongTest() {
    long longMin = Long.MIN_VALUE;

    assertEquals(Long.MAX_VALUE, --longMin);
  }

  @Test
  void conversionLongToIntWithOverflowTest() {
    long l = Integer.MAX_VALUE + 1001;
    int i = (int) l;

    assertEquals(Integer.MIN_VALUE + 1000, i);
  }

  @Test
  void conversionLongToIntTest() {
    long l = Integer.MAX_VALUE;
    int i = (int) l;

    assertEquals(l, i);
  }

  @Test
  void conversionFloatToDoubleTest() {
    float f = 1.23456789f;
    double d = f;

    assertEquals(d,f);
  }

  @Test
  void errorsConversionFloatToDoubleTest() {
    float f = 1.23456789f;
    double d = f;

    assertEquals(f,d);
    assertNotEquals(1.23456789, d);
  }

  @Test
  void errorPrecisionAdditionFloatTest() {
    float resultAddition = -2.5f + 1.5f;
    float resultTenSubtraction = 0f;
    for (int i = 0; i < 10; i++) {
      resultTenSubtraction -= 0.1f;
    }

    assertNotEquals(resultTenSubtraction, resultAddition);
    assertEquals(-1f, resultAddition);
  }

  @Test
  void errorPrecisionDivisionFloatTest() {
    float resultDivision = -2.1f / 2.1f;
    float resultTenSubtraction = 0f;
    for (int i = 0; i < 10; i++) {
      resultTenSubtraction -= 0.1f;
    }

    assertNotEquals(resultTenSubtraction, resultDivision);
    assertEquals(-1f, resultDivision);
  }

  @Test
  void errorPrecisionMultiplicationFloatTest() {
    float resultMultiplication = -5.0f * 0.2f;
    float resultTenSubtraction = 0f;
    for (int i = 0; i < 10; i++) {
      resultTenSubtraction -= 0.1f;
    }

    assertNotEquals(resultTenSubtraction, resultMultiplication);
    assertEquals(-1f, resultMultiplication);
  }

  @Test
  void errorPrecisionSubtractionFloatTest() {
    float resultSubtraction = -0.9f - 0.1f;
    float resultTenSubtraction = 0f;
    for (int i = 0; i < 10; i++) {
      resultTenSubtraction -= 0.1f;
    }

    assertNotEquals(resultTenSubtraction, resultSubtraction);
    assertEquals(-1f, resultSubtraction);
  }

  @Test
  void errorPrecisionAdditionDoubleTest() {
    double resultAddition = 0.1 + 0.9;
    double resultTenAddition = 0;
    for (int i = 0; i < 10; i++) {
      resultTenAddition += 0.1;
    }

    assertNotEquals(resultTenAddition, resultAddition);
  }

  @Test
  void errorPrecisionDivisionDoubleTest() {
    double resultDivision = 1.0 / 0.1;
    double resultTenAddition = 0;

    for (int i = 0; i < 10; i++) {
      resultTenAddition += 0.1;
    }

    assertNotEquals(resultTenAddition, resultDivision);
  }

  @Test
  void errorPrecisionMultiplicationDoubleTest() {
    double resultMultiplication = 0.1 * 10.0;
    double resultTenAddition = 0;
    for (int i = 0; i < 10; i++) {
      resultTenAddition += 0.1;
    }
    assertNotEquals(resultTenAddition, resultMultiplication);
    assertEquals(1.0, resultMultiplication);
  }

  @Test
  void errorPrecisionSubtractionDoubleTest() {
    double resultSubtraction = 1.1 - 0.1;
    double resultTenAddition = 0;
    for (int i = 0; i < 10; i++) {
      resultTenAddition += 0.1;
    }
    assertNotEquals(resultTenAddition, resultSubtraction);
    assertEquals(1.0, resultSubtraction);
  }

}