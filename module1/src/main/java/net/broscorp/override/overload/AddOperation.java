package net.broscorp.override.overload;

/**
 * @author O.P. Tataryn
 * Анотація @Override вказується перед методом,
 * який викликаний із батьківського класу, але він вже буде заміщеним методом у дочірному класі
 * тобто його реалізація та виконання відрізняється від такого самого методу у батьківському класі.
 * Щоб метод міг бути заміщеним потрібно щоб сигнатура методу була незмінною, індентичною, як у батьківськову класі
 *
 * */

public class AddOperation implements MathOperation{

  @Override
  public double getMathOperation(double firstNumber, double secondNumber) {
    System.out.println("double getMathOperation");

    return firstNumber + secondNumber;
  }

  @Override
  public double getMathOperation(int firstNumber, int secondNumber) {
    System.out.println("int getMathOperation");

    return firstNumber + secondNumber;
  }

  @Override
  public double getMathOperation(Double firstNumber, Double secondNumber) {
    System.out.println("Double getMathOperation");

    return firstNumber + secondNumber;
  }

  @Override
  public double getMathOperation(Integer firstNumber, Integer secondNumber) {
    System.out.println("Integer getMathOperation");
    return firstNumber + secondNumber;
  }

}
