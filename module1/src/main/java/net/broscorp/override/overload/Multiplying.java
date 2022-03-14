package net.broscorp.override.overload;

public class Multiplying implements MathOperation {

  @Override
  public double operation(double a, double b) {
    return a * b;
  }

  @Override
  public double opetation(int a, int b) {
    return a * b;
  }

  @Override
  public double opetation(Double a, Double b) {
    return a * b;
  }

  @Override
  public double opetation(Integer a, Integer b) {
    return a * b;
  }
}
