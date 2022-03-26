package net.broscorp.override.overload;

public class Multiplication implements MathOperation {

  /**
   * Summary. @Override annotation is mainly used for two purposes. Firstly, it declares our method
   * as overriden. So, for example, if we accidentally name it the wrong way or something else goes
   * wrong during the implementetation - we get a compile time error, because we basically signed a
   * contract "This method would override something". Second: @Override improves code readability.
   */
  @Override
  public double arithmeticOperation(double x, double y) {
    System.out.println("Primitive double version is called!");
    return x * y;
  }

  @Override
  public double arithmeticOperation(int x, int y) {
    System.out.println("Primitive int version is called!");
    return x * y;
  }

  @Override
  public double arithmeticOperation(Integer x, Integer y) {
    System.out.println("Wrapper Integer version is called!");
    return x * y;
  }

  @Override
  public double arithmeticOperation(Double x, Double y) {
    System.out.println("Wrapper Double version is called!");
    return x * y;
  }



}