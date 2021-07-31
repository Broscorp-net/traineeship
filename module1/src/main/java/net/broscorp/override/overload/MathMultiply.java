package net.broscorp.override.overload;

public class MathMultiply implements MathOperation {
  @Override
  public double doCalc(double x, double y) {
    System.out.println("Multiply double primitives");
    return x * y;
  }

  @Override
  public double doCalc(int x, int y) {
    System.out.println("Multiply int primitives");
    return x * y;
  }

  @Override
  public double doCalc(Integer x, Integer y) {
    System.out.println("Multiply Integer wrappers");
    return x * y;
  }

  @Override
  public double doCalc(Double x, Double y) {
    System.out.println("Multiply Double wrappers");
    return x * y;
  }
}
