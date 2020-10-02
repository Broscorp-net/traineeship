package net.broscorp.primitives;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class PrimitivesTest {

    @Test
    void byteOverflow() {
        Primitives primitives = new Primitives();
        byte actual = primitives.byteOverflow();
        byte expected = Byte.MIN_VALUE;
        assertEquals(expected, actual);
    }

    @Test
    void shortOverflow() {
        Primitives primitives = new Primitives();
        short actual = primitives.shortOverflow();
        short expected = Short.MIN_VALUE;
        assertEquals(expected, actual);
    }

    @Test
    void integerOverflow() {
        Primitives primitives = new Primitives();
        int actual = primitives.integerOverflow();
        int expected = Integer.MIN_VALUE;
        assertEquals(expected, actual);
    }

    @Test
    void longOverflow() {
        Primitives primitives = new Primitives();
        long actual = primitives.longOverflow();
        long expected = Long.MIN_VALUE;
        assertEquals(expected, actual);
    }

    @Test
    void floatOverflow() {
        Primitives primitives = new Primitives();
        float actual = primitives.floatOverflow();
        float expected = Float.MIN_VALUE;
        assertNotEquals(expected, actual);
    }

    @Test
    void doubleOverflow() {
        Primitives primitives = new Primitives();
        double actual = primitives.doubleOverflow();
        double expected = Double.MIN_VALUE;
        assertNotEquals(expected, actual);
    }

    @Test
    void convertLongToInt(){
        Primitives primitives = new Primitives();
        int actual = primitives.convertLongToInt(3000000000l);
        int expected = -1;
        assertNotEquals(expected, actual);
    }

    @Test
    void convertFloatToDouble() {
        Primitives primitives = new Primitives();
        double actual = primitives.convertFloatToDouble(0.1f);
        double expected = 0.1d;
        assertNotEquals(expected, actual);
    }
}