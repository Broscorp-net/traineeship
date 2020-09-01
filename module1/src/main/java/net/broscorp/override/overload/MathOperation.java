package net.broscorp.override.overload;

public interface MathOperation {

  double operation(double firstValue, double secondValue);

  double operation(int firstValue, int secondValue);

  double operation(Double firstValue, Double secondValue);

  double operation(Integer firstValue, Integer secondValue);

}
