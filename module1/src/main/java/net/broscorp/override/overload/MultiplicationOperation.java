package net.broscorp.override.overload;

public class MultiplicationOperation implements MathOperation {

  @Override
  public double operation(double firstValue, double secondValue) {
    double scale = Math.pow(10, 2);
    return Math.round((firstValue * secondValue) * scale) / scale;
  }

  @Override
  public double operation(int firstValue, int secondValue) {
    double scale = Math.pow(10, 2);
    return (double) Math.round((firstValue * secondValue) * scale) / scale;
  }

  @Override
  public double operation(Double firstValue, Double secondValue) {
    double scale = Math.pow(10, 2);
    return Math.round((firstValue * secondValue) * scale) / scale;
  }

  @Override
  public double operation(Integer firstValue, Integer secondValue) {
    double scale = Math.pow(10, 2);
    return (double) Math.round((firstValue * secondValue) * scale) / scale;
  }
}
