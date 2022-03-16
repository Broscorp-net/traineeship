package net.broscorp.override.overload;

public class Multiply implements MathOperation {

  @Override
  public double mathOperation(double c, double b) {
    return c * b;
  }

  public double mathOperation(int c, int b) {
    return c * b;
  }

  public double mathOperation(Double c, Double b) {
    return c * b;
  }

  public double mathOperation(Integer c, Integer b) {
    return c * b;
  }
}