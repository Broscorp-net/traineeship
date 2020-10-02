package net.broscorp.primitives;

public class Primitives {

    public byte byteOverflow() {
        byte maxValue = Byte.MAX_VALUE;
        byte result = (byte) (maxValue + 1);
        return result;
    }

    public short shortOverflow() {
        short maxValue = Short.MAX_VALUE;
        short result = (short) (maxValue + 1);
        return result;
    }

    public int integerOverflow() {
        int maxValue = Integer.MAX_VALUE;
        int result = maxValue + 1;
        return result;
    }

    public long longOverflow() {
        long maxValue = Long.MAX_VALUE;
        long result = ++maxValue ;
        return result;
    }
    public float  floatOverflow() {
        float  maxValue = Float.MAX_VALUE;
        float  result = maxValue + 1f;
        return result;
    }

    public double  doubleOverflow() {
        double  maxValue = Double.MAX_VALUE;
        double  result = maxValue + 1d;
        return result;
    }

    public int convertLongToInt(long l){
        int result = (int) l;
        return result;
    }
    public double convertFloatToDouble(float f) {
        double result = (double) f;
        return result;
    }

}
