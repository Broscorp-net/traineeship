package net.broscorp.classpath;

import java.util.Scanner;

public class FirstClass {
  private static String input;

  /**
   * Read from console and print it back.
   *
   * @param args - args
   */
  public static void main(String[] args) {
    Scanner scanner = new Scanner(System.in);
    input = scanner.next();
    SecondClass.print();
  }

  public static String getString() {
    return input;
  }
}
