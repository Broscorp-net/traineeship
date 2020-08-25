package net.broscorp.boxing;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import org.junit.Test;

public class TestBoxing {

  @Test
  public void testComparingWrappers() {
    Long x = Long.valueOf("99999");
    Long y = Long.valueOf("99999");

    assertFalse(x == y);
    assertTrue(x.equals(y));
  }

  @Test
  public void testBoxing() {
    int a = 100;
    Integer reference = Integer.valueOf(a); // boxing
    Integer anotherReference = Integer.parseInt("100"); // boxing

    assertEquals(reference, anotherReference);
  }

  @Test
  public void testUnboxing() {
    int a = 100;
    Integer reference = Integer.valueOf(a); // boxing
    int b = reference.intValue();    // unboxing

    assertTrue(a == b);
    assertEquals(a, b);
  }
}
