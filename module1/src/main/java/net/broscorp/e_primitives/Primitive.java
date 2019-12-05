package net.broscorp.e_primitives;

class Primitive {

/*    public static void main(String[] args) {
        *//*overflowByte(120, 121);
        overflowShort(22222222, 2222222);
        overflowInt(2000000000, 200000000);
        overflowLong(Long.MAX_VALUE, 2000000000);
        overflowFloat(Float.MAX_VALUE, Float.MAX_VALUE);
        overflowDouble(Double.MAX_VALUE, Double.MAX_VALUE);*//*
        //convertLongToInt(Long.MAX_VALUE, 0);
        //System.out.println(convertLongToInt(Long.MAX_VALUE, Long.MAX_VALUE));
        //inaccuracyFloat(0.4f, 0.6f);
        //inaccuracyFloat2();
    }*/

    byte overflowByte(int b1, int b2) {
        return ((byte) (b1 + b2));
    }

    short overflowShort(int b1, int b2) {
        return ((short) (b1 + b2));
    }

    int overflowInt(int b1, int b2) {
        return b1 + b2;
    }

    long overflowLong(long b1, long b2) {
        return b1 + b2;
    }

    float overflowFloat(float b1, float b2) {
        return b1 + b2;
    }

    double overflowDouble(double b1, double b2) {
        return b1 + b2;
    }

    int convertLongToInt(long l, long i) {
        long resultLong = l + i;
        System.out.println("Before convert result (l + i) = " + resultLong);
        int resultInt = (int) (l + i);
        System.out.println("After convert Integer result (l + i) = " + resultInt);
        return resultInt;
    }

    double convertFloatToDouble(float l, float i) {
        float resultFloat = l + i;
        System.out.println("Before convert result (l + i) = " + resultFloat);
        double resultDouble = l + i;
        System.out.println("After convert Double result (l + i) = " + resultDouble);
        return resultDouble;
    }

    float inaccuracyFloat(float a1, float a2) {
        float f = a1 + a2;
        System.out.println("a1 + a2 == f? (" + (a1 + a2) + "), " + (a1 + a2 == f));
        return f;
    }

    double inaccuracyDouble(double a1, double a2) {
        double d = a1 + a2;
        System.out.println("a1 + a2 == d? (" + (a1 + a2) + "), " + (a1 + a2 == d));
        return d;

    }
}
