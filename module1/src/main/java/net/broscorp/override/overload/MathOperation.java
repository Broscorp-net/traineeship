package net.broscorp.override.overload;

public interface MathOperation {
  double consumes(double var1, double var2);

  double consumes(int var1, int var2);

  double consumes(Integer var1, Integer var2);

  double consumes(Double var1, Double var2);
}
