package net.broscorp.primitives;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;

import org.junit.jupiter.api.Test;

public class PrimitivesTest {

  @Test
  public void byteTypeOverflow() {
    byte maxValueByte = Byte.MAX_VALUE;
    byte minValueByte = Byte.MIN_VALUE;
    assertEquals(++maxValueByte, minValueByte);
  }

  @Test
  public void shortTypeOverflow() {
    short maxValueShort = Short.MAX_VALUE;
    short minValueShort = Short.MIN_VALUE;
    assertEquals(++maxValueShort, minValueShort);
  }

  @Test
  public void intTypeOverflow() {
    int maxValueInt = Integer.MAX_VALUE;
    int minValueInt = Integer.MIN_VALUE;
    assertEquals(++maxValueInt, minValueInt);
  }

  @Test
  public void longOverflow() {
    long maxValueLong = Long.MAX_VALUE;
    long minValueLong = Long.MIN_VALUE;
    assertEquals(++maxValueLong, minValueLong);
  }

  @Test
  public void doubleOverflow() {
    double maxValueDouble = Double.MAX_VALUE;
    double minValueDouble = Double.MIN_VALUE;
    assertNotEquals(++maxValueDouble, minValueDouble);
  }

  @Test
  public void floatOverflow() {
    float maxFloat = Float.MAX_VALUE;
    float minFloat = Float.MIN_VALUE;
    assertNotEquals(++maxFloat, minFloat);
  }

  @Test
  public void longToInt() {
    long maxValueLong =  Long.MAX_VALUE;
    int justInt = -1;
    assertEquals(justInt, (int) maxValueLong);
  }

  @Test
  public void floatToDouble() {
    float fValue = 0.1F;
    double dValue = fValue;
    assertEquals(fValue, dValue);
  }

  @Test
  public void errorsWithFloatingPoint() {
    double first = 0.7;
    double second = 0.9;
    double resultFromFirst = first + 0.1;
    double resultFromSecond = second - 0.1;
    assertNotEquals(resultFromFirst, resultFromSecond);
  }

}
