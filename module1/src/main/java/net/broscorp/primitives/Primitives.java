package net.broscorp.primitives;

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
  public static int convertLongToIntMax() {
    long l = Long.MAX_VALUE;
    int i = (int) l;
    return i;
  }
  public static int convertLongToIntMin() {
    long l = Long.MIN_VALUE;
    int i = (int) l;
    return i;
  }
  public static int convertLongToIntSome() {
    long l = 2147483648l;
    int i = (int) l;
    return i;
  }
  public static double convertFloatToDouble() {
    float f = Float.MAX_VALUE;
    double d = f;
    return d;
  }
  public static double convertFloatToDoubleSome() {
    float f = (float) 0.35;
    double d = f;
    return d;
  }
}
