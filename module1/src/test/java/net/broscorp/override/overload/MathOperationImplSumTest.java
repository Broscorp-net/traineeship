package net.broscorp.override.overload;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

class MathOperationImplSumTest {

  MathOperation mathOperation = new MathOperationImplSum();

  @Test
  void operationMethod() {
    int first = 3;
    double second = 4.0;
    double actual = mathOperation.operationMethod(first, second);
    double expected = 7.0;
    Assertions.assertEquals(expected, actual);
  }

  @Test
  void testOperationMethod() {
    Integer first = 3;
    Double second = 4.0;
    double actual = mathOperation.operationMethod(first, second);
    double expected = 7.0;
    Assertions.assertEquals(expected, actual);

  }

  @Test
  void testOperationMethod1() {
    Integer first = 3;
    double second = 4.0;
    double actual = mathOperation.operationMethod(first, second);
    double expected = 7.0;
    Assertions.assertEquals(expected, actual);
  }

  /*Java компилятор выдает сообщение о том,
  что происходит двусмысленный(неопределенный) вызов метода.
  Поэтому не может определиться какой из этих методов вызвать:
  public double operationMethod(Integer first, Integer second);
  public double operationMethod(int first, int second);*/

  /*  @Test
    void testOperationMethod2() {
      Integer first = 3;
      int second = 4;
      double actual = mathOperation.operationMethod(first, second);
      double expected = 7.0;
      Assertions.assertEquals(expected, actual);
    }*/

  /*Java компилятор выдает сообщение о том,
  что происходит двусмысленный(неопределенный) вызов метода.
  Поэтому не может определиться какой из этих методов вызвать:
  public double operationMethod(Double first, Double second);
  public double operationMethod(double first, double second);*/

  /*  @Test
    void testOperationMethod2() {
      Double first = 3.0;
      double second = 4.0;
      double actual = mathOperation.operationMethod(first, second);
      double expected = 7.0;
      Assertions.assertEquals(expected, actual);
    }*/
}