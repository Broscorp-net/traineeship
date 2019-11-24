package net.broscorp.b_bytecode;

public class BytecodeTest_2 {
    public static void main(String[] args) {

        int numb = 0;
        String s = "";

        for (int i = 0; i < 3; i++) {
            printConsole();
            numb++;
            s = "s ";
        }
        System.out.println("numb = " + numb);
        System.out.println("s = " + s);
    }

    static void printConsole() {
        System.out.println("Hello!!!");
    }
}
