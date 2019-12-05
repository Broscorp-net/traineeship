package net.broscorp.d_gc;

public class GCPairs {
    static class OnePair {
        TwoPair twoPair;

        @Override
        public void finalize() {
            System.out.println("OnePair was deleting");
        }
    }

    static class TwoPair {
        OnePair onePair;

        @Override
        public void finalize() {
            System.out.println("TwoPair was deleting");
        }
    }

    public static void main(String[] args) {
        for (int i = 0; i < 150_000; i++) {
            OnePair one = new OnePair();
            TwoPair two = new TwoPair();

            one.twoPair = two;
            two.onePair = one;
        }
    }
}
