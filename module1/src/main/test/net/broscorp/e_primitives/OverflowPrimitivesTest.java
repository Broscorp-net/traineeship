package net.broscorp.e_primitives;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

class OverflowPrimitivesTest {

  @Test
  void testAddForOverflowInt() {
    int result = 2147483647;
    result++;
    assertEquals(-2147483648, result);
  }
}