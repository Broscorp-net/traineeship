package net.broscorp.f_boxing;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class WrappersTypeTest {

    @Test
    void typeComparisonInt() {
        Integer a1 = 200;
        Integer a2 = 200;
        boolean result = a1 == a2;
        assertNotEquals(true, result);
    }

    @Test
    void typeComparisonIntEquals() {
        Integer a1 = 300;
        Integer a2 = 300;
        boolean result = a1.equals(a2);
        assertTrue(result);
    }

    @Test
    void explicitBoxing() {
        Integer a1 = new Integer(400);
        Integer a2 = new Integer(400);
        boolean result = a1 == a2;
        assertNotEquals(true, result);
    }

    /**
     * При "распаковке" происходит сравнение примитивных значений, поэтому результат true
     */
    @Test
    void explicitUnboxing() {
        Integer a1 = new Integer(500);
        Integer a2 = new Integer(500);
        boolean result = a1.intValue() == a2.intValue();
        assertTrue(result);
    }

}