package net.broscorp.override.overload;

/**
 * Overriding - using a method from a class or interface of an ancestor, provided that the return
 * type and method parameters do not change. I use this annotation for acquire functionality in a
 * class inheriting from its ancestor class or interface.
 */
public interface MathOperation {

  double doCalc(double x, double y);

  double doCalc(int x, int y);

  double doCalc(Integer x, Integer y);

  double doCalc(Double x, Double y);
}
