package net.broscorp.m_override_overload;

public class Multiplication implements Math_Op {

  @Override
  public double compute(double a, double b) {
    return a * b;
  }

  @Override
  public double compute(Double a, Double b) {
    return a * b;
  }

  @Override
  public int compute(int a, int b) {
    return a * b;
  }

  @Override
  public int compute(Integer a, Integer b) {
    return a * b;
  }

}
