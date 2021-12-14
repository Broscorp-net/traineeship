package net.broscorp.override.overload;

public class MultiplicationOperation implements MathOperation{

  @Override
  public double getMathOperation(double firstNumber, double secondNumber) {
    return firstNumber * secondNumber;
  }

  @Override
  public double getMathOperation(int firstNumber, int secondNumber) {
    return firstNumber * secondNumber;
  }

  @Override
  public double getMathOperation(Double firstNumber, Double secondNumber) {
    return firstNumber * secondNumber;
  }

  @Override
  public double getMathOperation(Integer firstNumber, Integer secondNumber) {
    return firstNumber * secondNumber;
  }
}
