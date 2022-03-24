package net.broscorp.override.overload;

public class RealizationMultiOperation implements MathOperation {

  @Override
  public double function(double num1, double num2) {
    return num1 * num2;
  }

  @Override
  public double function(int num1, int num2) {
    return num1 * num2;
  }

  @Override
  public double function(Double num1, Double num2) {
    return num1 * num2;
  }

  @Override
  public double function(Integer num1, Integer num2) {
    return num1 * num2;
  }
}
