package net.broscorp;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;


class BoxingTest {
  @Test
  void compareForTrueTest() {
    Integer a = 100;
    Integer b = 100;
    Assertions.assertTrue(a == b);
  }

  @Test
  void compareForFalseOneTest() {
    Integer a = 200;
    Integer b = 200;
    Assertions.assertFalse(a == b);
  }

  @Test
  void compareForFalseTwoTest() {
    Integer a = new Integer(100);
    Integer b = new Integer(100);
    Assertions.assertFalse(a == b);
  }

  @Test
  void unboxingExceptionTest() {
    Integer a = null;
    try {
      int b = a;
      Assertions.fail("Exception fail");
    } catch (NullPointerException ex) {
      Assertions.assertTrue(1 == 1);
    }
  }
}