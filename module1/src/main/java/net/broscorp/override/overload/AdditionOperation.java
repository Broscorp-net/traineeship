package net.broscorp.override.overload;

/** '@Override' annotation used to mark a method as a member declared in a superclass
 *  and overridden in a subclass.
 *  This is not required but it helps the compiler to prevent errors.
 *  If some method with the annotation cannot be overridden correctly, the compile will report it.
 */
public class AdditionOperation implements MathOperation {

  @Override
  public double calculate(double arg1, double arg2) {
    System.out.println("op: Add; type: double");
    return arg1 + arg2;
  }

  @Override
  public double calculate(int arg1, int arg2) {
    System.out.println("op: Add; type: int");
    return arg1 + arg1;
  }

  @Override
  public double calculate(Integer arg1, Integer arg2) {
    System.out.println("op: Add; type: Integer");
    return arg1 + arg2;
  }

  @Override
  public double calculate(Double arg1, Double arg2) {
    System.out.println("op: Add; type: Double");
    return arg1 + arg2;
  }
}
