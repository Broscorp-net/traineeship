package net.broscorp.override.overload;

public class MathAdding implements MathOperation {

  @Override
  public double operation(double x, double y) {
    return x + y;
  }

  @Override
  public double operation(Double x, Double y) {
    return x + y;
  }

  @Override
  public double operation(int x, int y) {
    return x + y;
  }

  @Override
  public double operation(Integer x, Integer y) {
    return x + y;
  }
}
