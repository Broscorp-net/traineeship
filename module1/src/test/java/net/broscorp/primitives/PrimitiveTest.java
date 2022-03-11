package net.broscorp.primitives;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class PrimitiveTest {

  public int longToInt(long number) {
    int intNumber = (int) number;
    return intNumber;
  }

  private float doubleToFloat(double doubleNumber) {
    float floatNumber = (float) doubleNumber;
    return floatNumber;
  }

  @Test
  void longShouldNotEqual() {
    long expected = -138410483103284314L;
    int actual = longToInt(expected);
    assertNotEquals(expected, actual);
  }

  @Test
  void longShouldEqual() {
    long expected = 1384104831;
    int actual = longToInt(expected);
    assertEquals(expected, actual);
  }

  @Test
  void doubleShouldNotEqual() {
    double expected = -138410483103284314d;
    float actual = doubleToFloat(expected);
    assertNotEquals(expected, actual);
  }

  @Test
  void doubleShouldEqual() {
    double expected = 138410.64f;
    float actual = doubleToFloat(expected);
    assertEquals(expected, actual);
  }

  @Test
  void itShouldBeFloatingError() {
    float number = 0.123f;
    for (int i = 0; i < 5; i++) {
      number = number + 0.01f;
    }
    assertNotEquals(0.173f, number);
  }
}