package net.broscorp.primitives;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;

import org.junit.jupiter.api.Test;

class PrimitivesTest {

  @Test
  public void byteOverflowShouldAppear() {
    byte max = Byte.MAX_VALUE;
    byte min = Byte.MIN_VALUE;
    assertEquals(++max, min);
  }

  @Test
  public void shortOverflowShouldAppear() {
    short max = Short.MAX_VALUE;
    short min = Short.MIN_VALUE;
    assertEquals(++max, min);
  }

  @Test
  public void intOverflowShouldAppear() {
    int max = Integer.MAX_VALUE;
    int min = Integer.MIN_VALUE;
    assertEquals(++max, min);
  }

  @Test
  public void longOverflowShouldAppear() {
    long max = Long.MAX_VALUE;
    long min = Long.MIN_VALUE;
    assertEquals(++max, min);
  }

  @Test
  public void floatOverflowShouldAppear() {
    float max = Float.MAX_VALUE;
    float min = Float.MIN_VALUE;
    assertNotEquals(++max, min);
  }

  @Test
  public void doubleOverflowShouldAppear() {
    double max = Double.MAX_VALUE;
    double min = Double.MIN_VALUE;
    assertNotEquals(++max, min);
  }

  @Test
  public void longToIntConversion() {
    long longNumber = 25626455625454L;
    int intNumber = -1614229778;
    assertEquals(intNumber, (int) longNumber);
  }

  @Test
  public void floatToDoubleConversion() {
    float floatNumber = 2.54f;
    double doubleNumber = 2.5399999618530273;
    assertEquals(doubleNumber, (double) floatNumber);
  }

  @Test
  public void workingWithFloatingNumbersFault() {
    double doubleNumber = 0.0;

    for (int i = 0; i < 10; i++) {
      doubleNumber += 0.1;
    }
    double expectedResult = 10;
    assertNotEquals(expectedResult, doubleNumber);
  }
}