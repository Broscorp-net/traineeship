package net.broscorp.f_boxing;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class WrappersTypeTest {

    @Test
    void typeComparisonInt() {
        Integer a1 = 150;
        Integer a2 = 150;
        boolean expResult = false;
        boolean result = WrappersType.typeComparisonInt(a1, a2);
        assertEquals(expResult, result);
    }

    @Test
    void typeComparisonIntEquals() {
        Integer a1 = 300;
        Integer a2 = 300;
        boolean expResult = true;
        boolean result = WrappersType.typeComparisonIntEquals(a1, a2);
        assertEquals(expResult, result);
    }
}