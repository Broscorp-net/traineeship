package net.broscorp.b_bytecode;

public class BytecodeClass {
    public static void methodHello() {
        System.out.println("Hello World!");
    }

    public static void main(String[] args) {
        for (int i = 0; i < 5; i++) {
            methodHello();
        }

    }
}
