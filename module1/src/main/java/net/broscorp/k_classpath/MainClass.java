package net.broscorp.k_classpath;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

import static net.broscorp.k_classpath.SecondClass.outputValueToConsole;

public class MainClass {

    public static int readingFromConsole() {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        int value = 0;
        try {
            value = Integer.parseInt(reader.readLine());
        } catch (IOException e) {
            e.printStackTrace();
        }
        return value;
    }

    public static void main(String[] args) {
        outputValueToConsole();
    }

}
