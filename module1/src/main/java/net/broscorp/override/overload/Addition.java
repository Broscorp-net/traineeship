package net.broscorp.override.overload;

public class Addition implements MathOperation {

  /**
   * Though @Override is not mandatory it serves for several purposes. They are:
   * <ul>
   *   <li>Informs the compiler that the method overrides parent class method.</li>
   *   <li>Helps eliminate errors if parent class method will be incorrectly overridden.
   *   In this even compiler generates error</li>
   *   <li>Makes code easier to understand</li>
   * </ul>
   */

  @Override
  public double doMathOperation(double a, double b) {
    return a + b;
  }

  @Override
  public double doMathOperation(int a, int b) {
    return a + b;
  }

  @Override
  public double doMathOperation(Double a, Double b) {
    return a + b;
  }

  @Override
  public double doMathOperation(Integer a, Integer b) {
    return a + b;
  }
}
