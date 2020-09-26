package net.broscorp.override.overload;

public interface MathOperation {
  double operation(double x, double y);

  double operation(Double x, Double y);

  double operation(int x, int y);

  double operation(Integer x, Integer y);
}
