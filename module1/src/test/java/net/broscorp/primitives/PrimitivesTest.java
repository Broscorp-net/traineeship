package net.broscorp.primitives;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;

import org.junit.jupiter.api.Test;

public class PrimitivesTest {

  @Test
  public void checkOverflowNumericalType() {
    int maxValue = Integer.MAX_VALUE;
    int resultOverflow = maxValue + 1;
    assertEquals(Integer.MIN_VALUE, resultOverflow);
  }

  @Test
  public void convertPrimitiveTypeLongToIntSmallValue() {
    long largeType = 100;
    int smallType = (int) largeType;
    assertEquals(largeType, smallType);
  }

  @Test
  public void convertPrimitiveTypeLongToIntLargeValue() {
    long largeType = 2_147_483_648L;
    int smallType = (int) largeType;
    assertNotEquals(largeType, smallType);
  }

  @Test
  public void convertPrimitiveTypeDoubleToFloatSmallValue() {
    double largeType = 10.0;
    float smallType = (float) largeType;
    assertEquals(largeType, smallType);
  }

  @Test
  public void convertPrimitiveTypeDoubleToFloatLargeValue() {
    double largeType = 340_282_300_000_000_000_000_000_000_000_000_000_001D;
    float smallType = (float) largeType;
    assertNotEquals(largeType, smallType);
  }

  @Test
  public void errorWithDoubleType() {
    double number = 0.1 + 0.1 + 0.1 + 0.1 + 0.1 + 0.1 + 0.1 + 0.1 + 0.1 + 0.1;
    //number = 0.9999999999999999;
    assertNotEquals(1.0, number);
  }

  @Test
  public void errorWithFloatType() {
    float number = 0.1f + 0.1f + 0.1f + 0.1f + 0.1f + 0.1f + 0.1f + 0.1f + 0.1f + 0.1f;
    //number = 1.0000001f;
    assertNotEquals(1.0, number);
  }

}
