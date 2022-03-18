package net.broscorp.override.overload;

public class MathOperationAdd implements MathOperation{

  @Override
  public double mathOperation(double a, double b) {
    return a+b;
  }

  @Override
  public double mathOperation(int a, int b) {
    return (double) a+b;
  }

  @Override
  public double mathOperation(Double a, Double b) {
    return a.doubleValue()+b.doubleValue();
  }

  @Override
  public double mathOperation(Integer a, Integer b) {
    return a.doubleValue()+b.doubleValue();
  }
}
