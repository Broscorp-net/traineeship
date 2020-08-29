package net.broscorp.override.overload;

public class MultiplyMathOperation implements MathOperation {

  @Override
  public double calculate(double x, double y) {
    return x * y;
  }

  @Override
  public double calculate(int x, int y) {
    return x * y;
  }

  @Override
  public double calculate(Double x, Double y) {
    return x * y;
  }

  @Override
  public double calculate(Integer x, Integer y) {
    return x * y;
  }
}
