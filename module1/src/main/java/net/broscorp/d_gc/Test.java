package net.broscorp.d_gc;

import java.io.IOException;

public class Test {

    public static void main(String[] args) {
        new Immortal();
        System.gc();
        sleep(1_000);
        System.gc();
        prompt("Press any key...");
    }
    private static void prompt(String msg) {
        try {
            System.out.println(msg);
            System.in.read();
        } catch (IOException io) {
        }
    }
    private static void sleep(long duration) {
        try {
            Thread.sleep(duration);
        } catch (InterruptedException ie) {
        }
    }

}
