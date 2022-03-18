package net.broscorp.classpath;

import java.util.Scanner;

public class Main {

  /**
   * Main class.
   */
  public static void main(String[] args) {
    Scanner in = new Scanner(System.in);
    System.out.print("Input something: ");
    String str = in.nextLine();

    in.close();

    Support.write(str);
  }
}
