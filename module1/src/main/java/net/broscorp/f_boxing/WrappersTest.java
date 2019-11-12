package net.broscorp.f_boxing;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class WrappersTest {
    @Test
    void testIntegerNotEquals() {
        Integer value1 = new Integer(1);
        Integer value2 = new Integer(1);

        boolean result = value1 == value2;

        assertFalse(result);
    }

    @Test
    void testIntegerEquals() {
        Integer value1 = new Integer(200);
        Integer value2 = new Integer(200);

        boolean result = value1.equals(value2);

        assertTrue(result);
    }

    @Test
    void testIntPrimitivesEquals() {
        int value1 = 1;
        int value2 = 1;

        boolean result = value1 == value2;

        assertTrue(result);
    }
}
