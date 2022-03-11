package net.broscorp;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

class MyTest {

  @Test
  public void testOverflow() {
    int a = 2_000_000_000;
    int b = 2_000_000_000;

    int c = a + b;

    Assertions.assertEquals(-294967296, c);
  }

  @Test
  public void testLongToInt() {
    long a = 254354645645L;

    int b = (int) a;

    Assertions.assertEquals(951575181, b);
  }

  @Test
  public void testDoubleToFloat() {
    double a = 1 * Math.pow(10, -300);

    float b = (float) a;

    Assertions.assertEquals(0F, b);
  }

  @Test
  public void testAccuracy() {
    float a = 0;

    for (int i = 0; i < 16777219; i++) {
      a++;
    }

    Assertions.assertEquals(1.6777216E7, a);
  }
}