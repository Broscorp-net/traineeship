package net.broscorp.primitives;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;


public class PrimitivesTest {

  @Test
  public void overflowExample() {
    short number1 = (short) (Short.MAX_VALUE + 1);
    int number2 = Short.MAX_VALUE + 1;
    assertEquals(number1, number2);
  }

  @Test
  public void convertLongToInt() {
    long number1 = 123456789101112L;
    int number2 = (int) number1;
    assertEquals(0, number2 - number1);
  }

  @Test
  public void convertFloatToDouble() {
    float number1 = 123.123456789f;
    double number2 = number1;
    assertEquals(String.valueOf(number1), String.valueOf(number2));
  }

  @Test
  public void floatNumbersAccuracy() {
    double number = 0.0;
    for (int i = 1; i <= 1_000; i++) {
      number += 0.1111111111111111;
    }
    assertEquals(111.11111111111111, number, 0);
  }
}
