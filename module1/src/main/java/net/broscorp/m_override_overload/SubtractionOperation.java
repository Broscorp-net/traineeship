package net.broscorp.m_override_overload;

public class SubtractionOperation implements MathOperation {
    @Override
    public double operation(double f_value, double s_value) {
        return f_value - s_value;
    }

    @Override
    public double operation(int f_value, int s_value) {
        return (double) f_value - s_value;
    }

    @Override
    public double operation(Integer f_value, Integer s_value) {
        return (double) f_value - s_value;
    }
}
