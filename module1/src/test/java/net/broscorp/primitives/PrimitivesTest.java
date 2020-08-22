package net.broscorp.primitives;


import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertNotEquals;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class PrimitivesTest {

  @Test
  public void intOverflow() {
    int maxIntOverflowResult, minIntOverflowResult;

    maxIntOverflowResult = Integer.MAX_VALUE + 1;
    minIntOverflowResult = Integer.MIN_VALUE - 1;

    assertEquals(Integer.MIN_VALUE, maxIntOverflowResult);
    assertEquals(Integer.MAX_VALUE, minIntOverflowResult);
  }

  @Test
  public void shortOverflow() {
    short maxShortOverflowResult, minShortOverflowResult;

    maxShortOverflowResult = (short)(Short.MAX_VALUE + 1);
    minShortOverflowResult = (short)(Short.MIN_VALUE - 1);

    assertEquals(Short.MIN_VALUE, maxShortOverflowResult);
    assertEquals(Short.MAX_VALUE, minShortOverflowResult);
  }

  @Test
  public void longOverflow() {
    long maxLongOverflowResult, minLongOverflowResult;

    maxLongOverflowResult = Long.MAX_VALUE + 1;
    minLongOverflowResult = Long.MIN_VALUE - 1;

    assertEquals(Long.MIN_VALUE, maxLongOverflowResult);
    assertEquals(Long.MAX_VALUE, minLongOverflowResult);
  }

  @Test
  public void byteOverflow() {
    byte maxByteOverflowResult, minByteOverflowResult;

    maxByteOverflowResult = (byte)(Byte.MAX_VALUE + 1);
    minByteOverflowResult = (byte)(Byte.MIN_VALUE - 1);

    assertEquals(Byte.MIN_VALUE, maxByteOverflowResult);
    assertEquals(Byte.MAX_VALUE, minByteOverflowResult);
  }

  @Test
  public void longToIntConversion() {
    long numLong = 100;
    int numInt;

    numInt = (int)numLong;

    assertEquals(100, numLong);
    assertEquals(100, numInt);
    assertEquals(numLong, numInt);
  }

  @Test
  public void longToIntConversionWithOverflow() {
    int numInt;
    long numLong = (long)Integer.MAX_VALUE + 1;

    numInt = (int)numLong;

    assertNotEquals(numInt, numLong);
    assertNotEquals(Integer.MIN_VALUE, numLong);
    assertEquals(Integer.MIN_VALUE, numInt);
  }

  @Test
  public void floatToDoubleConversion() {
    double numD;
    float numF = 0.1234567f;

    numD = numF;

    assertEquals(numF, numD);
  }

  @Test
  public void floatToDoubleConversionPrecisionError() {
    double numD;
    float numF = 3.2f;

    numD = numF;

    assertEquals(3.2f, numD);
    assertNotEquals(3.2d, numD);
  }

  @Test
  public void precisionErrorsDuringOperationsOverFloats() {
    float addResult, subResult, divResult, mulResult;

    addResult = 0.1f + 3.53f;
    subResult = 3.84f - 1.2f;
    divResult = 3.6f / 1.2f;
    mulResult = 5.6f * 2.1f;

    assertNotEquals(3.63f, addResult);
    assertNotEquals(2.64f, subResult);
    assertNotEquals(3f, divResult);
    assertNotEquals(11.76f, mulResult);
  }

  @Test
  public void precisionErrorsDuringOperationsOverDoubles() {
    double addResult, subResult, divResult, mulResult;

    addResult = 0.11d + 3.53d;
    subResult = 3.84d - 1.2d;
    divResult = 3.55d / 0.05d;
    mulResult = 5.65d * 2.1d;

    assertNotEquals(3.64d, addResult);
    assertNotEquals(2.64d, subResult);
    assertNotEquals(71d, divResult);
    assertNotEquals(11.865d, mulResult);
  }

}