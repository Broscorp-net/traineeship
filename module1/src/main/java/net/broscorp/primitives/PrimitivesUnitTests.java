package net.broscorp.primitives;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class PrimitivesUnitTests {

    @Test
    public void overflowInt() {
        int maxValue = Integer.MAX_VALUE;
        int minValue = Integer.MIN_VALUE;
        Assertions.assertEquals(++maxValue, minValue);
    }

    @Test
    public void overflowByte() {
        byte maxValue = Byte.MAX_VALUE;
        byte minValue = Byte.MIN_VALUE;
        Assertions.assertEquals(++maxValue, minValue);
    }

    @Test
    public void overflowShort() {
        short maxValue = Short.MAX_VALUE;
        short minValue = Short.MIN_VALUE;
        Assertions.assertEquals(++maxValue, minValue);
    }

    @Test
    public void overflowLong() {
        long maxValue = Long.MAX_VALUE;
        long minValue = Long.MIN_VALUE;
        Assertions.assertEquals(++maxValue, minValue);
    }

    @Test
    public void overflowDouble() {
        double maxValue = Double.MAX_VALUE;
        double minValue = Double.MIN_VALUE;
        Assertions.assertNotEquals(++maxValue, minValue);
    }

    @Test
    public void overflowFloat() {
        float maxValue = Float.MAX_VALUE;
        float minValue = Float.MIN_VALUE;
        Assertions.assertNotEquals(++maxValue, minValue);
    }

    @Test
    public void longToInteger() {
        long maxValueLong = Long.MAX_VALUE;
        int expected = -1;
        Assertions.assertEquals(expected,(int)maxValueLong);
    }

    @Test
    public void floatToDouble() {
        float number = 2.234567898765432771f;
        double expectedDoubleNumber = 2.234567898765432771;
        Assertions.assertNotEquals(expectedDoubleNumber,number);
    }

    @Test
    public void errorWithFloatingNumber() {
        double number = 0.2 + 0.4;
        double expected = 0.6;
        Assertions.assertNotEquals(expected,number);
    }
}
