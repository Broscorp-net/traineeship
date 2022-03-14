package net.broscorp.override.overload;

public interface MathOperation {

  /**
   *The override annotation is used to detect timely changes
   * in the method signature of an ancestor class or interface.
   */

  double mathOperation(double a, double b);

  double mathOperation(int c, int d);

  double mathOperation(Double e, Double f);
}
