package net.broscorp.override.overload;

public class MultiplyMethod implements MathOperation {

  @Override
  public double arguments(double arg1, double arg2) {
    return arg1 * arg2;
  }

  @Override
  public double arguments(int arg1, int arg2) {
    return arg1 * arg2;
  }

  @Override
  public double arguments(Integer arg1, Integer arg2) {
    return arg1.doubleValue() * arg2.doubleValue();
  }
}
