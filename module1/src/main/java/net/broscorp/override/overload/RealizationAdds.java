package net.broscorp.override.overload;

public class RealizationAdds implements MathOperation {

  /**
   * Назначение аннотации @Override:
   * она показывает что мы переопределяем данный метод,
   * вызывает ошибку компиляции / интерпретации, если метод
   * не найден в родительском классе или интерфейсе.
   * Также проверяет правильность переопределения:
   * модификатор доступа, параметры, возвращаемый тип.
   */
  @Override
  public double operation(double a, double b) {
    return a + b;
  }

  @Override
  public double operation(int a, int b) {
    return a + b;
  }

  @Override
  public double operation(Double a, Double b) {
    return a + b;
  }

  @Override
  public double operation(Integer a, Integer b) {
    return a + b;
  }
}
