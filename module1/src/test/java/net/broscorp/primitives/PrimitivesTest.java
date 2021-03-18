package net.broscorp.primitives;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class PrimitivesTest {

  @Test
  public void byteOverflow() {
    byte firstByte = Byte.MAX_VALUE;
    byte secondByte = (byte) (firstByte + 1);
    Assertions.assertTrue(firstByte > secondByte);
  }

  @Test
  public void shortOverflow() {
    short firstShort = Short.MAX_VALUE;
    short secondShort = (short) (firstShort + 1);
    Assertions.assertTrue(firstShort > secondShort);
  }

  @Test
  public void integerOverflow() {
    int firstInt = Integer.MAX_VALUE;
    int secondInt = firstInt + 1;
    Assertions.assertTrue(firstInt > secondInt);
  }
  
  @Test
  public void longOverflow() {
    long firstLong = Long.MAX_VALUE;
    long secondLong = (firstLong + 1L);
    Assertions.assertTrue(firstLong > secondLong);
  }

  @Test
  public void convertLongToInt() {
    long numberLong = 999L;
    int numberInt = (int) numberLong;
    Assertions.assertEquals(numberLong, numberInt);
  }

  @Test
  public void convertFloatToDouble() {
    float floatNum = 98.9f;
    double doubleNum = floatNum;
    Assertions.assertEquals(floatNum, doubleNum);
  }

  @Test
  public void errorInFlotAndDouble() {
    float floatNum = (float) 245/22;
    double doubleNum = (double) 245/22;
    Assertions.assertNotEquals(floatNum, doubleNum);
  }



}
