package net.broscorp.d_gc;

public class GBClass {
    private static GBClass gbClass = new GBClass();

    @Override
    protected void finalize() throws Throwable {
        gbClass = this;
        System.out.println("Finalize method");
        super.finalize();
    }


    public static void main(String[] args) {
        for (int i = 0; i < 1_000_000; i++) {
            gbClass = new GBClass();
            gbClass = null;
        }
        System.gc();
    }
}
