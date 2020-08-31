package net.broscorp.primitives;

import org.junit.Assert;
import org.junit.Test;

public class PrimitivesTest {

  @Test
  public void overflowInt() {
    int maxValue = Integer.MAX_VALUE;
    int minValue = Integer.MIN_VALUE;
    Assert.assertEquals(++maxValue, minValue);
  }

  @Test
  public void longToInteger() {
    long maxValueLong = Long.MAX_VALUE;
    int expected = -1;
    Assert.assertEquals(expected,(int)maxValueLong);
  }

  @Test
  public void floatToDouble() {
    float number = 3.143267581489987665f;
    double expectedDoubleNumber = 3.143267581489987665;
    Assert.assertNotEquals(expectedDoubleNumber,number);
  }

  @Test
  public void errorWithFloatingNumber() {
    double number = 0.2 + 0.4;
    double expected = 0.6;
    Assert.assertNotEquals(expected,number);
  }
}
