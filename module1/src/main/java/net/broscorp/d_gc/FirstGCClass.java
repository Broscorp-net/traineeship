package net.broscorp.d_gc;

public class FirstGCClass {
    SecondGCClass secondGCClass;

    @Override
    protected void finalize() throws Throwable {
        System.out.println("First Object was deleted ");
        super.finalize();
    }

    public static void main(String[] args) {
        for (int i = 0; i < 1_000_000; i++) {
            FirstGCClass first = new FirstGCClass();
            SecondGCClass second = new SecondGCClass();
            first.secondGCClass = second;
            second.firstGCClass = first;
        }
    }
}
