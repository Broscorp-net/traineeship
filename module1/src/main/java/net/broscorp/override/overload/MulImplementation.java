package net.broscorp.override.overload;

public class MulImplementation implements MathOperation {
  @Override
  public double operation(double a, double b) {
    return a * b;
  }

  @Override
  public double operation(int a, int b) {
    return (double) (a * b);
  }

  @Override
  public double operation(Integer a, Integer b) {
    return Double.valueOf(a * b);
  }

  @Override
  public double operation(Double a, Double b) {
    return a * b;
  }
}
