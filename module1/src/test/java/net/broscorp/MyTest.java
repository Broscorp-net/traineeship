package net.broscorp;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

class MyTest {

  @Test
  void numericOverflow() {
    int maxInteger = Integer.MAX_VALUE;
    int biggerThanMaxValue = maxInteger + 1000;
    Assertions.assertTrue(maxInteger > biggerThanMaxValue);
  }

  @Test
  void convertLongToInt() {
    long num1 = 1000L;
    int num2 = (int) num1;
    Assertions.assertEquals(num1, num2);
  }

  @Test
  void convertFloatToDouble() {
    float num1 = 10.2323f;
    double num2 = num1;
    Assertions.assertEquals(num1, num2);
  }

  @Test
  void errorWithFloatAndDouble() {
    float num1 = 2.0f - 1.1f;
    double num2 = 2.0 - 1.1;
    Assertions.assertNotEquals(num1, num2);
  }
}