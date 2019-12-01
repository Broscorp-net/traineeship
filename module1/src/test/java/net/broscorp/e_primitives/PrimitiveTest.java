package net.broscorp.e_primitives;

import org.junit.jupiter.api.Test;

import static jdk.nashorn.internal.objects.Global.Infinity;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;

class PrimitiveTest {

    private Primitive primitive = new Primitive();

    @Test
    void overflowByteAddition() {
        int a = 100;
        int b = 50;
        int expResult = -106;
        int result = primitive.overflowByte(a, b);
        assertEquals(expResult, result);
    }

    @Test
    void overflowShortAddition() {
        int a = Short.MAX_VALUE;
        int b = Short.MAX_VALUE;
        int expResult = -2;
        int result = primitive.overflowShort(a, b);
        assertEquals(expResult, result);
    }

    @Test
    void overflowIntAddition() {
        int a = Integer.MAX_VALUE;
        int b = Integer.MAX_VALUE;
        int expResult = -2;
        int result = primitive.overflowInt(a, b);
        assertEquals(expResult, result);
    }

    @Test
    void overflowLongAddition() {
        long a = Long.MAX_VALUE;
        long b = Long.MAX_VALUE;
        long expResult = -2;
        long result = primitive.overflowLong(a, b);
        assertEquals(expResult, result);
    }

    @Test
    void overflowFloatAddition() {
        float a = Float.MAX_VALUE;
        float b = Float.MAX_VALUE;
        float expResult = (float) Infinity;
        float result = primitive.overflowFloat(a, b);
        assertEquals(expResult, result);
    }

    @Test
    void overflowDoubleAddition() {
        double a = Double.MAX_VALUE;
        double b = Double.MAX_VALUE;
        double expResult = Infinity;
        double result = primitive.overflowDouble(a, b);
        assertEquals(expResult, result);
    }

    @Test
    void convertLongToIntAddition() {
        long a = Long.MAX_VALUE;
        long b = 0;
        int expResult = -1;
        int result = primitive.convertLongToInt(a, b);
        assertEquals(expResult, result);
    }

    @Test
    void convertFloatToDoubleAddition() {
        float a = Float.MAX_VALUE;
        float b = 0;
        double expResult = 3.4028234663852886E38;
        double result = primitive.convertFloatToDouble(a, b);
        assertEquals(expResult, result);
    }

    @Test
    void inaccuracyFloat() {
        float f1 = 0.6f;
        float f2 = 0.3f;
        float expResult = 0.9f;
        float result = primitive.inaccuracyFloat(f1, f2);
        assertNotEquals(expResult, result);
    }

    @Test
    void inaccuracyDouble() {
        double f1 = 0.6;
        double f2 = 0.3;
        double expResult = 0.9;
        double result = primitive.inaccuracyDouble(f1, f2);
        assertNotEquals(expResult, result);
    }
}