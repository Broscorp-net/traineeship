package net.broscorp.override.overload;

public interface MathOperation {

  double calculate(double x, double y);

  double calculate(int x, int y);

  double calculate(Double x, Double y);

  double calculate(Integer x, Integer y);
}
