package net.broscorp.m_override_overload;

public class MultiEx implements MathOperation {

  @Override
  public double math(double i, double t) {
    return i*t;
  }

  @Override
  public double math(int i, int t) {
    return i*t;
  }

  @Override
  public double math(Integer i, Integer t) {
    return i*t;
  }

  @Override
  public double math(Double i, Double t) {
    return i*t;
  }
}
