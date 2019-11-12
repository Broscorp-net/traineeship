public class TestMethods {

    public double intValueAddition(int base, int value) {
        base += value;
        return base;
    }

    public double floatToDouble(float f) {
        return (double) f;
    }

    public double longToInt(long l) {
        return (int) l;
    }

    public double incDouble(double value, double inc, int count) {
        for (int i = 0; i < count; i++) {
            value += inc;
        }
        return value;
    }

}
