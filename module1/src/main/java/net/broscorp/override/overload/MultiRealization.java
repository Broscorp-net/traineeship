package net.broscorp.override.overload;

public class MultiRealization implements MathOperation {

  @Override
  public double doubleMethod(double first, double second) {
    return first * second;
  }

  @Override
  public double doubleMethod(int first, int second) {
    return first * second;
  }

  @Override
  public double doubleMethod(Integer first, Integer second) {
    return first * second;
  }
}
