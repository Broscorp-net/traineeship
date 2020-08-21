package net.broscorp.primitives;

import static org.junit.Assert.assertNotEquals;
import static org.junit.Assert.assertTrue;

import org.junit.Test;

public class Primitives {

  @Test
  public void intOverload() {
    int a = Integer.MAX_VALUE;
    int b = a + 1;

    assertTrue(b < a);
  }

  @Test
  public void longInteger() {
    long a = Long.MAX_VALUE;
    int b = (int) a;

    assertNotEquals(a, b);
  }

  @Test
  public void floatDouble() {
    float a = 20.20f;
    double b = a;

    assertNotEquals(20.20, b);
  }

  @Test
  public void floatingPointOperation() {
    float a = 1.0f - 0.5f;

    assertNotEquals(0.5, a);
  }
}
