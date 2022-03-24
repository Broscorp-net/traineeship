package net.broscorp.override.overload;

public class MathOperationImpl implements MathOperation {

  @Override
  public double add(double a, double b) {
    return a + b;
  }

  @Override
  public int add(int a, int b) {
    return a + b;
  }

  @Override
  public Double add(Number a, Number b) {
    return a.doubleValue() + b.doubleValue();
  }
}
