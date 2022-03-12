package net.broscorp.override.overload;

public class RealizationMultiplication implements MathOperation {

  @Override
  public double operation(double a, double b) {
    return a * b;
  }

  @Override
  public double operation(int a, int b) {
    return a * b;
  }

  @Override
  public double operation(Double a, Double b) {
    return a * b;
  }

  @Override
  public double operation(Integer a, Integer b) {
    return a * b;
  }
}
