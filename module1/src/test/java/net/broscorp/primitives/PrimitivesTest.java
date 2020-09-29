package net.broscorp.primitives;

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
  public void shouldBeNegativeShortVersion() {
    short maxShortValue = Short.MAX_VALUE;
    short overMax = (short) (maxShortValue + 1);

    assertTrue(overMax < 0);
  }

  @Test
  public void longToIntConversion() {
    long longMaxValue = Long.MAX_VALUE;

    int longToInt = (int) longMaxValue;

    assertNotEquals(longMaxValue, longToInt);
  }

  @Test
  public void longToShortConversion() {
    long longMaxValue = Long.MAX_VALUE;

    short longToShort = (short) longMaxValue;

    assertNotEquals(longMaxValue, longToShort);
  }

  @Test
  public void floatToDoubleConversion() {
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
