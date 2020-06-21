package net.broscorp.b_bytecode;

public class PrefixIncrement {
    public static void main(String[] args) {
        int val = 1;
        for(int i = 0; i < 10; i++){
            ++val;
        }
        System.out.println("Hello, this is prefix increment - " + val);
    }

}
