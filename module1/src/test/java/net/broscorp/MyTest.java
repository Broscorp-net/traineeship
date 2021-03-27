package net.broscorp;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

class MyTest {

  @Test
  void compareNumbersShouldBeTrue() {
    Integer integer1 = 10;
    Integer integer2 = 10;
    Assertions.assertTrue(integer1 == integer2);
  }

  @Test
  void compareNumbersShouldBeFalse() {
    Integer integer1 = new Integer(10);
    Integer integer2 = new Integer(10);
    Assertions.assertFalse(integer1 == integer2);
  }

  @Test
  void implicitConversionThrowError() {
    Assertions.assertThrows(NullPointerException.class, () -> {
      Integer integer = null;
      int primitive = integer;
    });
  }
}