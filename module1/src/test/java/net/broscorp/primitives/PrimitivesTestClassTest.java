package net.broscorp.primitives;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class PrimitivesTestClassTest {

    @Test
    void overloop() throws Exception {
        PrimitivesTestClass prm = new PrimitivesTestClass();
        byte b = prm.overloop((byte) 127);

        byte c = -128;

        assertEquals(c,b);

    }

    @Test
    void conversionInt() {
        PrimitivesTestClass prm = new PrimitivesTestClass();
        long l = 922337203685477580L;
        int i = prm.conversionInt(l);

        assertEquals(-858993460, i);
    }

    @Test
    void conversionDouble() {
        PrimitivesTestClass prm = new PrimitivesTestClass();
        double d = prm.conversionDouble(2345.23452345f);

        assertEquals(2345.234619140625, d);
    }


    @Test
    void infelicity() {
        PrimitivesTestClass prm = new PrimitivesTestClass();

        double d = prm.infelicity(0.1, 0.2);

        assertEquals(0.30000000000000004, d);
    }
}