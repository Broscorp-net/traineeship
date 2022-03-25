package net.broscorp.primitives;

public interface PrimitiveInterface {
  long overflowLong();

  byte overflowByte();

  int overflowInt();

  int conversionToInt(long value);

  float conversionToFloat(double value);

  float floatErrors();

  double doubleErrors();

}
