package net.broscorp.d_gc.result_second;

public class MyBook {
    static MyBook myBook = null;

    @Override protected void finalize() {
        System.out.println("finalized");
        myBook = this;
        System.out.println("resurrected " + myBook.hashCode());
    }

    public static void main(String[] args) {
        MyBook myBook = new MyBook();
        System.out.println("first instance: " + myBook.hashCode());

        myBook = new MyBook();
        System.out.println("second instance: " + myBook.hashCode());

        System.gc();
    }
}
