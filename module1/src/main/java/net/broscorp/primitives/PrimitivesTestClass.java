package net.broscorp.primitives;

public class PrimitivesTestClass {

    public byte overloop(byte b) {
        return (byte) (b + 1);
    }

    public int conversionInt(long l) {
        int x = (int) l;

        return x;
    }

    public double conversionDouble(float f) {
        double x = f;

        return x;
    }

    public double infelicity(double d, double d2) {

        return d + d2;
    }

}
