package net.broscorp.classpath;

import java.util.Scanner;

public class FirstClass {

  private static String someString;

  /**
   * Read from console and write it back from another class.
   *
   * @param args - args
   */
  public static void main(String[] args) {
    Scanner scanner = new Scanner(System.in);
    someString = scanner.nextLine();
    SecondClass.printStringInConsole(someString);
  }
}
