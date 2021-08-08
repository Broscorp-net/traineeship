package net.broscorp.classpath;

import java.util.Scanner;

public class First {

  /**
   * main.
   */
  public static void main(String[] args) {
    while (true) {
      Scanner scanner = new Scanner(System.in);
      System.out.println("Please enter the number value: ");
      int value;
      if (scanner.hasNextInt()) {
        value = scanner.nextInt();
        Second.print(value);
        break;
      } else {
        System.out.println("I said enter the NUMBER value please: ");
      }
    }
  }
}
