package net.broscorp.m_override_overload;

public class MathOperationMultiply implements MathOperation {

  @Override
  public double operation(double a, double b) {
    return a * b;
  }

  @Override
  public int operation(int a, int b) {
    return a * b;
  }

  @Override
  public Integer operation(Integer a, Integer b) {
    return a * b;
  }

  @Override
  public Double operation(Double a, Double b) {
    return a * b;
  }

  public Double operation(Double a, double b) {
    return a * b;
  }
}
