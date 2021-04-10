package net.broscorp.override.overload;

public interface MathOperation {
  double operate(double firstDouble, double secondDouble);

  double operate(int firstInt, int secondInt);

  double operate(Double firstDouble, Double secondDouble);

  double operate(Integer firstInteger, Integer secondInteger);
}
