package net.broscorp.override.overload;

public interface MathOperation {

  public double arithmeticAddition(double x, double y);

  public double arithmeticAddition(int x, int y);

  public double arithmeticAddition(Integer x, Integer y);

  public double arithmeticAddition(Double x, Double y);
}