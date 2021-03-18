package net.broscorp.boxing;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.Test;


public class BoxingTest {
  @Test
  void resultTrue() {
    Integer x1 = -128;
    Integer x2 = -128;
    assertTrue(x1 == x2);
  }

  @Test
  void resultFalse() {
    Integer x1 = 128;
    Integer x2 = 128;
    assertFalse(x1 == x2);
  }

  @Test
  void throwException() {
    Integer x = null;
    assertThrows(NullPointerException.class, () -> {
      int y = x;
    });
  }
}
