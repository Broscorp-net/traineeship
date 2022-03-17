package net.broscorp.classpath;

import java.util.Scanner;

public class ConsoleReader {

  /**
   * Main class.
   */
  public static void main(String[] args) {
    Scanner scanner = new Scanner(System.in);
    while (true) {
      if (scanner.hasNextLine()) {
        Object input = scanner.next();
        if (input.equals("exit")) {
          break;
        }
        ConsoleWriter.consoleWrite(input);
      }
    }
  }
}
