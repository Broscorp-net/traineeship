package net.broscorp.e_primitives;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class ImprecisionDoubleTest {

  @Test
  void testImprecisionDouble() {
    double value = 0.001;
    for (int i = 0; i < 10; i++) {
      value += 0.001;
    }
    assertEquals(0.011000000000000003, value);
  }

  @Test
  void testAccuracyDouble() {
    double value = 0.001;
    value *= 10;

    assertEquals(0.01, value);
  }
}
