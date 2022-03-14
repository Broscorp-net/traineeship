package primitives;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;


public class PrimitivesTest {

  @Test
  public void integerOverflow() {
    int firstInteger = Integer.MAX_VALUE;

    int secondInteger = firstInteger + 1;

    Assertions.assertEquals(Integer.MIN_VALUE,secondInteger);
  }

  @Test
  public void convertLongToIntBugs() {
    long maxIntegerValueNumberInLongFormat = 2147483648L;

    int convertedIntNumber = (int) maxIntegerValueNumberInLongFormat;

    Assertions.assertEquals(Integer.MIN_VALUE,convertedIntNumber);
  }

  @Test
  public void convertDoubleToFloatGettingInfinity() {
    double n = 3.4E+39D;

    float convertedFloatNumber = (float) n;

    Assertions.assertEquals(Float.POSITIVE_INFINITY, convertedFloatNumber);
  }

  @Test
  public void convertDoubleToFloatLossOfPrecision() {

    double firstNumber = 1.0;

    double secondNumber = 3.0;

    double resultDouble = firstNumber / secondNumber;

    float convertedFloatNumber = (float) resultDouble;

    Assertions.assertNotEquals(0.3333333333333333, convertedFloatNumber);
  }

  @Test
  public void floatingPointError() {
    double roundResult = Math.round(2.0 - 1.1);

    Assertions.assertEquals(1.0, roundResult);
    Assertions.assertNotEquals(0.9, roundResult);
  }

}
