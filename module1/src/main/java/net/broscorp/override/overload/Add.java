package net.broscorp.override.overload;

public class Add implements MathOperation {

  /**
   * Аннотация @Override показывает, что мы реализуем метод интерфейса. Или реализуем или
   * переопределяем метод абстрактного класса.
   * Если в метод передается класс обертка и примитив, тогда будет вызываться метод
   * с классом оберткой
   */

  @Override
  public double mathOperation(double c, double b) {
    return c + b;
  }

  public double mathOperation(int c, int b) {
    return c + b;
  }

  public double mathOperation(Double c, Double b) {
    return c + b;
  }

  public double mathOperation(Integer c, Integer b) {
    return c + b;
  }
}
