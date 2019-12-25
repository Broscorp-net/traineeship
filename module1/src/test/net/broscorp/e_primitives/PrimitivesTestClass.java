package net.broscorp.e_primitives;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class PrimitivesTestClass {
    @Test
    void primitiveTypeOverflow() {
        byte a = 127;
        a++;
        byte b = -128;
        assertEquals(a, b);
    }

    @Test
    void convertingBetweenLongInt() {
        long l = 1_000_000_000_000_000L;
        int i = (int) l;
        System.out.println("in this case i equals " + i);
        assertTrue(l != i);
    }

    @Test
    void convertingBetweenDoubleFloat() {
        double d = 1_000_000_000_000_000.0;
        float s = (float) d;
        System.out.println("in this case s equals " + s);
        assertTrue(s != d);
    }

    @Test
    void convertingBetweenIntLong() {
        int i = 2_000_000_000;
        long l = i;
        assertEquals(l, i);
    }

    @Test
    void convertingBetweenFloatDouble() {
        float s = 32767;
        double d = s;
        assertEquals(s, d);
    }

    @Test
    void accuracyOfFloatingPointTypes() {
        float a = 4.0f;
        float b = 2.1f;
        assertNotEquals(1.9f, a - b);
    }
}
