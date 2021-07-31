package net.broscorp.override.overload;

public class MathAddition implements MathOperation {

  @Override
  public double doCalc(int x, int y) {
    System.out.println("Addition int primitives");
    return x + y;
  }

  @Override
  public double doCalc(double x, double y) {
    System.out.println("Addition double primitives");

    return x + y;
  }

  @Override
  public double doCalc(Integer x, Integer y) {
    System.out.println("Addition Integer wrappers");
    return x + y;
  }

  @Override
  public double doCalc(Double x, Double y) {
    System.out.println("Addition Double wrappers");
    return x + y;
  }
}
