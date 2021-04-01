package net.broscorp.override.overload;

/**
 * Аннотация @Override перед объявлением метода означает (в основном компилятору + читающим код
 * программистам), что далее мы собираемся переопределять метод базового класса. На переопределение
 * аннотация не влияет, но в случае отсутствия аннотации и не совпадения сигнатуры метода, появится
 * трудно уловимая ошибка.
 */
public class MathOperationImplAddition implements MathOperation {

  @Override
  public double method(double firstDouble, double secondDouble) {
    return firstDouble + secondDouble;
  }

  @Override
  public double method(int firstInt, int secondInt) {
    return firstInt + secondInt;
  }

  @Override
  public double method(Double firstDouble, Double secondDouble) {
    return firstDouble + secondDouble;
  }

  @Override
  public double method(Integer firstInt, Integer secondInt) {
    return firstInt + secondInt;
  }
}
