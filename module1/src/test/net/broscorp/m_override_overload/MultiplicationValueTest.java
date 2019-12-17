package net.broscorp.m_override_overload;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class MultiplicationValueTest {

    private MultiplicationValue multiplicationValue = new MultiplicationValue();

    @Test
    void returnValue() {
        double d1 = 0.4;
        double d2 = 0.5;
        assertEquals(0.2, multiplicationValue.returnValue(d1, d2));
    }

    @Test
    void testReturnValueInt() {
        int d1 = 4;
        int d2 = 5;
        assertEquals(20, multiplicationValue.returnValue(d1, d2));
        assertEquals(20.0, multiplicationValue.returnValue(d1, d2));
    }

    @Test
    void testReturnValueInteger() {
        Integer d1 = 4;
        Integer d2 = 5;
        assertEquals(20, multiplicationValue.returnValue(d1, d2));
        assertEquals(20.0, multiplicationValue.returnValue(d1, d2));
    }

    @Test
    void testReturnValueDouble() {
        Double d1 = 0.4;
        Double d2 = 0.5;
        assertEquals(0.2, multiplicationValue.returnValue(d1, d2));
    }

    /**
     * При попадании в метод обертки с примитивом, происходит ошибка компиляции "Ambiguous method call"
     * Вызов метода (двусмысленный) с разными типами параметров
     */
    /*@Test
    void testReturnValuePrimitiveAndObject() {
        double d1 = 0.4;
        Double d2 = 0.5;
        assertEquals(0.2, multiplicationValue.returnValue(d1, d2));
    }*/
}