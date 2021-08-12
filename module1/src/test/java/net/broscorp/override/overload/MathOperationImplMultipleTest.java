package net.broscorp.override.overload;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

class MathOperationImplMultipleTest {

  MathOperation mathOperation = new MathOperationImplMultiple();

  @Test
  void operationMethod() {
    double first = 5.0;
    int second = 10;
    double actual = mathOperation.operationMethod(first, second);
    double expected = 50.0;
    Assertions.assertEquals(expected, actual);
  }

  @Test
  void testOperationMethod() {
    Double first = 5.0;
    Integer second = 10;
    double actual = mathOperation.operationMethod(first, second);
    double expected = 50.0;
    Assertions.assertEquals(expected, actual);

  }

  @Test
  void testOperationMethod1() {
    double first = 5.0;
    Integer second = 10;
    double actual = mathOperation.operationMethod(first, second);
    double expected = 50.0;
    Assertions.assertEquals(expected, actual);
  }

  /*Java компилятор выдает сообщение о том,
  что происходит двусмысленный(неопределенный) вызов метода.
  Поэтому не может определиться какой из этих методов вызвать:
  public double operationMethod(Integer first, Integer second);
  public double operationMethod(int first, int second);*/

  /*  @Test
    void testOperationMethod2() {
      Integer first = 5;
      int second = 10;
      double actual = mathOperation.operationMethod(first, second);
      double expected = 50.0;
      Assertions.assertEquals(expected, actual);
    }*/

  /*Java компилятор выдает сообщение о том,
  что происходит двусмысленный(неопределенный) вызов метода.
  Поэтому не может определиться какой из этих методов вызвать:
  public double operationMethod(Double first, Double second);
  public double operationMethod(double first, double second);*/

  /*  @Test
    void testOperationMethod2() {
      Double first = 5.0;
      double second = 10.0;
      double actual = mathOperation.operationMethod(first, second);
      double expected = 50.0;
      Assertions.assertEquals(expected, actual);
    }*/
}