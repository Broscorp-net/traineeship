package net.broscorp.boxing;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.Test;

class BoxingTest {

  @Test
  public void shouldBeTrueWhenComparingIntegerInRangeFromMinus128To127() {
    Integer foo = 127;
    Integer bar = 127;
    assertTrue(foo == bar);
  }

  @Test
  public void shouldBeFalseWhenComparingIntegerOutOfRangeFromMinus128To127() {
    Integer foo = 128;
    Integer bar = 128;
    assertFalse(foo == bar);
  }

  @Test
  public void shouldBeFalseWhenComparingIntegersCreatedAsNewObjects() {
    Integer foo = 10;
    Integer bar = new Integer(10);
    assertFalse(foo == bar);
  }

  @Test
  public void shouldThrowWhenUnboxingNull() {
    assertThrows(NullPointerException.class, () -> {
      Integer foo = null;
      int bar = foo;
    });
  }

}