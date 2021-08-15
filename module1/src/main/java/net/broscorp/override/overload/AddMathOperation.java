package net.broscorp.override.overload;

public class AddMathOperation implements MathOperation {

  @Override
  public double someOperation(double var1, double var2) {
    System.out.println("First argument - double, second - double ");
    return var1 + var2;
  }

  @Override
  public double someOperation(int var1, int var2) {
    System.out.println("First argument - int, second - int ");
    return var1 + var2;
  }

  @Override
  public double someOperation(Integer var1, Integer var2) {
    System.out.println("First argument - Integer, second - Integer ");
    return var1 + var2;
  }

}
