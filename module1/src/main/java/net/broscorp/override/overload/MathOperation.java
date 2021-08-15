package net.broscorp.override.overload;

public interface MathOperation {

  double someOperation(double var1, double var2);
  double someOperation(int var1, int var2);
  double someOperation(Integer var1, Double var2);

}
