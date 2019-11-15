package net.broscorp.e_primitives;

public class OverflowPrimitives {

  public static int addForOverflowInt(int a, int b) {
    if (b > 0 ? a > Integer.MAX_VALUE - b
        : a < Integer.MIN_VALUE - b) {
      throw new ArithmeticException("int overflow");
    }
    return a + b;
  }

  public static int addForOverflowByte(int a, int b) {
    if (b > 0 ? a > Byte.MAX_VALUE - b
        : a < Byte.MIN_VALUE - b) {
      throw new ArithmeticException("byte overflow");
    }
    return a + b;
  }

  public static long addForOverflowLong(long a, long b) {
    if (b > 0 ? a > Long.MAX_VALUE - b
        : a < Long.MIN_VALUE - b) {
      throw new ArithmeticException("long overflow");
    }
    return a + b;
  }
}
