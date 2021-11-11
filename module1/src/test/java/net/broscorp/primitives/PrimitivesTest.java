package net.broscorp.primitives;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.Before;
import org.junit.Test;

public class PrimitivesTest {
  Primitives primitives;

  @Before
  public void setUp() {
    primitives = new Primitives();
  }

  @Test
  public void testPlusIntOverflow() {
    assertEquals(Integer.MIN_VALUE, Primitives.plusIntOverflow());
  }
  @Test
  public void testMinusIntOverflow() {
    assertEquals(Integer.MAX_VALUE, Primitives.minusIntOverflow());
  }
  @Test
  public void testPlusLongOverflow() {
    assertEquals(Long.MIN_VALUE, Primitives.plusLongOverflow());
  }
  @Test
  public void testMinusLongOverflow() {
    assertEquals(Long.MAX_VALUE, Primitives.minusLongOverflow());
  }
  @Test
  public void testPlusShortOverflow() {
    assertEquals(Short.MIN_VALUE, Primitives.plusShortOverflow());
  }
  @Test
  public void testMinusShortOverflow() {
    assertEquals(Short.MAX_VALUE, Primitives.minusShortOverflow());
  }
  @Test
  public void testConvertLongToIntMax() {
    assertEquals(-1, Primitives.convertLongToIntMax());
  }
  @Test
  public void testConvertLongToIntMin() {
    assertEquals(0, Primitives.convertLongToIntMin());
  }
  @Test
  public void testConvertLongToIntSome() {
    assertEquals(-2147483648, Primitives.convertLongToIntSome());
  }
  @Test
  public void testConvertFloatToDouble() {
    assertEquals(Float.MAX_VALUE, Primitives.convertFloatToDouble());
  }
  @Test
  public void testConvertFloatToDoubleSome() {
    assertEquals(0.3499999940395355, Primitives.convertFloatToDoubleSome());
  }
}
