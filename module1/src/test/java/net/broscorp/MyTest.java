package net.broscorp;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

class MyTest {

  @Test
  public void testEquality() {
    Integer a = 1;
    Integer b = 1;

    boolean result = (a == b);

    Assertions.assertTrue(result);
  }

  @Test
  public void testInequality() {
    Integer a = 130;
    Integer b = a;
    b = 130;

    boolean result = (a == b);

    Assertions.assertFalse(result);
  }

  @Test
  public void testUnboxing() {
    Integer a = null;

    Assertions.assertThrows(NullPointerException.class, () -> {
      int b = a;
    });
  }
}