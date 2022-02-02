package net.broscorp.boxing;

/**
 * Class содержит методы для демонстации работы обёрток примитивных типов
 *
 * @author Volodymyr Lopachak
 * @version 1.0
 */
public class BoxingWrappers {

    /**
     * Метод сравниевает по значению 2 параметра типа Integer
     *
     * @param i1 - параметр типа Integer
     * @param i2 - параметр типа Integer
     * @return true or false
     */
    public boolean comparisonInteger(Integer i1, Integer i2) {
        return i1 == i2;
    }

    /**
     * Метод сравниевает по значению 2 параметра типа Float
     *
     * @param f1 - параметр типа Float
     * @param f2 - параметр типа Float
     * @return true or false
     */
    public boolean comparisonFloat(Float f1, Float f2) {
        return f1 == f2;
    }

    /**
     * Метод возвращает результат типа double
     *
     * @param d - параметер типа Double
     * @return - переприсвоенное значение типа  double
     */
    public double appropriation(Double d) {
        double result = d;
        return result;
    }
}
