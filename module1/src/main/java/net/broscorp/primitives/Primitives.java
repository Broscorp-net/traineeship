package net.broscorp.primitives;

import static org.junit.Assert.assertNotEquals;
import static org.junit.Assert.assertTrue;

import org.junit.Test;

public class Primitives {

  @Test
  public void byteOverload() {
    int a = Byte.MAX_VALUE;
    int b = a + 1;
    assertTrue(b < a);
  }

  @Test
  public void shortOverload() {
    int a = Short.MAX_VALUE;
    int b = a + 2;
    assertTrue(b < a);
  }

  @Test
  public void intOverload() {
    int a = Integer.MAX_VALUE;
    int b = a + 2;
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
    float a = 10.10f;
    double b = a;
    assertNotEquals(10.10, b);
  }

  @Test
  public void floatingPointOperation() {
    float a = 1.0f - 0.5f;
    assertNotEquals(0.5, a);
  }
}
