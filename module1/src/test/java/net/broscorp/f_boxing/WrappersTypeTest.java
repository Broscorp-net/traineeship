package net.broscorp.f_boxing;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class WrappersTypeTest {

    @Test
    void typeComparisonInt() {
        int a1 = 200;
        int a2 = 200;
        boolean expResult = false;
        boolean result = WrappersType.typeComparisonInt(a1, a2);
        assertEquals(expResult, result);
    }

    @Test
    void typeComparisonIntEquals() {
        int a1 = 300;
        int a2 = 300;
        boolean expResult = true;
        boolean result = WrappersType.typeComparisonIntEquals(a1, a2);
        assertEquals(expResult, result);
    }

    @Test
    void explicitBoxing() {
        int a1 = 400;
        int a2 = 400;
        boolean expResult = false;
        boolean result = WrappersType.explicitBoxing(a1, a2);
        assertEquals(expResult, result);
    }

    @Test
    void explicitUnboxing() {
        int a1 = 500;
        int a2 = 500;
        boolean expResult = true;
        boolean result = WrappersType.explicitUnboxing(a1, a2);
        assertEquals(expResult, result);
    }
}