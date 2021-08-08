package net.broscorp.bytecode;

import java.util.ArrayList;
import java.util.List;

public class Main {

    public static int x;

    public static void hello(){
        System.out.println("Hello");
    }

    public static void main(String[] args) {

        for (int i = 0; i < 5; i++) {
            System.out.println(x + i);
        }

        Main.hello();


    }
}


