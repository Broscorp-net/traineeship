package net.broscorp.primitives;

import static org.junit.Assert.assertEquals;

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
    assertEquals(-1, Primitives.changeLongToIntMax());
  }

  @Test
  public void testConvertLongToIntMin() {
    assertEquals(0, Primitives.changeLongToIntMin());
  }

  @Test
  public void testConvertLongToIntSome() {
    assertEquals(-2147483648, Primitives.changeLongToIntSome());
  }

}
