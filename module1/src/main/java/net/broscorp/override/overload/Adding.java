package net.broscorp.override.overload;

public class Adding implements MathOperation {

  /**
   * Аннотация @Override: показывает что метод с одинаковой сигнатурой имеет другую
     * реализацию, нежели метод класса, откуда этот метод унаследовался.
   */

  @Override
  public double operation(double a, double b) {
    return a + b;
  }

  @Override
  public double opetation(int a, int b) {
    return a + b;
  }

  @Override
  public double opetation(Double a, Double b) {
    return a + b;
  }

  @Override
  public double opetation(Integer a, Integer b) {
    return a + b;
  }
}
