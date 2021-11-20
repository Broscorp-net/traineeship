package net.broscorp.primitives;

import static java.lang.Double.doubleToRawLongBits;

import java.math.BigDecimal;
import java.math.RoundingMode;

public class Primitives {

  public static short minShort() {
    short s = (short) (Short.MAX_VALUE + 1);
    return s;
  }

  public static short maxShort() {
    short s = (short) (Short.MIN_VALUE - 1);
    return s;
  }

  public static int minInt() {
    int i = (Integer) Integer.MAX_VALUE + 1;
    return i;
  }

  public static int maxInt() {
    int i = (Integer) Integer.MIN_VALUE - 1;
    return i;
  }

  public static long minLong() {
    long l = (Long) Long.MAX_VALUE + 1;
    return l;
  }

  public static long maxLong() {
    long l = (Long) Long.MIN_VALUE - 1;
    return l;
  }

  /**
   * long to int conversion method.
   */

  public static int convertLongToInt(long l) {
    int i = 0;
    try {
      i = Math.toIntExact(l);
      System.out.println(i);
    } catch (ArithmeticException e) {
      System.out.println("l value (long) maximum size i value (int)");
    }
    return i;
  }

  public static double convertFloatToDouble(float f) {
    double d = f;
    return d;
  }

  static double errorCalculationFloatAndDouble(double d) {
    float f = (float) d;
    System.out.println(
        String.format("double: %.10f\t%s", d, Long.toBinaryString(doubleToRawLongBits(d))));
    System.out.println(
        String.format("float: %.10f\t  %s", f, Integer.toBinaryString(Float.floatToRawIntBits(f))));
    double res = d - f;
    System.out.println("Погрешность из числа " + d + ", у float составляет " + res);
    return res;
  }

  static double workingWithBigDecimal(double d) {
    String s = Double.toString(d);
    BigDecimal decimal = new BigDecimal(s);
    decimal = decimal.setScale(2, RoundingMode.DOWN);
    return decimal.doubleValue();
  }

}
