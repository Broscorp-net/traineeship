package net.broscorp.classpath;

import java.util.Scanner;

/**
 * Class for read and write to console.
 * @author Hryhorii Perets
 * @version 1.0
 */
public class ReadConsole {

  /**
   * For run all methods.
   * @param args this method not have param
   */
  public static void main(String [] args) {

    WriteConsole.writeConsole(readConsole());

  }

  /**
   * This method read from console.
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
