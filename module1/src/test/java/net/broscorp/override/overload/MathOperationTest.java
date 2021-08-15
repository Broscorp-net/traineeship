package net.broscorp.override.overload;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

class MathOperationTest {

  private MultiplyMathOperation multiplyMathOperation = new MultiplyMathOperation();
  private AddMathOperation addMathOperation = new AddMathOperation();

  @Test
  void allDoubleVariablesTest() {
    double d1 = 2.;
    double d2 = 3.;
    assertEquals(6., multiplyMathOperation.someOperation(d1, d2));
    assertEquals(5., addMathOperation.someOperation(d1, d2));
  }

  @Test
  void allIntVariablesTest() {
    int i1 = 1;
    int i2 = 2;
    assertEquals(2., multiplyMathOperation.someOperation(i1, i2));
    assertEquals(3., addMathOperation.someOperation(i1, i2));
  }

  @Test
  void allIntegerVariablesTest() {
    Integer i1 = 1;
    Integer i2 = 2;
    assertEquals(2., multiplyMathOperation.someOperation(i1, i2));
    assertEquals(3., addMathOperation.someOperation(i1, i2));
  }

  // Перегруженного метода с такими типами аргументов нет, поэтому происходит неявное повышение
  // Integer до double и вызывается метод с двумя агрументами double.
  @Test
  void intAndIntegerVariablesTest() {
    Integer i1 = 1;
    double i2 = 2.;
    assertEquals(2., multiplyMathOperation.someOperation(i1, i2));
    assertEquals(3., addMathOperation.someOperation(i1, i2));
  }

}