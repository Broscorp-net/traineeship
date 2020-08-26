package net.broscorp.classpath;

import java.util.Scanner;

public class ConsoleReader {

  /**This class read data from console.
   */
  public static void main(String[] args) {
    System.out.println("Reader start...");
    ConsoleWriter writer = new ConsoleWriter();

    Scanner in = new Scanner(System.in);
    System.out.println("Enter something");
    writer.write(in.next());
    in.close();
  }
}
