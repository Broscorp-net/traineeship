package net.broscorp.override.overload;

public class MultiplyMathOperationImpl implements MathOperation {

  @Override
  public double mathOperation(double a, double b) {
    return a * b;
  }

  @Override
  public double mathOperation(int c, int d) {
    return c * d;
  }

  @Override
  public double mathOperation(Double e, Double f) {
    return e * f;
  }
}
