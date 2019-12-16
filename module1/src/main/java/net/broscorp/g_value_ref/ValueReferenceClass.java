package net.broscorp.g_value_ref;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

public class ValueReferenceClass {

    /*We create two Objects and they are point to one value .*/
    @Test
    void referenceTransmission() {
        ValueReferenceClass a = new ValueReferenceClass();
        ValueReferenceClass b = a;
        assertEquals(a, b);
    }

    /* We create two primitive values and they have one value .*/
    @Test
    void valueTransmission() {
        int a = 500;
        int b = a;
        assertTrue(a == b);
    }
}
