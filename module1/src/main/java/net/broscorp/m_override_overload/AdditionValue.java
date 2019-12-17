package net.broscorp.m_override_overload;

/**
 * (@Override) аннотация показывает, что метод переопределен (из интерфейса или класса-родителя).
 * Необходима для написания своей реализации метода в классах-потомках.
 */
public class AdditionValue implements MathOperation {

    @Override
    public double returnValue(double d1, double d2) {
        return d1 + d2;
    }

    @Override
    public double returnValue(int d1, int d2) {
        return d1 + d2;
    }

    @Override
    public double returnValue(Integer d1, Integer d2) {
        return d1 + d2;
    }

    @Override
    public double returnValue(Double d1, Double d2) {
        return d1 + d2;
    }

}
