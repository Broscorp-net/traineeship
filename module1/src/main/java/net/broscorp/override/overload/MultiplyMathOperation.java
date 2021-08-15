package net.broscorp.override.overload;

public class MultiplyMathOperation implements MathOperation{

  @Override
  public double someOperation(double var1, double var2) {
    System.out.print("return double var1 * double var2 = ");
    return var1*var2;
  }

  @Override
  public double someOperation(int var1, int var2) {
    System.out.print("return int var1 * int var2 = ");
    return var1*var2;
  }

  @Override
  public double someOperation(Integer var1, Double var2) {
    return 0;
  }

}
