package net.broscorp.m_override_overload;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

/**
 * @Override annotation is use in order to implement methods from interface which have no realisation
 * (they are abstract)
 * The annotation points that we will override methods from the parent class or interface. We can override methods
 * without this annotation
 */

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
        assertEquals(5.0, calculatorAdd.operation(a, b));
    }

    @Test
    void sumDOUBLE() {
        Double a = 2.0;
        Double b = 2.0;
        assertEquals(4.0, calculatorAdd.operation(a, b));
    }

    @Test
    void sumInt() {
        int a = 2;
        int b = 3;
        assertEquals(5, calculatorAdd.operation(a, b));
    }

    @Test
    void sumINTEGER() {
        Integer a = 2;
        Integer b = 22;
        assertEquals(24, calculatorAdd.operation(a, b));
    }

    @Test
    void multiplyDouble() {
        double a = 2.0;
        double b = 3.0;
        assertEquals(6.0, calculatorMultiply.operation(a, b));
    }

    @Test
    void multiplyDOUBLE() {
        Double a = 2.0;
        Double b = 5.0;
        assertEquals(10.0, calculatorMultiply.operation(a, b));
    }

    @Test
    void multiplyInt() {
        int a = 2;
        int b = 3;
        assertEquals(6, calculatorMultiply.operation(a, b));
    }

    @Test
    void multiplyINTEGER() {
        Integer a = 2;
        Integer b = 22;
        assertEquals(44, calculatorMultiply.operation(a, b));
    }

    /*@Test
    void mixedTypes() {
        Integer a = 5;
        int b = 3;
        assertEquals(15, calculatorMultiply.operation(a, b));
        We will have here compilation mistake
        The output will be Error:(83, 44) java: reference to operation is ambiguous
  both method operation(int,int) in net.broscorp.m_override_overload.MathOperation
  and method operation(java.lang.Integer,java.lang.Integer) in net.broscorp.m_override_overload.MathOperation match
  Because there is no such method which has mixed types of parameters
    }*/
}
