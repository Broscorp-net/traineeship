package net.broscorp.primitives;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class PrimitivesTests {

  private Conversion conversion;
  private FloatingPoint floatingPoint;
  private Owerflow owerflow;

  @BeforeEach
  void init() {
    conversion = new Conversion();
    owerflow = new Owerflow();
    floatingPoint = new FloatingPoint();
  }

  @Test
  void shouldConvertLongToInt() {
    assertEquals(34299, conversion.longToInt(34299L));
  }

  @Test
  void shouldConvertLongToIntIfLongVeryBig() {
    assertEquals(124048589, conversion.longToInt(34299732874445L));
  }

  @Test
  void shouldCcnvertDoubleToFloat() {
    assertEquals(345.90f, conversion.doubleToFloat(345.90d));
  }

  @Test
  void shouldConvertDoubleToFloatIfDoubleBig() {
    assertEquals(345.90787f, conversion.doubleToFloat(345.90787463654347835734345d));
  }

  @Test
  public void maxIntegerOwerflowTest() {
    assertEquals(-2147483648, owerflow.maxIntOwerflow(1));
  }

  @Test
  public void maxLongOwerflowTest() {
    assertEquals(-9223372036854775808L, owerflow.maxLongOwerflow(1));
  }

  @Test
  public void maxByteOwerflowTest() {
    assertEquals(-128, owerflow.maxByteOwerflow(1));
  }

  @Test
  public void maxShortOwerflowTest() {
    assertEquals(-32768, owerflow.maxShortOwerflow(1));
  }

  @Test
  void errorWhenMultipleTest() {
    assertNotEquals(3.999, floatingPoint.errorWhenMultiple(1.333, 3));
  }

  @Test
  void shouldReturnDoubleInMultipleTest() {
    assertEquals(3.9989999999999997, floatingPoint.errorWhenMultiple(1.333, 3));
  }
}