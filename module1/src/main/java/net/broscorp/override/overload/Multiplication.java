package net.broscorp.override.overload;

public class Multiplication implements MathOperation {

  @Override
  public double calculate(double d1, double d2) {
    System.out.println("calculate(double d1, double d2)");
    return d1 * d2;
  }

  @Override
  public double calculate(Double d1, Double d2) {
    System.out.println("calculate(Double d1, Double d2)");
    return d1 * d2;
  }

  @Override
  public double calculate(int i1, int i2) {
    System.out.println("calculate(int i1, int i2)");
    return i1 * i2;
  }

  @Override
  public double calculate(Integer i1, Integer i2) {
    System.out.println("calculate(Integer i1, Integer i2)");
    return i1 * i2;
  }
}
