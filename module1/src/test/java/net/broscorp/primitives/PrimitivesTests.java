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
  void conversionLongToIntegerWithOverflow() {
    long valueForWrongConversion = 7777777777777777777L;
    Assertions.assertThrows(ArithmeticException.class,
        () -> Math.toIntExact(valueForWrongConversion));
  }

  @Test
  void conversionDoubleToFloatEquals() {
    double valueForCorrectConversion = 444.4;
    Assertions.assertEquals(valueForCorrectConversion,
        (float) valueForCorrectConversion, 0.00001);
  }

  @Test
  void conversionDoubleToFloatNotEquals() {
    double maxDoubleValue = Double.MAX_VALUE;
    float convertedValue = (float) maxDoubleValue;
    Assertions.assertNotEquals(maxDoubleValue, convertedValue);
  }

  @Test
  void conversionDoubleToFloatWithAdmissibleError() {
    double valueD = 100;
    valueD /= 3;
    float valueF = (float) valueD;
    Assertions.assertNotSame(valueD, valueF);
  }
}
