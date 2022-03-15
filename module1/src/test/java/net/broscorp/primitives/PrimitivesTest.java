package net.broscorp.primitives;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class PrimitivesTest {
  @Test
  void IntMaxOverflow(){
    int max = Integer.MAX_VALUE;
    Assertions.assertFalse(max<max+1);
  }

  @Test
  void LongToIntOverflow(){
    int max = Integer.MAX_VALUE;
    long convertLong = (long)max*2;
    int convertInt = (int)convertLong;
    Assertions.assertNotEquals(convertLong, convertInt);
  }

  @Test
  void DoubleToFloatOverflow(){
    float max = Float.MAX_VALUE;
    double convertDouble = (double)max*2;
    float convertFloat = (float)convertDouble;
    Assertions.assertNotEquals(convertDouble, convertFloat);
  }

  @Test
  void FloatAccuracyError(){
    float oneToSeven = 0.142857f;
    Assertions.assertNotEquals(oneToSeven*7, 0.999999);
  }
}
