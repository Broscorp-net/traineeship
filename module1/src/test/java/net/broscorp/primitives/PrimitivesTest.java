package net.broscorp.primitives;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class PrimitivesTest {
  @Test
  void intMaxOverflow() {
    int max = Integer.MAX_VALUE;
    Assertions.assertFalse(max < max + 1);
  }

  @Test
  void longToIntOverflow() {
    int max = Integer.MAX_VALUE;
    long convertLong = (long)max * 2;
    int convertInt = (int)convertLong;
    Assertions.assertNotEquals(convertLong, convertInt);
  }

  @Test
  void doubleToFloatOverflow() {
    float max = Float.MAX_VALUE;
    double convertDouble = (double)max * 2;
    float convertFloat = (float)convertDouble;
    Assertions.assertNotEquals(convertDouble, convertFloat);
  }

  @Test
  void floatAccuracyError() {
    float oneToSeven = 0.142857f;
    Assertions.assertNotEquals(oneToSeven * 7, 0.999999);
  }
}
