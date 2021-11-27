package net.broscorp.primitives;


import org.junit.jupiter.api.Assertions;

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

  @org.junit.jupiter.api.Test
  public void testPlusIntOverflow() {
    Assertions.assertEquals(Integer.MIN_VALUE, Primitives.plusIntOverflow());
  }

  @org.junit.jupiter.api.Test
  public void testMinusIntOverflow() {
    Assertions.assertEquals(Integer.MAX_VALUE, Primitives.minusIntOverflow());
  }

  @org.junit.jupiter.api.Test
  public void testPlusLongOverflow() {
    Assertions.assertEquals(Long.MIN_VALUE, Primitives.plusLongOverflow());
  }

  @org.junit.jupiter.api.Test
  public void testMinusLongOverflow() {
    Assertions.assertEquals(Long.MAX_VALUE, Primitives.minusLongOverflow());
  }

  @org.junit.jupiter.api.Test
  public void testPlusShortOverflow() {
    Assertions.assertEquals(Short.MIN_VALUE, Primitives.plusShortOverflow());
  }

  @org.junit.jupiter.api.Test
  public void testMinusShortOverflow() {
    Assertions.assertEquals(Short.MAX_VALUE, Primitives.minusShortOverflow());
  }

  @org.junit.jupiter.api.Test
  public void testConvertLongToIntMax() {
    Assertions.assertEquals(-1, Primitives.convertLongToIntMax());
  }

  @org.junit.jupiter.api.Test
  public void testConvertLongToIntMin() {
    Assertions.assertEquals(0, Primitives.convertLongToIntMin());
  }

  @org.junit.jupiter.api.Test
  public void testConvertLongToIntSome() {
    Assertions.assertEquals(-2147483648, Primitives.convertLongToIntSome());
  }

  @org.junit.jupiter.api.Test
  public void testConvertFloatToDouble() {
    Assertions.assertEquals(3.4028234663852886E38, Primitives.convertFloatToDouble());
  }

  @org.junit.jupiter.api.Test
  public void testConvertFloatToDoubleSome() {
    Assertions.assertEquals(0.3499999940395355, Primitives.convertFloatToDoubleSome());
  }
}
