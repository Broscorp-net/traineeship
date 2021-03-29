package net.broscorp.override.overload;

public class MathOperationImplMultiplication implements MathOperation {

  @Override
  public double method(double firstDouble, double secondDouble) {
    return firstDouble * secondDouble;
  }

  @Override
  public double method(int firstInt, int secondInt) {
    return firstInt * secondInt;
  }

  @Override
  public double method(Double firstDouble, Double secondDouble) {
    return firstDouble * secondDouble;
  }

  @Override
  public double method(Integer firstInt, Integer secondInt) {
    return firstInt * secondInt;
  }
}
