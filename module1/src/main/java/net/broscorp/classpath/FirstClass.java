package net.broscorp.classpath;

import java.util.Scanner;

public class FirstClass {

  public static void main(String[] args) {
    Scanner scanner = new Scanner(System.in);
    String line = scanner.nextLine();
    SecondClass printClass = new SecondClass();
    printClass.print(line);
  }

}
