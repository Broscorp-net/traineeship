package net.broscorp.override.overload;

public class MultMathOperationImpl implements MathOperation {

  @Override
  public double operate(double firstDouble, double secondDouble) {
    System.out.println("Method with two doubles is called");
    return firstDouble * secondDouble;
  }

  @Override
  public double operate(int firstInt, int secondInt) {
    System.out.println("Method with two ints is called");
    return firstInt * secondInt;
  }

  @Override
  public double operate(Double firstDouble, Double secondDouble) {
    System.out.println("Method with two Doubles is called");
    return firstDouble * secondDouble;
  }

  @Override
  public double operate(Integer firstInteger, Integer secondInteger) {
    System.out.println("Method with two Integers is called");
    return firstInteger * secondInteger;
  }
}
