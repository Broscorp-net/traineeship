package net.broscorp.override.overload;

/**
 * The @Override annotation should be placed before the overridden method in order to: 1) reader of
 * the code could see that this is an overridden method of the parent type; 2) compiler and IDE
 * could compare declaration of method (parameters, access modifiers, return value) with the
 * declaration of original method from the parent class and not allow to compile if there was an
 * error, because if the declaration is incorrect, then method will not an overridden, but an
 * overloaded or new method. The programmer may not notice this and a subtle error will appear that
 * will be difficult to identify. On the absence of this annotation does not affect the work of the
 * code.
 */
public class AddMathOperationImpl implements MathOperation {

  @Override
  public double operate(double firstDouble, double secondDouble) {
    System.out.println("Method with two doubles is called");
    return firstDouble + secondDouble;
  }

  @Override
  public double operate(int firstInt, int secondInt) {
    System.out.println("Method with two ints is called");
    return firstInt + secondInt;
  }

  @Override
  public double operate(Double firstDouble, Double secondDouble) {
    System.out.println("Method with two Doubles is called");
    return firstDouble + secondDouble;
  }

  @Override
  public double operate(Integer firstInteger, Integer secondInteger) {
    System.out.println("Method with two Integers is called");
    return firstInteger + secondInteger;
  }
}
