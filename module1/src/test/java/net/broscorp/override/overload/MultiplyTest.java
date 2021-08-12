/*
 * Copyright (c) 2021.
 * Danylo Havrylchenko
 * GitHub: @akellanotavailable
 */

package net.broscorp.override.overload;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

class MultiplyTest {

  Multiply mult = new Multiply();

  @Test
  void multiplyDoublePrimitives() {
    assertEquals(14.0d, mult.operation(3.5d, 4d));
  }

  @Test
  void multiplyIntegerPrimitives() {
    assertEquals(21.0d, mult.operation(3, 7));
  }

  @Test
  void multiplyDoubleWrappers() {
    assertEquals(18.75d, mult.operation(Double.valueOf(2.5d), Double.valueOf(7.5d)));
  }

  @Test
  void multiplyIntegerWrappers() {
    assertEquals(21.0d, mult.operation(Integer.valueOf(3), Integer.valueOf(7)));
  }
}