package net.broscorp.k_classpath;

import static net.broscorp.k_classpath.Output.output;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Read {

  public static void main(String[] args) {
    output(readFromConsole());
  }

  public static String readFromConsole() {
    String line = null;

    try (BufferedReader reader = new BufferedReader(new InputStreamReader(System.in))) {
      line = reader.readLine();
    } catch (IOException e) {
      e.getMessage();
    }

    return line;
  }
}

