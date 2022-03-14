package net.broscorp.override.overload;

public interface MathOperation {

  double calculate(double first, double second);

  double calculate(int first, int second);

  double calculate(Integer first, Integer second);

  double calculate(Double first, Double second);
}
