import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;

import org.junit.jupiter.api.Test;

public class PrimitiveTest {

    @Test
    public void overByte() {
        byte first = 127;
        byte second = -128;
        assertEquals(second, ++first);
    }

    @Test
    public void overShort() {
        short first = 32767;
        short second = -32768;
        assertEquals(second, ++first);
    }

    @Test
    public void overInt() {
        int first = 2147483647;
        int second = -2147483648;
        assertEquals(second, ++first);
    }

    @Test
    public void overLong() {
        long first = Long.MAX_VALUE;
        long second = Long.MIN_VALUE;
        assertEquals(second, ++first);
    }

    @Test
    public void longToInt() {
        long first = Long.MAX_VALUE;
        int second = (int) first;
        assertNotEquals(first, second);
    }

    @Test
    public void floatToDouble() {
        float first = Float.MAX_VALUE;
        double second = first;
        assertEquals(first, second);
    }

    @Test
    public void floatingPoint() {
        double first = 2.0 - 1.1;
        double second = 0.9;
        assertNotEquals(first, second);
    }


}
