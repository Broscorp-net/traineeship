package net.broscorp.primitives;

public class Primitive implements PrimitiveInterface {
  @Override
    public long overflowLong() {
    long returnValue = Long.MAX_VALUE;
    return returnValue + 1;
  }

  @Override
    public byte overflowByte() {
    byte returnValue = Byte.MAX_VALUE;
    return (byte) (returnValue + 1);
  }

  @Override
    public int overflowInt() {
    int returnValue = Integer.MAX_VALUE;
    return returnValue + 1;
  }

  @Override
    public int conversionToInt(long value) {

    return (int) value;
  }

  @Override
    public float conversionToFloat(double value) {

    return (float) value;
  }

  @Override
    public float floatErrors() {
    System.out.println(" Exact result  of (2.0-1.1) = 0.9");
    System.out.print("float result is = " + (2.0 - 1.1f)
        + "\n" + "-------------------------" + "\n");
    return 2.0f - 1.1f;
  }

  @Override
    public double doubleErrors() {
    System.out.println("Exact result of (2.0-1.1) = 0.9");
    System.out.print("double result is = " + (2.0 - 1.1)
        + "\n" + "-------------------------" + "\n");
    return 2.0 - 1.1;
  }
}
