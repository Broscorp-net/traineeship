package net.broscorp.override.overload;

public class Adding implements MathOperation {

  /**
   * Аннотация @Override: показывает что метод с одинаковой сигнатурой и количеством и типом вводных
   * данных имеет другую реализацию, нежели метод класса, откуда этот метод унаследовался. В ходе
   * теста, где на вход метода передаются класс обётка и примитив, вызывается метод с классами
   * обёртками.
   */

  @Override
  public double operation(double a, double b) {
    return a + b;
  }

  public double opetation(int a, int b) {
    return a + b;
  }

  public double opetation(Double a, Double b) {
    return a + b;
  }

  public double opetation(Integer a, Integer b) {
    return a + b;
  }
}
