package net.broscorp.primitives;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class PrimitivesTest {
    @Test
    public void checkOverflow() {
        int m = Integer.MAX_VALUE;
        Assertions.assertTrue(m + 1 < 0);
    }

    @Test
    public void checkConvertLongToInt() {
        int max = Integer.MAX_VALUE;
        long convertedLong = (long)max + 2;
        int convertedInt = (int)convertedLong;
        Assertions.assertNotEquals(convertedLong, convertedInt);
    }

    @Test
    public void checkConvertDoubleToFloat() {
        float max = Float.MAX_VALUE;
        double convertDouble = (double)max * 2;
        float convertFloat = (float)convertDouble;
        Assertions.assertNotEquals(convertDouble, convertFloat);
    }

    @Test
    public void checkFloatError() {
        float f = 0.0f;
        for (int i = 1; i <= 10; i++) {
            f += 0.1;
        }
        Assertions.assertNotEquals(f, 1.0f);
    }
}
