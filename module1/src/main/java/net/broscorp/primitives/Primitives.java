package net.broscorp.primitives;

public class Primitives {

  //числовые типы: byte, short, int, long, float, double
  //protected - доступ на уровне пакета
  protected byte byteOverflow() {
    byte someValue = 1;
    byte result = (byte) (someValue + Byte.MAX_VALUE);
    return result;
  }

  protected short shortOverflow() {
    short someValue = 1;
    short result = (short) (someValue + Short.MAX_VALUE);
    return result;
  }

  protected int integerOverflow() {
    int someValue = 1;
    int result = someValue + Integer.MAX_VALUE;
    return result;
  }

  protected long longOverflow() {
    long someValue = 1;
    long result = someValue + Long.MAX_VALUE;
    return result;
  }

  protected float floatOverflow() {
    float someValue = 1f;
    float result = someValue + Float.MAX_VALUE;
    return result;
  }

  protected double doubleOverflow() {
    double someValue = 1d;
    double result = someValue + Double.MAX_VALUE;
    return result;
  }

  protected int convLongToInt(long l) {
    int result = (int) l;
    return result;
  }

  protected double convFloatToDouble(float f) {
    double result = (double) f;
    return result;
  }

  protected float fsum() {
    float f = 0.0f;
    for (int i = 1; i <= 7; i++) {
      f += 0.1111111111111111;
    }
    return f;
  }
}