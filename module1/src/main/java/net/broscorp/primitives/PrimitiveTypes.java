package net.broscorp.primitives;

/**
 * Class содержит методы для демонстрации работы с примитивными типами
 *
 * @author Volodymyr Lopachak
 * @version 1.0
 */
public class PrimitiveTypes {

    /**
     * Method отображает перемолнение стека
     *
     * @return результат сложения
     */
    public byte overflow() {
        byte b = 120;
        return b += 20;
    }

    /**
     * Method отображает приведение типов с усеченим значения
     *
     * @return усечённое число типа int
     */
    public int longTransformation() {
        long longData = 22_000_000_000L;
        return (int) longData;
    }

  /**
   * Method отображает приведение типов с усеченим значения
   *
   * @return усечённое число типа int
   */
    public int doubleTruncation() {
        double doubleData = 56.9898;
        return (int) doubleData;
    }

    /**
     * Method демонстрирует проблемму приведения double в float
     *
     * @return приведённое значение типа float
     */
    public float doubleTransformation(double doubleData) {
        return (float) doubleData;
    }

    /**
     * Method демонстрирует результат сложения 2-х чисел и сравнения их о ожидаемым результатом
     *
     * @return true or false
     */
    public boolean floatingPointNumbers(float f1, float f2, float result) {
        return ((f1 + f2) == result);
    }

    /**
     * Method возвращает разницу 2-х чисел типа  double
     *
     * @return разницу 2-х чисел
     */
    public double doubleSum(double d1, double d2) {
        return d1 - d2;
    }

    /**
     * Method высчитывает сумму 10-ти чисел типа double
     *
     * @return результат вычисления
     */
    public double loopDoubleSum() {
        double d = .0;
        for (int i = 0; i < 10; i++) {
            d += 0.1;
        }
        return d;
    }

  /**
   * Method высчитывает сумму 10-ти чисел типа float
   *
   * @return результат вычисления
   */
    public float loopFloatSum() {
        float f = .0F;
        for (int i = 0; i < 10; i++) {
            f += 0.1F;
        }
        return f;
    }
}
