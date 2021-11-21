package net.broscorp.primitives;


import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;

import org.junit.jupiter.api.Test;

public class PrimitivesTest {

  @Test
  public void overflowPrimitivesTest() {

    assertEquals(Byte.MIN_VALUE, (byte) (Byte.MAX_VALUE + 1));
    assertNotEquals(Byte.MIN_VALUE, (Byte.MAX_VALUE + 1));

    assertEquals(Short.MIN_VALUE, (short) (Short.MAX_VALUE + 1));
    assertNotEquals(Short.MIN_VALUE, (Short.MAX_VALUE + 1));

    assertEquals(Integer.MIN_VALUE, (Integer.MAX_VALUE + 1));
    assertNotEquals(2_147_483_648L, Integer.MAX_VALUE + 1);

    assertEquals(Long.MIN_VALUE, Long.MAX_VALUE + 1);
  }

  @Test
  public void convertLongShorterThenIntToInt() {
    long longNotOverflowInt = 1_123_342_321L;
    int convertedFromLong = (int) longNotOverflowInt;
    assertEquals(1_123_342_321, convertedFromLong);
  }

  @Test
  public void convertLongGreaterThenIntToInt() {
    long longOverflowInt = 3_000_000_000L;
    int convertedFromLong = (int) longOverflowInt;
    assertNotEquals(3_000_000_000L, convertedFromLong);
    assertEquals(-1294967296, convertedFromLong);

    //loss of higher bits
  }

  @Test
  public void convertFloatToDouble() {
    float f = 2.434234f;
    double d = f;
    assertNotEquals(2.434234, d);
    assertEquals(2.4342339038848877, d);

    //wider precious in double rather than float;
  }

  @Test
  public void errorWhileUsingFloatingPoint() {
    double a = 1.0;
    double x = 0.90;

    a = a - x;

    assertNotEquals(0.1, a);
    assertEquals(0.09999999999999998, a);
  }
}
