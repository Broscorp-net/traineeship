package net.broscorp.classpath;

import java.util.Scanner;

public class FirstClass {

  static String readFromConsole() {
    Scanner input = new Scanner(System.in);
    System.out.print("Enter your message:");
    return input.nextLine();
  }

  public static void main(String[] args) {
    SecondClass.writeToConsole(readFromConsole());
  }
}
