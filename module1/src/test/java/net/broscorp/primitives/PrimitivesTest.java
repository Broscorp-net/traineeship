package net.broscorp.primitives;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class PrimitivesTest {

  @Test
  public void testNumericOverflowExpectedSameValue() {
    int maxValue = Integer.MAX_VALUE;
    int minValue = Integer.MIN_VALUE;
    maxValue++;

    Assertions.assertEquals(maxValue, minValue);
  }

  @Test
  public void testLongToIntegerExpectedWrongValue() {
    long valueBeforeConvert = Long.MAX_VALUE;
    int valueAfterConvert = (int) valueBeforeConvert;

    Assertions.assertEquals(valueAfterConvert, -1);
  }

  @Test
  public void testFloatToDoubleExpectedWrongValue() {
    float valueBeforeConvert = 0.4f;
    double valueAfterConvert = valueBeforeConvert;

    Assertions.assertNotEquals(0.4, valueAfterConvert);
  }

  @Test
  public void testErrorFloatingPointNumbersExpectedWrongValue() {
    double expectedResult = 0.9;
    double result = 2.0 - 1.1;

    Assertions.assertNotEquals(result, expectedResult);
  }
}
