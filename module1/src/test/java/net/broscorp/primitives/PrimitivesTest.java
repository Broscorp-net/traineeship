package net.broscorp.primitives;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;

import org.junit.jupiter.api.Test;

public class PrimitivesTest {

  @Test
  public void addToIntMaxValueTest() {
    assertEquals(Integer.MAX_VALUE + 1, Integer.MIN_VALUE);
  }

  @Test
  public void addToLongMaxValueTest() {
    assertEquals(Long.MAX_VALUE + 2, Long.MIN_VALUE + 1);
  }

  @Test
  public void convertLongToIntTest() {
    long l = 10_000;
    int i = (int) l;
    assertEquals(i, 10_000);
  }

  @Test
  public void convertLongToIntWithOverflowTest() {
    long l = Integer.MIN_VALUE - 1;
    int i = (int) l;
    assertEquals(i, Integer.MAX_VALUE);
  }

  @Test
  public void convertFloatToDoubleTest() {
    float f = 9000.55f;
    double d = f;
    assertNotEquals(Float.toString(f), Double.toString(d));
  }

  @Test
  public void floatingPointPrecisionTest() {
    double price = 0.2;
    for (int i = 0; i < 10; i++) {
      price += 0.2;
    }
    assertNotEquals(2.2, price);
  }
}
