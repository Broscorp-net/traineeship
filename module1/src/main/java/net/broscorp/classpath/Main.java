package net.broscorp.classpath;

import java.util.Scanner;

public class Main {

  public static void main(String[] args) {
    Scanner scanner = new Scanner(System.in);
    System.out.println("Input your text:");
    String input = scanner.nextLine();
    Output.printToConsole(input);
  }
}
