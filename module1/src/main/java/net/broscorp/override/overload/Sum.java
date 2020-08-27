package net.broscorp.override.overload;

public class Sum implements MathOperation {

  @Override
  public double mathOperation(double a, double b) {
    return a + b;
  }

  @Override
  public double mathOperation(int a, int b) {
    return a + b;
  }

  @Override
  public double mathOperation(Integer a, Integer b) {
    return a + b;
  }
}
