package net.broscorp.override.overload;

public interface MathOperation {

  public double calculate(double d1, double d2);

  public double calculate(Double d1, Double d2);

  public double calculate(int i1, int i2);

  public double calculate(Integer i1, Integer i2);
}
