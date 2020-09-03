package net.broscorp.override.overload;

public interface MathOperation {
  public double operation(double first, double second);

  public double operation(int first, int second);

  public double operation(Integer first, Integer second);

  public double operation(Double first, Double second);
}
