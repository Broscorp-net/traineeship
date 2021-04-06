package net.broscorp.classpath;

import java.util.Scanner;

public class MainAndReader {

  private final Scanner scanner = new Scanner(System.in);

  public static void main(String[] args) {
    ConsoleWriter.printToConsole(new MainAndReader().readFromConsole());
  }

  public String readFromConsole() {
    System.out.println("Input your text:");
    return scanner.nextLine();
  }
}
