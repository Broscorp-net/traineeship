package net.broscorp.d_gc.result_three;

public class RefTwoObject {
    RefTwoObject refTwoObject;

    public static void main(String[] args) {
        for (int i = 0; i < 1000000; i++) {
            RefTwoObject refTwoObject1 = new RefTwoObject();
            RefTwoObject refTwoObject2 = new RefTwoObject();
            refTwoObject2 = refTwoObject1;
            refTwoObject1 = refTwoObject2;
        }

        System.gc();
    }

    @Override
    protected void finalize() throws Throwable {
        System.out.println("finalize: " + this.hashCode());
    }
}
