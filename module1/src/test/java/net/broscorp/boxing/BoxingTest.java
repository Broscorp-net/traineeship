package net.broscorp.boxing;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.Test;

class BoxingTest {
  @Test
  void variablesShouldBeEqual() {
    Integer i = 127;
    Integer i1 = 127;
    assertTrue(i == i1);
  }

  @Test
  void variablesShouldBeNotEqual() {
    Integer i1 = 128;
    Integer i2 = 128;
    assertFalse(i1 == i2);
  }

  @Test
  void unboxingShouldThrowNullPointerException() {
    Integer i1 = null;
    assertThrows(NullPointerException.class, () -> {
      int b = i1;
    }, "unboxing for null");
  }
}
