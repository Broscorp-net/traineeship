package net.broscorp.override.overload;

/**
 * The Override annotation shows the compiler and developer the method overridden.
 */
public class MathMultiply implements MathOperation {
  @Override
  public double consumes(double var1, double var2) {
    return var1 * var2;
  }

  @Override
  public double consumes(int var1, int var2) {
    return (double) var1 * var2;
  }

  @Override
  public double consumes(Integer var1, Integer var2) {
    return (double) var1 * var2;
  }

  @Override
  public double consumes(Double var1, Double var2) {
    return var1 * var2;
  }
}
