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
    assertEquals(a+b, add.compute(a, b));
  }

  @Test
  void testDoubleWrapperCalc() {
    Double a = 2.0;
    Double b = 3.0;
    assertEquals(a+b, add.compute(a, b));
  }

  @Test
  void testIntPrimitiveCalc() {
    int a = 2;
    int b = 3;
    assertEquals(a+b, add.compute(a, b));
  }

  @Test
  void testIntWrapperCalc() {
    Integer a = 2;
    Integer b = 3;
    assertEquals(a+b, add.compute(a, b));
  }

  /**
   * Compiler can't decide which of realization must be executed
   */
  @Test
  void testAddWrapperPrimitive() {
    int a = 2;
    Integer b = 3;
    //assertEquals(a+b, add.compute(a, b));
  }
  
}
