package net.broscorp.b_bytecode;

public class MainFirst {
    public static void main(String[] args) {

        int count = 0;

        for (int i = 0; i < 10; i++) {
            count++;
        }

        write("Hello, count after for: " + count);
    }

    public static void write(String message) {
        System.out.println(message);
    }
}
