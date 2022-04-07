package net.broscorp.override.overload;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class SumImplementationTest {
  static double a;
  static double b;
  static SumImplementation sumImplementation;

  @BeforeAll
  static public void fill() {
    a = 2;
    b = 5;
    sumImplementation = new SumImplementation();
  }

  @Test
  public void checkWithBothDouble() {
    double res = sumImplementation.operation(a, b);
    double expectResult = 7.0;
    assertEquals(res, expectResult);
  }

  @Test
  public void checkWithBothIntegerPrimitives() {
    double res = sumImplementation.operation((int) a, (int) b);
    double expectResult = 7.0;
    assertEquals(res, expectResult);
  }

  @Test
  public void checkWithBothWrappedInteger() {
    Integer a = 2;
    Integer b = 5;
    double res = sumImplementation.operation(a, b);
    double expectResult = 7.0;
    assertEquals(res, expectResult);
  }

  @Test
  public void checkWithResultOfWrappedDouble() {
    Integer a = 2;
    Integer b = 5;
    double res = sumImplementation.operation(a, b);
    Double expectResult = 7.0;
    assertEquals(res, expectResult);
  }

}