package net.broscorp.override.overload;

public class MultiplyOperations implements MathOperations {
  @Override
  public double someMathOperation(double first, double second) {
    return first * second;
  }

  @Override
  public double someMathOperation(int first, int second) {
    return first * second;
  }

  @Override
  public double someMathOperation(Integer first, Integer second) {
    return first * second;
  }

  @Override
  public double someMathOperation(Double first, Double second) {
    return first * second;
  }


}
