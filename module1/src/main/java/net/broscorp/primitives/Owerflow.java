package java.net.broscorp.primitives;

public class Owerflow {

  public int maxIntOwerflow(int definition) {
    return Integer.MAX_VALUE + definition;
  }

  public long maxLongOwerflow(int definition) {
    return Long.MAX_VALUE + definition;
  }

  public byte maxByteOwerflow(int definition) {
    return (byte) (Byte.MAX_VALUE + definition);
  }

  public short maxShortOwerflow(int definition) {
    return (short) (Short.MAX_VALUE + definition);
  }

}
