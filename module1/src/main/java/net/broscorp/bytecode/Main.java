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


//2. ~C:\Users\User\IdeaProjects\BrosCorpExem\traineeship\module1\src\main\java\net\broscorp\bytecode\ javac Main.java
//
//   ~java -classpath C:\Users\User\IdeaProjects\BrosCorpExem\traineeship\module1\src\main\java\ net.broscorp.bytecode Main
//
//
