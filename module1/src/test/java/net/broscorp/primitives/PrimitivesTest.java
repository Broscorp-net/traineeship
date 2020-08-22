package net.broscorp.primitives;


import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class PrimitivesTest {

  @Test
  public void intOverflow() {
    int maxIntOverflowResult, minIntOverflowResult;

    maxIntOverflowResult = Integer.MAX_VALUE + 1;
    minIntOverflowResult = Integer.MIN_VALUE - 1;

    assertEquals(Integer.MIN_VALUE, maxIntOverflowResult);
    assertEquals(Integer.MAX_VALUE, minIntOverflowResult);
  }

  @Test
  public void shortOverflow() {
    short maxShortOverflowResult, minShortOverflowResult;

    maxShortOverflowResult = (short)(Short.MAX_VALUE + 1);
    minShortOverflowResult = (short)(Short.MIN_VALUE - 1);

    assertEquals(Short.MIN_VALUE, maxShortOverflowResult);
    assertEquals(Short.MAX_VALUE, minShortOverflowResult);
  }

  @Test
  public void longOverflow() {
    long maxLongOverflowResult, minLongOverflowResult;

    maxLongOverflowResult = Long.MAX_VALUE + 1;
    minLongOverflowResult = Long.MIN_VALUE - 1;

    assertEquals(Long.MIN_VALUE, maxLongOverflowResult);
    assertEquals(Long.MAX_VALUE, minLongOverflowResult);
  }

  @Test
  public void byteOverflow() {
    byte maxByteOverflowResult, minByteOverflowResult;

    maxByteOverflowResult = (byte)(Byte.MAX_VALUE + 1);
    minByteOverflowResult = (byte)(Byte.MIN_VALUE - 1);

    assertEquals(Byte.MIN_VALUE, maxByteOverflowResult);
    assertEquals(Byte.MAX_VALUE, minByteOverflowResult);
  }

}