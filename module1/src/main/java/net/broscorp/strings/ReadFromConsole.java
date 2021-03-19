package net.broscorp.strings;

import java.util.Scanner;

public class ReadFromConsole {

  public static String readConsole() {
    System.out.print("Please, write your word: ");
    String yourStr = null;
    try(Scanner scanner = new Scanner(System.in)) {
      yourStr = scanner.nextLine();

    }
    return yourStr;
  }

}
