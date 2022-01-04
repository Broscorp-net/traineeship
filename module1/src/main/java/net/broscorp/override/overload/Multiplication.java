package net.broscorp.override.overload;

public class Multiplication implements MathOperation {

  @Override
  public double mathOp(double d1, double d2) {
    return d1 * d2;
  }

  @Override
  public double mathOp(int i1, int i2) {
    return i1 * i2;
  }

  @Override
  public double mathOp(Double dw1, Double dw2) {
    return dw1 * dw2;
  }
}
