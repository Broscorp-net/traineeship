package net.broscorp.override.overload;

public interface MathOperation {

  double method(double firstDouble, double secondDouble);

  double method(int firstInt, int secondInt);

  double method(Double firstDouble, Double secondDouble);

  double method(Integer firstInt, Integer secondInt);

}
