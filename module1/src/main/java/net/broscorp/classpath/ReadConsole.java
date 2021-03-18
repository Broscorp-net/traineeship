package net.broscorp.classpath;

import java.util.Scanner;

public class ReadConsole {

  public static void main(String [] args) {

    WriteConsole.writeConsole(readConsole());

  }

  /**
   *
   * @return Your message
   */
  public static String readConsole() {
    System.out.println("Please write your message:");
    String str = null;
    try (Scanner in = new Scanner(System.in)) {
      str = in.nextLine();
    }
    return str;
  }

}
