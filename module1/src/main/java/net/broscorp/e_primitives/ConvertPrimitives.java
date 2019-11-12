package net.broscorp.e_primitives;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class ConvertPrimitives {

    @Test(expected = ArithmeticException.class)
    public void testConvertLongToInt() {
        long value = Long.MAX_VALUE;
        int result = Math.toIntExact(value);
    }

    @Test
    public void testConvertFloatToDouble() {
        double value = 9.000000000555555E9;
        float result = (float) value;
        assertEquals(9.000000512E9, result, 0);
    }
}
