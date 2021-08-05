package net.broscorp.override.overload;

public class Multiplication implements MathOperation {

  @Override
  public double doMathOperation(double a, double b) {
    return a * b;
  }

  @Override
  public double doMathOperation(int a, int b) {
    return a * b;
  }

  @Override
  public double doMathOperation(Double a, Double b) {
    return a * b;
  }

  @Override
  public double doMathOperation(Integer a, Integer b) {
    return a * b;
  }
}
