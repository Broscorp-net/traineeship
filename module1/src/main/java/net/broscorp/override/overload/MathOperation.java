package net.broscorp.override.overload;

public interface MathOperation {

  double getMathOperation(double firstNumber, double secondNumber);
  double getMathOperation(int firstNumber, int secondNumber);
  double getMathOperation(Double firstNumber, Double secondNumber);
  double getMathOperation(Integer firstNumber, Integer secondNumber);

}
