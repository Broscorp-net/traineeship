package net.broscorp.e_primitives;

import org.junit.jupiter.api.Test;

import static jdk.nashorn.internal.objects.Global.Infinity;
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
    void overflowIntTest() {
        int l = Integer.MAX_VALUE;
        l++;
        int i = -2147483648;
        assertEquals(l, i);
    }

    @Test
    void overflowShortTest() {
        short a = Short.MAX_VALUE;
        a++;
        short b = -32768;
        assertEquals(b, a);
    }

    @Test
    void overflowFloatTest() {
        //in a case when float is overflow we will have infinity
        float f = Float.MAX_VALUE;
        float result = f + 0.34e39F;
        assertEquals(Infinity, result);
    }

    @Test
    void convertLongToInt() {
        long l = Integer.MAX_VALUE + 1L;
        int i = (int) l;
        assertEquals(-2147483648, i);
    }

    @Test
    void convertingBetweenDoubleFloat() {
        double d = 1_000_000_000_000_000.0;
        float s = (float) d;
        assertEquals(s, 9.99999986991104E14);
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
        /**
         * In order to avoid  problems with accuracy we can use
         *  strictfp
         *  BigInteger & BigDecimal
         *  */
        float a = 4.0f;
        float b = 2.1f;
        float actual = a - b;
        assertEquals(1.9000000953674316, actual);
    }
}
