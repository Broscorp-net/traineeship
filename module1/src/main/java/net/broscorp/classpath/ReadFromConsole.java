package net.broscorp.classpath;

import java.util.Scanner;

public class ReadFromConsole {

  public static void main(String[] args) {
    new OutOnConsole(readFromConsole());
  }

  private static String readFromConsole() {
    Scanner input = new Scanner(System.in);
    System.out.print("Enter message:");
    return input.nextLine();
  }

}
