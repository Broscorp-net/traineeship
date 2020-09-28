package net.broscorp.override.overload;

public interface MathOperation {

  /**
   * Override аннотация(@Override) используется для переопределении методов в калссах наследниках.
   * Например, equals & hashcode методы из класса Object(все объекты неявно являются его
   * наследниками).
   */
  double operation(double x, double y);

  double operation(Double x, Double y);

  double operation(int x, int y);

  double operation(Integer x, Integer y);
}
