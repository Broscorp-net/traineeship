package net.broscorp.primitives;

import static org.junit.jupiter.api.Assertions.*;

import java.math.BigInteger;
import org.testng.annotations.Test;

public class PrimitivesTest {

  @Test
  public void byteOverFlowMaxValue() {
    int expected = Byte.MAX_VALUE;
    byte actual = Byte.MAX_VALUE;
    expected++;
    actual++;
    assertNotEquals(expected, actual);
  }

  @Test
  public void byteOverFlowMinValue() {
    int expected = Byte.MIN_VALUE;
    byte actual = Byte.MIN_VALUE;
    expected--;
    actual--;
    assertNotEquals(expected, actual);
  }

  @Test
  public void shortOverFlowMaxValue() {
    int expected = Short.MAX_VALUE;
    short actual = Short.MAX_VALUE;
    expected++;
    actual++;
    assertNotEquals(expected, actual);
  }

  @Test
  public void shortOverFlowMixValue() {
    int expected = Short.MIN_VALUE;
    short actual = Short.MIN_VALUE;
    expected--;
    actual--;
    assertNotEquals(expected, actual);
  }

  @Test
  public void intOverFlowMaxValue() {
    long expected = Integer.MAX_VALUE;
    int actual = Integer.MAX_VALUE;
    expected++;
    actual++;
    assertNotEquals(expected, actual);
  }

  @Test
  public void intOverFlowMinValue() {
    long expected = Integer.MIN_VALUE;
    int actual = Integer.MIN_VALUE;
    expected--;
    actual--;
    assertNotEquals(expected, actual);
  }

  @Test
  public void longOverFlowMaxValue() {
    BigInteger expected = BigInteger.valueOf(Long.MAX_VALUE);
    BigInteger addition = new BigInteger("1");
    long actual = Long.MAX_VALUE;
    expected.add(addition);
    actual++;
    assertNotEquals(expected.longValueExact(), actual);
  }

  @Test
  public void longOverFlowMinValue() {
    BigInteger expected = BigInteger.valueOf(Long.MIN_VALUE);
    BigInteger discount = new BigInteger("1");
    long actual = Long.MIN_VALUE;
    expected.subtract(discount);
    actual--;
    assertNotEquals(expected.longValueExact(), actual);
  }

  @Test
  public void convertLongToInt() {
    long expected = Integer.MAX_VALUE;
    expected++;
    int actual = (int) expected;
    assertNotEquals(expected, actual);
  }

  @Test
  public void convertDoubleToFloat() {
    double expected = Double.MIN_VALUE;
    float actual = (float) expected;
    assertNotEquals(expected, actual);
  }

  @Test
  public void notCalculationAccuracy() {
    double expected = 0.9;
    double actual = 2.0 - 1.1;
    assertNotEquals(expected, actual);
  }
}
