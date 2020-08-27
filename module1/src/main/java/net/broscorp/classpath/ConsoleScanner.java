package net.broscorp.classpath;

import java.util.Scanner;

public class ConsoleScanner {

  /**
   * Entry point.
   * @param args external arguments
   */
  public static void main(String[] args) {
    ConsolePrinter printer = new ConsolePrinter();
    Scanner scanner = new Scanner(System.in);

    System.out.println("I'm waiting for your input:\n");
    String inputString = scanner.nextLine();

    printer.print(inputString);
  }
}
