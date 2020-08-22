package net.broscorp.boxing;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class BoxingTest {

  @Test
  public void testComparingWrappers() {
    Long l1 = Long.valueOf("2000");
    Long l2 = Long.valueOf("2000");

    Assertions.assertFalse(l1 == l2);
    Assertions.assertTrue(l1.equals(l2));
  }

  @Test
  public void testBoxing() {
    int primitive = 100;
    Integer reference = Integer.valueOf(primitive); // boxing
    Integer anotherReference = Integer.parseInt("100"); // boxing

    Assertions.assertEquals(reference, anotherReference);
  }

  @Test
  public void testUnboxing() {
    int primitive = 100;
    Integer reference = Integer.valueOf(primitive); // boxing
    int anotherPrimitive = reference.intValue();    // unboxing

    Assertions.assertTrue(primitive == anotherPrimitive);
    Assertions.assertEquals(primitive, anotherPrimitive);
  }

  @Test()
  public void testUnboxingThrowsNPE() {
    Long longVal = null;

    Assertions.assertThrows(NullPointerException.class, () -> {
      long primitiveLong = longVal;
    });
  }
}
