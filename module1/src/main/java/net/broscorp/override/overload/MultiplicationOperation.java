package net.broscorp.override.overload;

public class MultiplicationOperation implements MathOperation {

  @Override
  public double calculate(double arg1, double arg2) {
    System.out.println("op: Mul; type: double");
    return arg1 * arg2;
  }

  @Override
  public double calculate(int arg1, int arg2) {
    System.out.println("op: Mul; type: int");
    return arg1 * arg2;
  }

  @Override
  public double calculate(Integer arg1, Integer arg2) {
    System.out.println("op: Mul; type: Integer");
    return arg1 * arg2;
  }

  @Override
  public double calculate(Double arg1, Double arg2) {
    System.out.println("op: Mul; type: Double");
    return arg1 * arg2;
  }
}
