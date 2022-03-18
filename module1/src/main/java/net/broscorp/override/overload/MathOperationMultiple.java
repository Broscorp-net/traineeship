package net.broscorp.override.overload;

/**
 * При наследовании любой класс может переопределять методы, которые унаследованы
 * от базового класса или интерфейса. Для переопределения указывается
 * аннотация @Override.
 * Модификатор доступа должен быть такой же, как super-классе.
 * А с помощью super мы можем использовать реализацию метода из super-класса.
 */
public class MathOperationMultiple implements MathOperation {

  @Override
  public double mathOperation(double a, double b) {
    return a * b;
  }

  @Override
  public double mathOperation(int a, int b) {
    return (double) a * b;
  }

  @Override
  public double mathOperation(Double a, Double b) {
    return a.doubleValue() * b.doubleValue();
  }

  @Override
  public double mathOperation(Integer a, Integer b) {
    return a.doubleValue() * b.doubleValue();
  }
}
