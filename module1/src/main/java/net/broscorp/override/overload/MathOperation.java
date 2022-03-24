package net.broscorp.override.overload;

public interface MathOperation<T extends Number> {

  double add(double a, double b);

  int add(int a, int b);

  Double add(T a, T b);

}
