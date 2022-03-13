package net.broscorp.override.overload;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

class RealizationDoubleMathOperationTest {

  MathOperation mathOperation = new RealizationSumMathOperation();

  @Test
  void functionDoublePrimitiveType() {
    double num1 = 1.0;
    double num2 = 1.0;
    double result = mathOperation.function(num1, num2);
    assertEquals(2, result);
  }

  @Test
  void functionIntPrimitiveType() {
    int num1 = 1;
    int num2 = 1;
    double result = mathOperation.function(num1, num2);
    assertEquals(2, result);
  }

  @Test
  void functionDoubleWrapperType() {
    Double num1 = 1.0;
    Double num2 = 1.0;
    double result = mathOperation.function(num1, num2);
    assertEquals(2, result);
  }

  @Test
  void functionIntWrapperType() {
    Integer num1 = 1;
    Integer num2 = 1;
    double result = mathOperation.function(num1, num2);
    assertEquals(2, result);
  }
}