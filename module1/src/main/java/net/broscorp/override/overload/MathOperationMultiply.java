package net.broscorp.override.overload;

public class MathOperationMultiply implements MathOperation {

  @Override
  public double twoDoubles(double one, double two) {
    return one * two;
  }

  @Override
  public double twoDoubles(int one, int two) {
    return one * two;
  }

  @Override
  public double twoDoubles(Integer one, Integer two) {
    return one.doubleValue() * two.doubleValue();
  }
}
