package net.broscorp.override.overload;

/**
 * анотация указывает что метод переопределяеться с наследуемого класса или интерфейса.
 * также указывает что этот метод относиься именно к наследуемому классу или интерфейсу а не перегружаеться внутри класса
 * также анотация облегчает определить ошибку при переопределении метода
 */
public class SumImplementation implements MathOperation {
  @Override
  public double operation(double a, double b) {
    return a + b;
  }

  @Override
  public double operation(int a, int b) {
    return (double) (a + b);
  }

  @Override
  public double operation(Integer a, Integer b) {
    return Double.valueOf(a + b);
  }

  @Override
  public double operation(Double a, Double b) {
    return a + b;
  }
}
