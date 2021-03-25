package net.broscorp.override.overload;

/**
 * Аннотация @Override следит за тем чтобы мы ПЕРЕОПРЕДИЛИЛИ (override) метод,
 * а не ПЕРЕГРУЗИЛИ (overload) его.
 * Если в родительском классе или интерфейсе не окажется метода с аналогичной сигнатурой, то
 * получим предупреждение компилятора.
 * @author Hryhorii Perets
 * @version 1.0
 */
public class MathOperationMultiplication implements MathOperation {


  @Override
  public double mathOperation(double num1, double num2) {
    return num1 * num2;
  }

  @Override
  public double mathOperation(int num1, int num2) {
    return num1 * num2;
  }

  @Override
  public double mathOperation(Double num1, Double num2) {
    return num1 * num2;
  }

  @Override
  public double mathOperation(Integer num1, Integer num2) {
    return num1 * num2;
  }

}
