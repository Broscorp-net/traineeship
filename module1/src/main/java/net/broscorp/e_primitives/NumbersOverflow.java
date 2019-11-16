public class NumbersOverflow {

  public static void main(String[] args) {

  }

  public byte ByteOverflow() {
    byte byteTest = Byte.MAX_VALUE;
    byte result = ++byteTest;
    System.out.println("Byte Overflow: " + Byte.MAX_VALUE + " + 1 = " + result);
    return result;
  }

  public short ShortOverflow() {
    short shortTest = Short.MAX_VALUE;
    short result = ++shortTest;
    System.out.println("Short Overflow: " + Short.MAX_VALUE + " + 1 = " + result);
    return result;
  }


  public int IntegerOverflow() {
    int intTest = Integer.MAX_VALUE;
    int result = ++intTest;
    System.out.println("Integer Overflow: " + Integer.MAX_VALUE + " + 1 = " + result);
    return result;
  }

  public long LongOverflow() {
    long longTest = Long.MAX_VALUE;
    long result = ++longTest;
    System.out.println("Long Overflow: " + Long.MAX_VALUE + " + 1 = " + result);
    return result;
  }

  public float FloatOverflow() {
    float floatTest = Float.MAX_VALUE;
    float result = ++floatTest;
    System.out.println("Float Overflow: " + Float.MAX_VALUE + " + 1 = " + result);
    return result;
  }

  public double DoubleOverflow() {
    double doubleTest = Double.MAX_VALUE;
    double result = ++doubleTest;
    System.out.println("Double Overflow: " + Double.MAX_VALUE + " + 1 = " + result);
    return result;
  }

  public int PrimitivesConversion() {
    long b = 15;
    int a = (int) b;
    return a;
  }

  public int FloatNumbersConversion() {
    double a = 10.79;
    int b = (int) a;
    return b;
  }

}
