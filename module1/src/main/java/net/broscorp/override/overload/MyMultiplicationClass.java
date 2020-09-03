package net.broscorp.override.overload;

public class MyMultiplicationClass implements MathOperation {
  String method;

  @Override
  public double operation(double first, double second) {
    this.method = "Это два double";
    return first * second;
  }

  @Override
  public double operation(int first, int second) {
    this.method = "Это два int";
    return first * second;
  }

  @Override
  public double operation(Integer first, Integer second) {
    this.method = "Это два Integer";
    return first * second;
  }

  @Override
  public double operation(Double first, Double second) {
    this.method = "Это два Double";
    return first * second;
  }
}
