package net.broscorp.primitives;

import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class PrimitiveTest {


  public int longToint(long number) {
    int intNumber = (int) number;
    return intNumber;
  }

  private float doubleTofloat(double doubleNumber) {
    float floatNumber = (float) doubleNumber;
    return floatNumber;
  }

  @Test
  void longShouldNotEqual() {
    long expected = -138410483103284314L;
    int actual = longToint(expected);
    assertNotEquals(expected, actual);
  }

  @Test
  void longShouldEqual() {
    long expected = 1384104831;
    int actual = longToint(expected);
    assertEquals(expected, actual);
  }

  @Test
  void doubleShouldNotEqual() {
    double expected = -138410483103284314d;
    float actual = doubleTofloat(expected);
    assertNotEquals(expected, actual);
  }

  @Test
  void doubleShouldEqual() {
    double expected = 138410.64f;
    float actual = doubleTofloat(expected);
    System.out.println(expected);
    System.out.println(actual);
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
