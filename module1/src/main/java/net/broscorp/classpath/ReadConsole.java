package net.broscorp.classpath;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class ReadConsole {

  public static void main(String[] args) {
    WriteConsole.writeConsole(readConsole());
  }

  private static String readConsole() {
    String s = "";
    try (BufferedReader reader = new BufferedReader(new InputStreamReader(System.in))) {
      s = reader.readLine();
    } catch (IOException e) {
      e.printStackTrace();
    }
    return s;
  }

}
