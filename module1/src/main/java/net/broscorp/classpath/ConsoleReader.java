package net.broscorp.classpath;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class ConsoleReader {

  /**
   * Main method.
   *
   * @param args - command line args
   */
  public static void main(String[] args) {
    try (
        BufferedReader reader = new BufferedReader(
            new InputStreamReader(System.in))
    ) {
      String input = reader.readLine();
      ConsoleWriter.printLine(input + " - inputed");
    } catch (IOException e) {
      ConsoleWriter.printLine("error creating console reader");
    }

  }
}
