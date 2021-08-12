package net.broscorp.override.overload;

public class MathOperationImplMultiple implements MathOperation {

  /**
   * Override - аннотация, задача которой проверить, является ли метод переопределенным из класса
   * родителя или реализованного интерфейса. Сама проверка происходит за счет сравнения сигнатуры
   * методов. Переопределение методов относится к одному из проявлений полиморфизма.
   */

  @Override
  public double operationMethod(double first, double second) {
    return first * second;
  }

  @Override
  public double operationMethod(int first, int second) {
    return first * second;
  }

  @Override
  public double operationMethod(Double first, Double second) {
    return first * second;
  }

  @Override
  public double operationMethod(Integer first, Integer second) {
    return first * second;
  }
}
