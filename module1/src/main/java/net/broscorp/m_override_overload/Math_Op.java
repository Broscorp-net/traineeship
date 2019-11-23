package net.broscorp.m_override_overload;

public interface Math_Op {
  public double doublePrimitiveCalc(double a, double b);

  public double doubleWrapperCalc(Double a, Double b);

  public int intPrimitiveCalc(int a, int b);

  public int intWrapperCalc(Integer a, Integer b);
}
