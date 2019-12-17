package net.broscorp.k_classpath;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class ReadConsole {

    static String readConsoleText;

    public static void main(String[] args) throws IOException {
        WriteOnConsole writeOnConsole = new WriteOnConsole();
        read();
        writeOnConsole.returnConsoleText();
    }

    String getReadConsoleText() {
        return readConsoleText;
    }

    static void read() throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        System.out.print("Write any text... ");
        readConsoleText = bufferedReader.readLine();
    }
}
