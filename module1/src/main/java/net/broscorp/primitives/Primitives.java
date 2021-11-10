package net.broscorp.primitives;
import java.lang.*;

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

}
