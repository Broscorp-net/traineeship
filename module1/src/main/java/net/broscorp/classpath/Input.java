package net.broscorp.classpath;

import java.util.Scanner;

public class Input {

  private static String input;

  /**
   * Checkstyle requirement.
   */
  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);
    System.out.println("Enter your value: ");
    input = sc.nextLine();
    Output.printToConsole(input);
  }
}
