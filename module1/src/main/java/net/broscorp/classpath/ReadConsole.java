package net.broscorp.classpath;

import java.util.Scanner;

public class ReadConsole {
  /**.
   *Classpath read&write classes
   */
  public static void main(String[] args) {
    Scanner scanner = new Scanner(System.in);
    System.out.print("Print text: ");
    WriteConsole.write(scanner.nextLine());
  }
}
