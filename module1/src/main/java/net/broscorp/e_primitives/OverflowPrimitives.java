package net.broscorp.e_primitives;

public class OverflowPrimitives {

    public long addForOverflowInt(int a, int b) {
        if (b > 0 ? a > Integer.MAX_VALUE - b
                  : a < Integer.MIN_VALUE - b) {
            throw new ArithmeticException("int overflow");
        }
        return a + b;
    }

    public int addForOverflowByte(int a, int b) {
        if (b > 0 ? a > Byte.MAX_VALUE - b
                  : a < Byte.MIN_VALUE - b) {
            throw new ArithmeticException("byte overflow");
        }
        return a + b;
    }
}
