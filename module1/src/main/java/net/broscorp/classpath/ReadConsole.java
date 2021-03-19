package net.broscorp.classpath;

import java.util.Scanner;

/**
 *Class for read and write to console
 */
public class ReadConsole {

  /**
   *
   * @param args
   * For ring methods
   *
   */
  public static void main(String [] args) {

    WriteConsole.writeConsole(readConsole());

  }

  /**
   *
   * @return Your message
   * From console
   *
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
