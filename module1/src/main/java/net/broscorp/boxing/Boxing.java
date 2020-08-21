package net.broscorp.boxing;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.util.List;
import org.junit.jupiter.api.Test;

public class Boxing {

  Integer a = 127;
  Integer b = 127;
  Integer c = 128;
  Integer d = 128;

  @Test
  public void compareTestInCache() {
    assertTrue(a == b);
  }

  @Test
  public void compareTestNotInCache() {
    assertFalse(c == d);
  }

  @Test
  public void equalsTest() {
    assertTrue(a.equals(b));
  }

  @Test
  public void boxingTest() {
    Integer a = new Integer(10);
    int b = Integer.valueOf(10);
    assertTrue(a.equals(b));
  }

  @Test
  public void unboxingTest() {
    assertEquals(127, a);
  }
}
