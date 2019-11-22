package net.broscorp.m_override_overload;

/**
 * Override - переопределение метода - это возможность подклассу иметь специфическую реализацию
 * родительского метода. Поставленая над методом анотация @Override сообщает компилятору что этот
 * метод переопределен и сообщает так же читающим код программистам.
 * Есть ряд ограничений:
 * 1. Перерпеделенный метод должен иметь те же аргументы что и метод родительского класса.
 * 2. Переопределегный метод должен иметь такой же тип возвращаемого значения
 * что и метод родителдьского класса.
 * 3. Модификатор доступа не может быть более ограничен чем в методе родительского класса.
 * 4.Методы final не могут быть переопределены.
 * 5.Конструкторы нельзя переопределять.
 */
public class MathOperationSum implements MathOperation {

  @Override
  public double operation(double a, double b) {
    return a + b;
  }

  @Override
  public int operation(int a, int b) {
    return a + b;
  }

  @Override
  public Integer operation(Integer a, Integer b) {
    return a + b;
  }

  @Override
  public Double operation(Double a, Double b) {
    return a + b;
  }

  public Double operation(Double a, double b) {
    return a + b;
  }
}
