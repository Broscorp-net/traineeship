package net.broscorp.boxing;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import org.junit.Test;

public class TestBoxing {

  @Test
  public void testComparingWrappers() {
    Long l1 = Long.valueOf("2000");
    Long l2 = Long.valueOf("2000");

    assertFalse(l1 == l2);
    assertTrue(l1.equals(l2));
  }

  @Test
  public void testBoxing() {
    int primitive = 100;
    Integer reference = Integer.valueOf(primitive); // boxing
    Integer anotherReference = Integer.parseInt("100"); // boxing

    assertEquals(reference, anotherReference);
  }

  @Test
  public void testUnboxing() {
    int primitive = 100;
    Integer reference = Integer.valueOf(primitive); // boxing
    int anotherPrimitive = reference.intValue();    // unboxing

    assertTrue(primitive == anotherPrimitive);
    assertEquals(primitive, anotherPrimitive);
  }
  /*
  @Test()
  public void testUnboxingThrowsNPE() {
    Long longVal = null;

    Assertions.assertThrows(NullPointerException.class, () -> {
      long primitiveLong = longVal;
    });
  }*/
}
