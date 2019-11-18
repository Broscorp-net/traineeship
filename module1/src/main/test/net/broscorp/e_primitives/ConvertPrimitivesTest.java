package net.broscorp.e_primitives;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

class ConvertPrimitivesTest {

  @Test
  void testConvertLongToInt() {
    long value = 4223372036854775807L;
    int result = (int) value;
    assertEquals(-1156841473, result);
  }

  @Test
  void testConvertFloatToDouble() {
    double value = 9.000000000555555E9;
    float result = (float) value;
    assertEquals(9.000000512E9, result, 0.0001);
  }
}
