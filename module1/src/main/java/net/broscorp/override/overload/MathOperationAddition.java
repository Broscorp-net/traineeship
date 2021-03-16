package net.broscorp.override.overload;

/**
 *
 */

public class MathOperationAddition implements MathOperation{


  @Override
  public double mathOperation(double num1, double num2) {
    return num1 + num2;
  }

  @Override
  public double mathOperation(int num1, int num2) {
    return num1 + num2;
  }

  @Override
  public double mathOperation(Double num1, Double num2) {
    return num1 + num2;
  }

  @Override
  public double mathOperation(Integer num1, Integer num2) {
    return num1 + num2;
  }
}
