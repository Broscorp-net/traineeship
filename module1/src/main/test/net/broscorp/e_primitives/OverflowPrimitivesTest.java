package net.broscorp.e_primitives;

import static net.broscorp.e_primitives.OverflowPrimitives.*;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

import org.junit.jupiter.api.Test;

class OverflowPrimitivesTest {

  @Test
  void testAddForOverflowInt_WithoutOverflow() {
    int result = 2147483647;
    result++;
    assertEquals(-2147483648, result);
  }

  @Test
  void testAddForOverflowInt_WithOverflow() {
    assertThrows(ArithmeticException.class, () -> {
      addForOverflowInt(2147483600, 48);
    });
  }

  @Test
  void testAddForOverflowByte_WithoutOverflow() {
    long result = addForOverflowByte(50, 50);
    assertEquals(100, result);
  }

  @Test
  void testAddForOverflowByte_WithOverflow() {
    assertThrows(ArithmeticException.class, () -> {
      addForOverflowByte(100, 50);
    });
  }

  @Test
  void testAddForOverflowLong_WithOverflow() {
    assertThrows(ArithmeticException.class, () -> {
      addForOverflowLong(5223372036854775807L, 5223372036854775807L);
    });
  }

  @Test
  void testAddForOverflowLong_WithoutOverflow() {
    long result = addForOverflowLong(4223372036854775807L, 4223372036854775807L);
    assertEquals(8446744073709551614L, result);
  }
}