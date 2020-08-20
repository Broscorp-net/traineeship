package net.broscorp.classpath;

import java.util.Scanner;

public class Read {

  /**
   *Main method.
   *
   * @author Makarenko
   *
   * @version 1.0
   */
  public static void main(String[] args) {
    Scanner in = new Scanner(System.in);
    System.out.print("Input a number: ");
    int num = in.nextInt();

    new Print().print(num);
    in.close();
  }
}
