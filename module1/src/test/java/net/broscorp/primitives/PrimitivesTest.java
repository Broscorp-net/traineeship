package net.broscorp.primitives;

import static org.junit.jupiter.api.Assertions.assertNotEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class PrimitivesTest {

  @Test
  public void shouldBeNegative() {
    int maxInteger = Integer.MAX_VALUE;
    int overMax = maxInteger + 1;

    assertTrue(overMax < 0);
  }

  @Test
  public void shouldBeNegativeShortVersion() {
    short maxShort = Short.MAX_VALUE;
    short overMax = (short) (maxShort + 1);

    assertTrue(overMax < 0);
  }

  @Test
  public void longToIntConversion() {
    long maxLong = Long.MAX_VALUE;

    int longToInt = (int) maxLong;

    assertNotEquals(maxLong, longToInt);
  }

  @Test
  public void longToShortConversion() {
    long maxLong = Long.MAX_VALUE;

    short longToShort = (short) maxLong;

    assertNotEquals(maxLong, longToShort);
  }

  @Test
  public void floatToDoubleConversion() {
    float someFloat = 158.168f;

    double floatToDouble = someFloat;

    assertNotEquals(158.168, floatToDouble);
  }

  @Test
  public void doubleToFloatConversion() {
    double someDouble = 158.168;

    float doubleToFloat = (float) someDouble;

    assertNotEquals(158.168, doubleToFloat);
  }

  @Test
  public void errorsWhileWorkingWithFloats(){
    float someFloat = 2.5f + 3.2f;
    Assertions.assertFalse(someFloat == 5.7);
  }
}
