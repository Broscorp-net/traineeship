package net.broscorp.boxing;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;


public class BoxingTest {

  @Test
  void resastrue() {
    Integer b1 = 10;
    Integer b2 = 10;
    assertTrue(b1 == b2);//интернированый дипазон от -128 до 127
  }

  @Test
  void resasfalse() {
    Integer b1 = 1000;
    Integer b2 = 1000;
    assertFalse(b1 == b2);
  }

  @Test
  void exunbox() {
    Integer u = null;
    Boxing someunbox = new Boxing();
    Assertions.assertThrows(NullPointerException.class, () -> {
      someunbox.somemet(u);
    });
  }
}
