package net.broscorp.override.overload;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

class MultiplyMathOperationImplTest {

  private static MathOperation multiplyOperation;
  private static double a;
  private static double b;
  private static int c;
  private static int d;
  private static Double e;
  private static Double f;

  @BeforeAll
  public static void setup() {
    multiplyOperation = new MultiplyMathOperationImpl();
    a = 2.0;
    b = 3.0;
    c = 2;
    d = 3;
    e = 2.0;
    f = 3.0;
  }

  @Test
  void mathDoubleOperationTest() {
    double expected = multiplyOperation.mathOperation(a, b);
    Assertions.assertEquals(expected, 6.0);
  }

  @Test
  void testMathOperation() {
    double expected = multiplyOperation.mathOperation(c, d);
    Assertions.assertEquals(expected, 6);
  }

  @Test
  void mathWrapperOperationTest() {
    double expected = multiplyOperation.mathOperation(e, f);
    Assertions.assertEquals(expected, 6.0);
  }

  /**
   * this method will be called - double mathOperation(double a, double b).
   */

  @Test
  void mathWrapperAndPrimitiveOperationTest() {
    double expected = multiplyOperation.mathOperation(c, f);
    Assertions.assertEquals(expected, 6.0);
  }
}
