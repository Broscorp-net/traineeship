package net.broscorp.override.overload;

public class MathOperationAdd implements MathOperation {

  /***
   *<p>Override - наделение метода своей реализацией по отношению к реализации родителя.
   * При этом сигнатура остается не изменной, отличается только внутренняя реализация.</p>
   */
  @Override
  public double twoDoubles(double one, double two) {
    return one + two;
  }

  @Override
  public double twoDoubles(int one, int two) {
    return one + two;
  }

  @Override
  public double twoDoubles(Integer one, Integer two) {
    return one.doubleValue() + two.doubleValue();
  }
}
