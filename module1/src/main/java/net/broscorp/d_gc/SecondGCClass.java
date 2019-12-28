package net.broscorp.d_gc;

public class SecondGCClass {
    FirstGCClass firstGCClass;

    @Override
    protected void finalize() throws Throwable {
        System.out.println("Second Object was deleted ");
        super.finalize();
    }
}
