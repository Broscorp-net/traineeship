package net.broscorp.f_boxing;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

public class AutoboxingCompareClass {
    /*This happens because of value between -128 and 127 are allocated in Pool. That`s why Java do not create new Object, it uses
     * old value of an Object which was created earlier. */
    @Test
    void testPoolValuesRestrictionEquals() {
        Integer x = 127;
        Integer y = 127;
        assertTrue(x == y);
    }

    /* In this case we create two values in different heap areas .*/
    @Test
    void testEquals() {
        Integer x = 1000;
        Integer y = 1000;
        assertFalse(x == y);
    }

    /* We can see that primitive value which is boxing - provide Integer class .*/
    @Test
    void testBoxing() {
        int x = 10;
        assertTrue(Integer.valueOf(x) instanceof Integer);
    }

    /* In this case we unboxing 2 values to primitive ones .*/
    @Test
    void testUnboxing() {
        Integer x = 10;
        Integer y = 10;
        int a = x;
        int b = y;
        assertTrue(a == b);
    }
}
