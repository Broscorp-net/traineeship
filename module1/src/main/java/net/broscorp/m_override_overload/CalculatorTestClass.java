package net.broscorp.m_override_overload;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

/*@Override annotation is use in order to implement methods from interface which have no realisation
(they are abstract) */

public class CalculatorTestClass {
    MathOperation calculatorMultiply;
    MathOperation calculatorAdd;

    @BeforeEach
    void init() {
        calculatorMultiply = new MultiplyClass();
        calculatorAdd = new AddingClass();
    }

    @Test
    void sumDouble() {
        double a = 2.0;
        double b = 3.0;
        double actual = calculatorAdd.operation(a, b);
        assertEquals(5.0, actual);
    }

    @Test
    void sumDOUBLE() {
        Double a = 2.0;
        Double b = 2.0;
        double actual = calculatorAdd.operation(a, b);
        assertEquals(4.0, actual);
    }

    @Test
    void sumInt() {
        int a = 2;
        int b = 3;
        double actual = calculatorAdd.operation(a, b);
        assertEquals(5, actual);
    }

    @Test
    void sumINTEGER() {
        Integer a = 2;
        Integer b = 22;
        double actual = calculatorAdd.operation(a, b);
        assertEquals(24, actual);
    }

    @Test
    void multiplyDouble() {
        double a = 2.0;
        double b = 3.0;
        double actual = calculatorMultiply.operation(a, b);
        assertEquals(6.0, actual);
    }

    @Test
    void multiplyDOUBLE() {
        Double a = 2.0;
        Double b = 5.0;
        double actual = calculatorMultiply.operation(a, b);
        assertEquals(10.0, actual);
    }

    @Test
    void multiplyInt() {
        int a = 2;
        int b = 3;
        double actual = calculatorMultiply.operation(a, b);
        assertEquals(6, actual);
    }

    @Test
    void multiplyINTEGER() {
        Integer a = 2;
        Integer b = 22;
        double actual = calculatorMultiply.operation(a, b);
        assertEquals(44, actual);
    }

    @Test
    void mixedTypes() {
        Integer a = 5;
        int b = 3;
        int actual = a * b;
        assertEquals(15, actual);
    }

}
