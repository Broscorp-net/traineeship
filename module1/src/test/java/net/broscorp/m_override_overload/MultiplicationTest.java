package net.broscorp.m_override_overload;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

/**
 * @Override Annotation gives to Compiler exact instruction that "Child" method inherited
 *           functionality must be executed.
 * @author adamenko
 *
 */

class MultiplicationTest {

  private static Multiplication mult;

  @BeforeAll
  public static void initialization() {
    mult = new Multiplication();
  }


  @Test
  void testDoublePrimitiveCalc() {
    double a = 2.0;
    double b = 3.0;
    assertEquals(a * b, mult.compute(a, b));
  }

  @Test
  void testDoubleWrapperCalc() {
    Double a = 2.0;
    Double b = 3.0;
    assertEquals(a * b, mult.compute(a, b));
  }

  @Test
  void testIntPrimitiveCalc() {
    int a = 2;
    int b = 3;
    assertEquals(a * b, mult.compute(a, b));
  }

  @Test
  void testIntWrapperCalc() {
    Integer a = 2;
    Integer b = 3;
    assertEquals(a * b, mult.compute(a, b));
  }

}
