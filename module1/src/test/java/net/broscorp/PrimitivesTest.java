package net.broscorp;

import static org.junit.jupiter.api.Assertions.assertNotEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.Test;

public class PrimitivesTest {

  @Test
  public void shouldBeNegative() {
    int maxIntValue = Integer.MAX_VALUE;

    int overMax = maxIntValue + 1;

    assertTrue(overMax < 0);
  }

  @Test
  public void longToIntConvertation() {
    long longMaxValue = Long.MAX_VALUE;

    int longToInt = (int) longMaxValue;

    assertNotEquals(longMaxValue, longToInt);
  }

  @Test
  public void floatToDoubleConvertation() {
    float someFloat = 158.168f;

    double floatToDouble = someFloat;

    assertNotEquals(158.168, floatToDouble);
  }

  @Test
  public void errorsWhileWorkingWithFloats() {
    float someFloat = 2.5f + 2.7f;

    assertNotEquals(5.2, someFloat);
  }
}
