package net.broscorp.boxing;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.Assertions;

public class Boxing {
  @Test
  void resultTrue() {
    Integer x1 = -128;
    Integer x2 = -128;
    Assertions.assertTrue(x1 == x2);
  }

  @Test
  void resultFalse() {
    Integer x1 = 128;
    Integer x2 = 128;
    Assertions.assertFalse(x1 == x2);
  }

  @Test
  void throwException() {
    Integer x = null;
    Assertions.assertThrows(NullPointerException.class, () -> {
      int y = x;
    });
  }
}
