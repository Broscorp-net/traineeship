package net.broscorp.classpath;

import java.util.Scanner;

public class Main {

  /**Classpath.
   *
   * @author Yulian Belov
   */
  public static void main(String[] args) {

    System.out.println("Write something to console.");

    Scanner scanner = new Scanner(System.in);

    WriterClass.write(scanner.nextLine());

  }
}
