package net.broscorp.override.overload;

public class Addition implements MathOperation {


  public double doMathOperation(double a, double b){
    return a+b;
  }


  public double doMathOperation(int a, int b) {
    return (double) a+b;
  }

  public double doMathOperation(Double a, Double b){
    return a+b;
  }

  public double doMathOperation(Integer a, Integer b){
    return (double) a+b;
  }

}
