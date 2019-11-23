package net.broscorp.m_override_overload;

public class Adding implements Math_Op {

  @Override
  public double doublePrimitiveCalc(double a, double b) {
    double c = a + b;
    return c;
  }

  @Override
  public double doubleWrapperCalc(Double a, Double b) {
    double c = a + b;
    return c;
  }

  @Override
  public int intPrimitiveCalc(int a, int b) {
    int c = a + b;
    return c;
  }

  @Override
  public int intWrapperCalc(Integer a, Integer b) {
    int c = a + b;
    return c;
  }

}
