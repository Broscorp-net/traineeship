package net.broscorp.primitives;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;


public class PrimitivesTests {

  int maxIntegerValue = Integer.MAX_VALUE;
  int minIntegerValue = Integer.MIN_VALUE;


  @Test
  void integerOverflowWithMinValueTest() {
    Assertions.assertEquals(minIntegerValue, maxIntegerValue + 1);
  }

  @Test
  void integerOverflowWithMaxValueTest() {
    Assertions.assertEquals(maxIntegerValue, minIntegerValue - 1);
  }

  @Test
  void conversionLongToInteger() {
    long valueForCorrectConversion = 777L;
    Assertions.assertEquals(valueForCorrectConversion, (int) valueForCorrectConversion);
  }

  @Test
  void conversionDoubleToFloat() {
    Double valueForCorrectConversion = 123.0;
    Assertions.assertEquals(valueForCorrectConversion, valueForCorrectConversion.floatValue());
  }

  @Test
  void conversionDoubleToFloatWithAdmissibleError() {
    double valueForCorrectConversionWithAdmissibleError = 444.4;
    Assertions.assertEquals(valueForCorrectConversionWithAdmissibleError,
        (float) valueForCorrectConversionWithAdmissibleError, 0.00001);
  }
}
