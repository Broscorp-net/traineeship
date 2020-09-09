package net.broscorp.override.overload;

public interface MathOperation {

  double apply(double d1, double d2);

  double apply(Double d1, Double d2);

  double apply(int i1, int i2);

  double apply(Integer i1, Integer i2);

}
