package net.broscorp.primitives;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;

import org.junit.jupiter.api.Test;

class PrimitivesTest {

  @Test
  void byteOverflow() {
    Primitives primitives = new Primitives();
    byte actual = primitives.byteOverflow();
    byte expected = Byte.MIN_VALUE;
    System.out.println("expected: " + expected + ", actual: " + actual);
    assertEquals(expected, actual);
  }

  @Test
  void shortOverflow() {
    Primitives primitives = new Primitives();
    short actual = primitives.shortOverflow();
    short expected = Short.MIN_VALUE;
    System.out.println("expected: " + expected + ", actual: " + actual);
    assertEquals(expected, actual);
  }

  @Test
  void integerOverflow() {
    Primitives primitives = new Primitives();
    int actual = primitives.integerOverflow();
    int expected = Integer.MAX_VALUE;
    System.out.println("expected: " + expected + ", actual: " + actual);
    assertNotEquals(expected, actual);
  }

  @Test
  void longOverflow() {
    Primitives primitives = new Primitives();
    long actual = primitives.longOverflow();
    long expected = Long.MAX_VALUE;
    System.out.println("expected: " + expected + ", actual: " + actual);
    assertNotEquals(expected, actual);
  }

  @Test
  void floatOverflow() {
    Primitives primitives = new Primitives();
    float actual = primitives.floatOverflow();
    float expected = Float.MAX_VALUE;
    System.out.println("expected: " + expected + ", actual: " + actual);
    assertEquals(expected, actual);
  }

  @Test
  void doubleOverflow() {
    Primitives primitives = new Primitives();
    double actual = primitives.doubleOverflow();
    double expected = Double.MAX_VALUE;
    assertEquals(expected, actual);
  }

  @Test
  void convLongToInt() {
    Primitives primitives = new Primitives();
    int actual = primitives.convLongToInt(3_000_000_000L); //L-значит long
    long expected = 3_000_000_000L;
    System.out.println("expected: " + expected + ", actual: " + actual);
    assertNotEquals(expected, actual);
  }

  @Test
  void convFloatToDouble() {
    Primitives primitives = new Primitives();
    double actual = primitives.convFloatToDouble(0.1111111111111111f); //f-значит float
    double expected = 0.1111111111111111d;
    System.out.println("expected: " + expected + ", actual: " + actual);
    assertNotEquals(expected, actual);
  }

  @Test
  void fderr() {
    Primitives primitives = new Primitives();
    double factual = primitives.fsum();
    double dactual = 0.7777777777777777;
    double actual = factual - dactual;
    double expected = 0;
    System.out.println(
        "expected: " + expected + ", actual: " + actual + ", factual: " + factual + ", dactual: "
            + dactual);
    assertNotEquals(expected, actual);
  }
}