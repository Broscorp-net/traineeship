package net.broscorp.override.overload;

public interface MathOperation {

  double calculate(double arg1, double arg2);

  double calculate(int arg1, int arg2);

  double calculate(Integer arg1, Integer arg2);

  double calculate(Double arg1, Double arg2);
}
