package net.broscorp.e_primitives;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

class OverflowPrimitivesTest {

    private OverflowPrimitives primitives;

    @BeforeEach
    void setUp() {
        primitives = new OverflowPrimitives();
    }

    @Test
    void testAddForOverflowInt_WithoutOverflow() {
        long result = primitives.addForOverflowInt(1_000_000_000, 1_000_000_000);
        assertEquals(2_000_000_000, result);
    }

    @Test
    void testAddForOverflowInt_WithOverflow() {
        assertThrows(ArithmeticException.class, () -> {
            primitives.addForOverflowInt(2_147_483_600, 48);
        });
    }

    @Test
    void testAddForOverflowByte_WithoutOverflow() {
        long result = primitives.addForOverflowByte(50, 50);
        assertEquals(100, result);
    }

    @Test
    void testAddForOverflowByte_WithOverflow() {
        assertThrows(ArithmeticException.class, () -> {
            primitives.addForOverflowByte(100, 50);
        });
    }

    @Test
    void testAddForOverflowLong_WithOverflow() {
        assertThrows(ArithmeticException.class, () -> {
            primitives.addForOverflowLong(5223372036854775807L, 5223372036854775807L);
        });
    }

    @Test
    void testAddForOverflowLong_WithoutOverflow() {
        long result = primitives.addForOverflowLong(4223372036854775807L, 4223372036854775807L);
        assertEquals(8446744073709551614L, result);

    }
}