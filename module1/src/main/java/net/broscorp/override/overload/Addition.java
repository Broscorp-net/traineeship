package net.broscorp.override.overload;

/**Аннотация @Override показывает, что данный метод переопределяет метод родителя/интерфейса.
   *Правило хорошего тона, помогает разобраться в коде,
   *на работу программы не влияет никак.
 */

public class Addition implements MathOperation {

  @Override
  public double calculate(double d1, double d2) {
    System.out.println("calculate(double d1, double d2)");
    return d1 + d2;
  }

  @Override
  public double calculate(Double d1, Double d2) {
    System.out.println("calculate(Double d1, Double d2)");
    return d1 + d2;
  }

  @Override
  public double calculate(int i1, int i2) {
    System.out.println("calculate(int i1, int i2)");
    return i1 + i2;
  }

  @Override
  public double calculate(Integer i1, Integer i2) {
    System.out.println("calculate(Integer i1, Integer i2)");
    return i1 + i2;
  }
}
