package net.broscorp.b_bytecode;

public class MainSecond {
    public static void main(String[] args) {

        int[] count = new int[10];

        for (int i = 0; i < count.length; i++) {
            count[i] = i;
            write("Hello, count inside for: " + count[i]);
        }
    }

    public static void write(String message) {
        System.out.println(message);
    }
}
