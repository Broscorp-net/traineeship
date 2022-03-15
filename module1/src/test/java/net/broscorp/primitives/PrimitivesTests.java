package net.broscorp.primitives;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class PrimitivesTests {

  int maxIntegerValue = Integer.MAX_VALUE;
  int minIntegerValue = Integer.MIN_VALUE;


  @Test
  void integerOverflowWithMinValueTest() {
    assertEquals(minIntegerValue, maxIntegerValue + 1);
  }

  @Test
  void integerOverflowWithMaxValueTest() {
    assertEquals(maxIntegerValue, minIntegerValue - 1);
  }

  @Test
  void conversionLongToInteger() {
    long valueForCorrectConversion = 777L;
    assertEquals(valueForCorrectConversion, (int) valueForCorrectConversion);
  }

  @Test
  void conversionLongToIntegerWithOverflow() {
    long valueForWrongConversion = 7777777777777777777L;
    assertThrows(ArithmeticException.class, () -> Math.toIntExact(valueForWrongConversion));
  }

  @Test
  void conversionDoubleToFloat() {
    Double valueForCorrectConversion = 123.0;
    assertEquals(valueForCorrectConversion, valueForCorrectConversion.floatValue());
  }

  @Test
  void conversionDoubleToFloatWithAdmissibleError() {
    double valueForCorrectConversionWithAdmissibleError = 444.4;
    assertEquals(valueForCorrectConversionWithAdmissibleError,
        (float) valueForCorrectConversionWithAdmissibleError, 0.00001);
  }
}
