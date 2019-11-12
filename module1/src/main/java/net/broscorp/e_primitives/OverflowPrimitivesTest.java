package net.broscorp.e_primitives;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class OverflowPrimitivesTest {

    private OverflowPrimitives primitives;

    @Before
    public void setUp() {
        primitives = new OverflowPrimitives();
    }

    @Test
    public void testAddForOverflowInt_WithoutOverflow() {
        long result = primitives.addForOverflowInt(1_000_000_000, 1_000_000_000);
        assertEquals(2_000_000_000, result);
    }

    @Test(expected = ArithmeticException.class)
    public void testAddForOverflowInt_WithOverflow() {
        primitives.addForOverflowInt(2_147_483_600, 48);
    }

    @Test
    public void testAddForOverflowByte_WithoutOverflow() {
        long result = primitives.addForOverflowByte(50, 50);
        assertEquals(100, result);
    }

    @Test(expected = ArithmeticException.class)
    public void testAddForOverflowByte_WithOverflow() {
        primitives.addForOverflowByte(100, 50);
    }
}