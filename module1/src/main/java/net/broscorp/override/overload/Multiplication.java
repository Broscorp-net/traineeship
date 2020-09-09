package net.broscorp.override.overload;

public class Multiplication implements MathOperation {

  @Override
  public double apply(double d1, double d2) {
    return d1 * d2;
  }

  @Override
  public double apply(Double d1, Double d2) {
    return d1 * d2;
  }

  @Override
  public double apply(int i1, int i2) {
    return i1 * i2;
  }

  @Override
  public double apply(Integer i1, Integer i2) {
    return i1 * i2;
  }

}
