package net.broscorp.override.overload;

public interface MathOperation {

  double doMathOperation(double a, double b);

  double doMathOperation(int a, int b);

  double doMathOperation(Double a, Double b);

  double doMathOperation(Integer a, Integer b);

}
