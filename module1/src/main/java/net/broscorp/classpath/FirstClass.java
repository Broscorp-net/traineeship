package net.broscorp.classpath;

import java.util.Scanner;

public class FirstClass {
  /**
  * method Main.
  * @param args args
  */
  public static void main(String[] args) {
    Scanner scanner = new Scanner(System.in);
    SecondClass second = new SecondClass();
    second.outputValue(scanner.nextLine());
  }
}
