package net.broscorp.override.overload;

public class AdditionImpl implements MathOperation {

  @Override
  public double execute(double first, double second) {
    return first + second;
  }

  @Override
  public double execute(Double first, Double second) {
    return first + second;
  }

  @Override
  public double execute(int first, int second) {
    return first + second;
  }

  @Override
  public double execute(Integer first, Integer second) {
    return first + second;
  }
}
