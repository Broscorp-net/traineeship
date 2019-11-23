package net.broscorp.m_override_overload;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

class AddingTest {

  private static Adding add;

  @BeforeAll
  public static void initialization() {
    add = new Adding();
  }

  @Test
  void testDoublePrimitiveCalc() {
    double a = 2.0;
    double b = 3.0;
    assertEquals(5.0, add.doublePrimitiveCalc(a, b));
  }

  @Test
  void testDoubleWrapperCalc() {
    Double a = 2.0;
    Double b = 3.0;
    assertEquals(5.0, add.doubleWrapperCalc(a, b));
  }

  @Test
  void testIntPrimitiveCalc() {
    int a = 2;
    int b = 3;
    assertEquals(5, add.intPrimitiveCalc(a, b));
  }

  @Test
  void testIntWrapperCalc() {
    Integer a = 2;
    Integer b = 3;
    assertEquals(5, add.intWrapperCalc(a, b));
  }

  @Test
  void testAddWrapperPrimitive() {
    int a = 100;
    Integer b = 100;
    addWrapperPrimitive(a, b);
    assertEquals(200, addWrapperPrimitive(a, b));
  }

  static int addWrapperPrimitive(int a, Integer b) {
    int c = a + b;
    return c;
  }

}
