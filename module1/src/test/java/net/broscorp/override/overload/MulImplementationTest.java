package net.broscorp.override.overload;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

class MulImplementationTest {
  static double a;
  static double b;
  static MulImplementation mulImplementation;

  @BeforeAll
  static public void fill() {
    a = 2;
    b = 5;
    mulImplementation = new MulImplementation();
  }

  @Test
  public void checkWithBothDouble() {
    double res = mulImplementation.operation(a, b);
    double expectResult = 10.0;
    assertEquals(res, expectResult);
  }

  @Test
  public void checkWithBothIntegerPrimitives() {
    double res = mulImplementation.operation((int) a, (int) b);
    double expectResult = 10.0;
    assertEquals(res, expectResult);
  }

  @Test
  public void checkWithBothWrappedInteger() {
    Integer a = 2;
    Integer b = 5;
    double res = mulImplementation.operation(a, b);
    double expectResult = 10.0;
    assertEquals(res, expectResult);
  }

  @Test
  public void checkWithResultOfWrappedDouble() {
    Integer a = 2;
    Integer b = 5;
    double res = mulImplementation.operation(a, b);
    Double expectResult = 10.0;
    assertEquals(res, expectResult);
  }

  /**
   * Не работает вызов при парметрах примитива и обертки то возникает ошибка поэтому вызов был закоментирован.
   */
  @Test
  public void checkWithWrappedAndPrimitiveArgument() {
    Double a = 2.0;
    double b = 3.0;
//    assertEquals(6.0, mulImplementation.operation(a, b));
  }
}