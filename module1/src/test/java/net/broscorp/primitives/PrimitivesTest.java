package net.broscorp.primitives;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

public class PrimitivesTest {
  @Test
  void overloop() throws Exception {

    byte c = Byte.MAX_VALUE;

    assertEquals(-128, ++c);
  }

  @Test
  void conversionInt() {

    long l = 922337203685477580L;
    int i = (int) l;

    assertEquals(-858993460, i);
  }

  @Test
  void conversionDouble() {
    float f = 2345.23452345f;

    double d = f;

    assertEquals(2345.234619140625, d);
  }

  @Test
  void infelicity() {
    double a = 0.1;

    double b = 0.2;

    double d = a + b;

    assertEquals(0.30000000000000004, d);
  }
}
