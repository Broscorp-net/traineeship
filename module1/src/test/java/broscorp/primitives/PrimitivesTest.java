package broscorp.primitives;

import static org.junit.jupiter.api.Assertions.assertNotEquals;

import org.junit.jupiter.api.Test;


public class PrimitivesTest {

  @Test
  public void overflowExample() {
    short number1 = (short) (Short.MAX_VALUE + 1);
    int number2 = Short.MAX_VALUE + 1;
    assertNotEquals(number1, number2);
  }

  @Test
  public void convertLongToInt() {
    long number1 = 123456789101112L;
    int number2 = (int) number1;
    assertNotEquals(0, number2 - number1);
  }

  @Test
  public void convertFloatToDouble() {
    float  number1 = 1.00000009999999999f;
    double number2 = 1.00000009999999999;
    assertNotEquals((double) number1, number2) ;
  }

  @Test
  public void floatNumbersAccuracy() {
    double number = 0.0;
    for (int i = 1; i <= 1_000; i++) {
      number += 0.1111111111111111;
    }
    assertNotEquals(111.11111111111111, number, 0);
  }
}
