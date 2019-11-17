package net.broscorp.e_primitives;

public class ConvertPrimitives {

  public static int getLongToInt(long value) {
    if (value < Integer.MIN_VALUE || value > Integer.MAX_VALUE) {
      throw new ArithmeticException();
    }
    return (int) value;
  }
}
