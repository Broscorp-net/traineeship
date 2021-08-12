/*
 * Copyright (c) 2021.
 * Danylo Havrylchenko
 * GitHub: @akellanotavailable
 */

package net.broscorp.override.overload;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

class SumTest {

  Sum sum = new Sum();

  @Test
  void sumDoublePrimitives() {
    assertEquals(10.0d, sum.operation(2.5d, 7.5d));
  }

  @Test
  void sumIntegerPrimitives() {
    assertEquals(10.0d, sum.operation(3, 7));
  }

  @Test
  void sumDoubleWrappers() {
    assertEquals(10.0d, sum.operation(Double.valueOf(2.5d), Double.valueOf(7.5d)));
  }

  @Test
  void sumIntegerWrappers() {
    assertEquals(10.0d, sum.operation(Integer.valueOf(3), Integer.valueOf(7)));
  }
}