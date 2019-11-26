package net.broscorp.d_gc;

import java.util.Date;

public class GCTeach {
    public static void main(String[] args) {
        method();
    }

    private static void method() {
        for (int i = 0; i < 100_000_000; i++) { // create 1 Billion objects Date()
            Date date = new Date();
            date = null; // lost link for Date - obj
        }
    }

    public void finalize() {
        System.out.println("finalize");
    }
}
