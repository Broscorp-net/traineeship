package net.broscorp.k_classpath;

import java.util.Scanner;

public class MainAndReadFromConsole {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        SecondClass output = new SecondClass();
        System.out.println("Write some text!");
        String str = scanner.nextLine();
        output.outputToConsole(str);
    }

}
