package net.broscorp.override.overload;

public interface MathOperation {

  public double arithmeticOperation(double x, double y);

  public double arithmeticOperation(int x, int y);

  public double arithmeticOperation(Integer x, Integer y);

  public double arithmeticOperation(Double x, Double y);
}