package net.broscorp.primitives;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.Test;

public class TestPrimitives {

  @Test
  public void numberTypeOverflow() {
    byte number = 127;
    byte expectedResponse = -128;
    assertEquals(expectedResponse, ++number);
  }

  @Test
  public void conversionBetweenPrimitiveTypeLongToIntWithoutProblem() {
    long number = 1147483647L;
    int expectedResponse = 1147483647;
    assertEquals(expectedResponse, (int) number);
  }

  @Test
  public void narrowingDownPrimitiveTypesBetweenLongToIntWithOverflow() {
    long number = 3147483647L;
    int expectedResponse = -1147483649;
    assertEquals(expectedResponse, (int) number);
  }

  @Test
  public void conversionBetweenPrimitiveTypeFloatToDouble() {
    float number = 0.1f;
    double expectedResponse = 0.1;
    assertTrue((Math.abs((double) number) - expectedResponse) < 0.0001);
  }

  @Test
  public void uncertaintyWhenWorkingWithFloatingPointNumbers() {
    float expected = 0.2f;
    assertTrue(Math.abs(expected - 0.2) < 0.0001);
  }
}
