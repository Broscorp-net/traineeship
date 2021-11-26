package net.broscorp.override.overload;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

class MathOperationAddTest {

  MathOperationAdd mathOperationAdd = new MathOperationAdd();

  @Test
  void twoDoublesPrimitiveDouble() {
    double a = 1.5;
    double b = 2.0;

    double res = mathOperationAdd.twoDoubles(a, b);
    assertEquals(3.5, res);
  }

  @Test
  void twoDoublesPrimitiveInt() {
    int a = 5;
    int b = 3;

    double res = mathOperationAdd.twoDoubles(a, b);
    assertEquals(8.0, res);
  }

  @Test
  void twoDoublesObjectsInt() {
    Integer a = 3;
    Integer b = 2;

    double res = mathOperationAdd.twoDoubles(a, b);
    assertEquals(5.0, res);
  }
}