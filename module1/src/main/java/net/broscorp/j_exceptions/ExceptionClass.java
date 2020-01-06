package net.broscorp.j_exceptions;

import java.io.*;

public class ExceptionClass {

    public static void openFile(String fileName) {
        try (Reader reader = new FileReader(fileName)) {
        } catch (IOException e) {
            System.out.println(e.getMessage());
        } finally {
            System.out.println("Finally block!!!");
        }
    }

    public static void methodThrowable() {
        int a = 10;
        try {
            int c = a / 0;
        } catch (Throwable t) {
            t.printStackTrace();
        }
    }

}
