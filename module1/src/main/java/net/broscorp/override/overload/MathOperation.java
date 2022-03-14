package net.broscorp.override.overload;

public interface MathOperation {

  /**
   * Override обозначает метод, который переопределяется из суперкласса
   * или интерфейса. Т.е. сигнатура остается неизменной, но метод может измениться.
   * <p></p>
   * Метод с двумя разными типами переменных вызвался для Double и int. Double неявно
   * преобразовывается в int.

  /**
   * sum with doubles.
   * @param first double
   * @param second double
   * @return double
   */
  double calculate(double first, double second);

  /**
   * sum with integers.
   * @param first int
   * @param second int
   * @return double
   */
  double calculate(int first, int second);

  /**
   * sum with boxing integers.
   * @param first Integer
   * @param second Integer
   * @return double
   */
  double calculate(Integer first, Integer second);

  /**
   * sum with boxing doubles.
   * @param first Double
   * @param second Double
   * @return double
   */
  double calculate(Double first, Double second);
}
