package net.broscorp.primitives;


import static junit.framework.TestCase.assertEquals;

import org.junit.Test;

public class Primitives {
  public static int plusIntOverflow() {
    int i = Integer.MAX_VALUE + 1;
    return i;
  }

  public static int minusIntOverflow() {
    int i = Integer.MIN_VALUE - 1;
    return i;
  }

  public static long plusLongOverflow() {
    long i = Long.MAX_VALUE + 1;
    return i;
  }

  public static long minusLongOverflow() {
    long i = Long.MIN_VALUE - 1;
    return i;
  }

  public static short plusShortOverflow() {
    short i = (short) (Short.MAX_VALUE + 1);
    return i;
  }

  public static short minusShortOverflow() {
    short i = (short) (Short.MIN_VALUE - 1);
    return i;
  }

  /**
   * Some javadoc. // OK
   *
   * @author Some javadoc. // OK
   * @since Some javadoc. // OK
   * @serialData // OK
   * @deprecated Some javadoc. // OK
   */
  public static int convertLongToIntMax() {
    long l = Long.MAX_VALUE;
    int i = (int) l;
    return i;
  }

  /**
   * Some javadoc. // OK
   *
   * @author Some javadoc. // OK
   * @since Some javadoc. // OK
   * @serialData // OK
   * @deprecated Some javadoc. // OK
   */
  public static int convertLongToIntMin() {
    long l = Long.MIN_VALUE;
    int i = (int) l;
    return i;
  }

  /**
   * Some javadoc. // OK
   *
   * @author Some javadoc. // OK
   * @since Some javadoc. // OK
   * @serialData // OK
   * @deprecated Some javadoc. // OK
   */
  public static int convertLongToIntSome() {
    long l = 2147483648L;
    int i = (int) l;
    return i;
  }

  /**
   * Some javadoc. // OK
   *
   * @author Some javadoc. // OK
   * @since Some javadoc. // OK
   * @serialData // OK
   * @deprecated Some javadoc. // OK
   */
  public static double convertFloatToDouble() {
    float f = Float.MAX_VALUE;
    double d = f;
    return d;
  }

  /**
   * Some javadoc. // OK
   *
   * @author Some javadoc. // OK
   * @since Some javadoc. // OK
   * @serialData // OK
   * @deprecated Some javadoc. // OK
   */
  public static double convertFloatToDoubleSome() {
    float f1 = (float) 0.35;
    double d = f1;
    return d;
  }

  @Test
  public void testPlusIntOverflow() {
    assertEquals(Integer.MIN_VALUE, Primitives.plusIntOverflow());
  }

  @Test
  public void testMinusIntOverflow() {
    assertEquals(Integer.MAX_VALUE, Primitives.minusIntOverflow());
  }

  @Test
  public void testPlusLongOverflow() {
    assertEquals(Long.MIN_VALUE, Primitives.plusLongOverflow());
  }

  @Test
  public void testMinusLongOverflow() {
    assertEquals(Long.MAX_VALUE, Primitives.minusLongOverflow());
  }

  @Test
  public void testPlusShortOverflow() {
    assertEquals(Short.MIN_VALUE, Primitives.plusShortOverflow());
  }

  @Test
  public void testMinusShortOverflow() {
    assertEquals(Short.MAX_VALUE, Primitives.minusShortOverflow());
  }

  @Test
  public void testConvertLongToIntMax() {
    assertEquals(-1, Primitives.convertLongToIntMax());
  }

  @Test
  public void testConvertLongToIntMin() {
    assertEquals(0, Primitives.convertLongToIntMin());
  }

  @Test
  public void testConvertLongToIntSome() {
    assertEquals(-2147483648, Primitives.convertLongToIntSome());
  }

  @Test
  public void testConvertFloatToDouble() {
    assertEquals(3.4028234663852886E38, Primitives.convertFloatToDouble());
  }

  @Test
  public void testConvertFloatToDoubleSome() {
    assertEquals(0.3499999940395355, Primitives.convertFloatToDoubleSome());
  }
}
