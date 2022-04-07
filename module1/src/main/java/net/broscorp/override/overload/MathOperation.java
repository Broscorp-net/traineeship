package net.broscorp.override.overload;

public interface MathOperation {
  double operation(double a, double b);

  double operation(int a, int b);

  double operation(Integer a, Integer b);

  double operation(Double a, Double b);
}
