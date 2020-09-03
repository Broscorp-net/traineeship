package net.broscorp.override.overload;

/**
 * Override.
 * Аннотация @Override обозначает, что мы переопределяем метод
 * класса-родителя или интерфейса. То есть, реализуем метод в
 * том виде, в котором его нужно использовать в этом классе.
 * При переопределении сигнатура метода остается такой же,
 * как и была изначально.
 * Если изменяется сигнатура, то это перегрузка метода.
 */
public class MyAdditionClass implements MathOperation {
  String method;

  @Override
  public double operation(double first, double second) {
    this.method = "Это два double";
    return first + second;
  }

  @Override
  public double operation(int first, int second) {
    this.method = "Это два int";
    return first + second;
  }

  @Override
  public double operation(Integer first, Integer second) {
    this.method = "Это два Integer";
    return first + second;
  }

  @Override
  public double operation(Double first, Double second) {
    this.method = "Это два Double";
    return first + second;
  }
}
