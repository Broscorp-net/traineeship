package net.broscorp.override.overload;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

class MathOperationImplTest {

  MathOperation calc = new MathOperationImpl();

  @Test
  void add() {
    int a = 5;
    int b = 5;
    int result = calc.add(a, b);
    assertEquals(10, calc.add(a, b));

  }

  @Test
  void testAdd() {
    double a = 5;
    double b = 5;
    double result = calc.add(a, b);
    assertEquals(10, result);
  }

  @Test
  void testAdd1() {
    Integer a = Integer.valueOf(5);
    Double b = Double.valueOf(5);
    Double result = calc.add(a,b);
    assertEquals(10, result);
  }
}