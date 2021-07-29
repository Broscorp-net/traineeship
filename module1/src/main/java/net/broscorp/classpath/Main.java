package net.broscorp.classpath;

import java.util.Scanner;

public class Main {

  /**javadoc.
   *
   * */
  public static void main(String[] args) {

    Scanner scanner = new Scanner(System.in);
    System.out.print("Hello, how are you?  -  ");
    Writer.write(scanner.nextLine());
  }
}
