package net.broscorp.override.overload;

public class SubtractionOperation implements MathOperation {
  @Override
  public double operation(double firstValue, double secondValue) {
    return firstValue - secondValue;
  }

  @Override
  public double operation(int firstValue, int secondValue) {
    return (double) firstValue - secondValue;
  }

  @Override
  public double operation(Integer firstValue, Integer secondValue) {
    return (double) firstValue - secondValue;
  }
}
