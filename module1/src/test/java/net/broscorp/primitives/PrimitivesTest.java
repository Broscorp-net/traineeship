package net.broscorp.primitives;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class PrimitivesTest {

  @Test
  public void byteOverload() {
    byte a = Byte.MAX_VALUE;
    byte b = (byte) (a + 1);
    Assertions.assertTrue(b < a);
  }

  @Test
  public void shortOverload() {
    short a = Short.MAX_VALUE;
    short b = (short) (a + 1);
    Assertions.assertTrue(b < a);
  }

  @Test
  public void intOverload() {
    int a = Integer.MAX_VALUE;
    int b = a + 1;
    Assertions.assertTrue(b < a);
  }

  @Test
  public void shortByte() {
    short a = Short.MAX_VALUE;
    byte b = (byte) a;
    Assertions.assertNotEquals(a, b);
  }

  @Test
  public void integerShort() {
    int a = Integer.MAX_VALUE;
    short b = (short) a;
    Assertions.assertNotEquals(a, b);
  }

  @Test
  public void longInteger() {
    long a = Long.MAX_VALUE;
    int b = (int) a;
    Assertions.assertNotEquals(a, b);
  }

  @Test
  public void floatDouble() {
    float a = 10.1f;
    double b = a;
    Assertions.assertNotEquals(10.1, b);

  }

  @Test
  public void floatingPointOperation() {
    float a = 0.6f + 0.4f;
    Assertions.assertNotEquals(1, a);
  }
}
