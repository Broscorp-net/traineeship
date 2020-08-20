package net.broscorp.primitives;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;

import org.junit.jupiter.api.Test;

public class PrimitivesTest {

  @Test
  public void byteOverflow() {
    byte maxByte = Byte.MAX_VALUE;
    byte minByte = Byte.MIN_VALUE;
    assertEquals(++maxByte, minByte);
  }

  @Test
  public void intOverflow() {
    int maxInteger = Integer.MAX_VALUE;
    int minInteger = Integer.MIN_VALUE;
    assertEquals(++maxInteger, minInteger);
  }

  @Test
  public void shortOverflow() {
    short maxShort = Short.MAX_VALUE;
    short minShort = Short.MIN_VALUE;
    assertEquals(++maxShort, minShort);
  }

  @Test
  public void longOverflow() {
    long maxLong = Long.MAX_VALUE;
    long minLong = Long.MIN_VALUE;
    assertEquals(++maxLong, minLong);
  }

  @Test
  public void doubleOverflow() {
    double maxDouble = Double.MAX_VALUE;
    double minDouble = Double.MIN_VALUE;
    assertNotEquals(++maxDouble, minDouble);
  }

  @Test
  public void floatOverflow() {
    float maxFloat = Float.MAX_VALUE;
    float minFloat = Float.MIN_VALUE;
    assertNotEquals(++maxFloat, minFloat);
  }

  @Test
  public void longToInt() {
    long maxValueLong = Long.MAX_VALUE;
    int intValue = -1;
    assertEquals(intValue, (int) maxValueLong);
  }

  @Test
  public void floatToDouble() {
    float floatValue = 7.77f;
    double doubleValue = 7.769997898765432771;
    assertNotEquals(doubleValue, floatValue);
  }

  @Test
  public void floatingPointError() {
    double doubleNumber = 7.4 + 0.3;
    double doubleExpected = 7.7;
    assertNotEquals(doubleExpected, doubleNumber);
  }

}
