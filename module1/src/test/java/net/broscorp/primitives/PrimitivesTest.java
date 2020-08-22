package net.broscorp.primitives;

import java.math.BigDecimal;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class PrimitivesTest {

  @Test
  public void testByteMaxValueOverflow() {
    byte b = Byte.MAX_VALUE;
    b++;

    Assertions.assertEquals(-128, b);
  }

  @Test
  public void testByteMinValueOverflow() {
    byte b = Byte.MIN_VALUE;
    b--;

    Assertions.assertEquals(127, b);
  }

  @Test
  public void testShortMaxValueOverflow() {
    short s = Short.MAX_VALUE;
    s++;

    Assertions.assertEquals(-32_768, s);
  }

  @Test
  public void testShortMinValueOverflow() {
    short s = Short.MIN_VALUE;
    s--;

    Assertions.assertEquals(32_767, s);
  }

  @Test
  public void testIntMaxValueOverflow() {
    int i = Integer.MAX_VALUE;
    i++;

    Assertions.assertEquals(-2_147_483_648, i);
  }

  @Test
  public void testIntMinValueOverflow() {
    int i = Integer.MIN_VALUE;
    i--;

    Assertions.assertEquals(2_147_483_647, i);
  }

  @Test
  public void testLongMaxValueOverflow() {
    long l = Long.MAX_VALUE;
    l++;

    Assertions.assertEquals(-9_223_372_036_854_775_808L, l);
  }

  @Test
  public void testLongMinValueOverflow() {
    long l = Long.MIN_VALUE;
    l--;

    Assertions.assertEquals(9_223_372_036_854_775_807L, l);
  }

  @Test
  public void testFloatMaxValueOverflow() {
    float f = Float.MAX_VALUE;
    f++;

    Assertions.assertEquals(3.4028234663852886E38, f);
  }

  @Test
  public void testFloatMinValueOverflow() {
    float f = Float.MIN_VALUE;
    f--;

    Assertions.assertEquals(-1.0, f);
  }

  @Test
  public void testConvertLongToIntExplicitCasting() {
    long bigNum = 100_000_000_000_000L;
    int n = (int) bigNum; // 276447232

    // casting may truncate the value
    Assertions.assertEquals(276_447_232, n);
  }

  @Test
  public void testConvertIntToLongImplicitCasting() {
    int num = 10;
    long bigNum = num;

    Assertions.assertEquals(10L, bigNum);
  }

  @Test
  public void testConvertFloatToDoubleImplicitCasting() {
    float f = 0.1F;
    double d = f;

    Assertions.assertEquals(0.10000000149011612, d);
  }

  @Test
  public void testConvertFloatToDouble() {
    Float f = 0.1F;
    double d = f.doubleValue();

    Assertions.assertEquals(0.10000000149011612, d);
  }

  @Test
  public void testConvertFloatToDoubleViaBigDecimal() {
    float f = 0.1F;
    double d = new BigDecimal(String.valueOf(f)).doubleValue();

    Assertions.assertEquals(0.1, d);
  }

  @Test
  public void testConvertFloatToIntExplicitCasting() {
    float f = 3.8644F;
    int i = (int) f;

    // it loses the fractional part
    Assertions.assertEquals(3, i);
  }

  @Test
  public void testConvertFloatToLongExplicitCasting() {
    float f = 3.8644F;
    long l = (long) f;

    // it loses the fractional part
    Assertions.assertEquals(3L, l);
  }

  @Test
  public void testConvertDoubleToIntExplicitCasting() {
    double d = 3.0864;
    int i = (int) d;

    // it loses the fractional part
    Assertions.assertEquals(3, i);
  }

  @Test
  public void testConvertDoubleToLongExplicitCasting() {
    double d = 3.0864;
    long l = (long) d;

    // it loses the fractional part
    Assertions.assertEquals(3L, l);
  }

  @Test
  public void testComparingDoubles() {
    double d = 0.0;
    for (int i = 0; i < 10; i++) {
      d += 0.1;
    }

    Assertions.assertNotEquals(1.0, d);
    Assertions.assertEquals(0.9999999999999999, d);
  }

  @Test
  public void testComparingDoubleWithThreshold() {
    double threshold = 0.0001;

    double d = 0.0;
    for (int i = 0; i < 10; i++) {
      d += 0.1;
    }

    Assertions.assertTrue(Math.abs(1 - d) < threshold);
  }

  @Test
  public void testComparingFloats() {
    float f1 = 0.3f;
    float f2 = 0.4f;
    float expectedResult = 0.7f;

    float actualResult = f1 + f2;

    Assertions.assertNotEquals(expectedResult, actualResult);
  }
}
