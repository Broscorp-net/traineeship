package net.broscorp.m_override_overload;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class AdditionValueTest {

    private AdditionValue additionValue = new AdditionValue();

    @Test
    void testReturnValue() {
        double d1 = 0.44;
        double d2 = 0.55;
        assertEquals(0.99, additionValue.returnValue(d1, d2));
    }

    @Test
    void testReturnValueInt() {
        int d1 = 44;
        int d2 = 55;
        assertEquals(99, additionValue.returnValue(d1, d2));
        assertEquals(99.0, additionValue.returnValue(d1, d2)); // и (99.0) прокатит
    }

    @Test
    void testReturnValueInteger() {
        Integer d1 = 44;
        Integer d2 = 55;
        assertEquals(99, additionValue.returnValue(d1, d2));
        assertEquals(99.0, additionValue.returnValue(d1, d2));
    }

    @Test
    void testReturnValueDouble() {
        Double d1 = 0.44;
        Double d2 = 0.55;
        assertEquals(0.99, additionValue.returnValue(d1, d2));
    }

    /**
     * При попадании в метод обертки с примитивом, происходит ошибка компиляции "Ambiguous method call"
     * Вызов метода (двусмысленный) с разными типами параметров
     */
    /*@Test
    void testReturnValuePrimitiveAndObject() {
        int d1 = 44;
        Integer d2 = 55;
        assertEquals(99, additionValue.returnValue(d1, d2));
    }*/
}