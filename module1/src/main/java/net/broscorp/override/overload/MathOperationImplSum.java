package net.broscorp.override.overload;

public class MathOperationImplSum implements MathOperation {

  @Override
  public double operationMethod(double first, double second) {
    return first + second;
  }

  @Override
  public double operationMethod(int first, int second) {
    return first + second;
  }

  @Override
  public double operationMethod(Double first, Double second) {
    return first + second;
  }

  @Override
  public double operationMethod(Integer first, Integer second) {
    return first + second;
  }
}
