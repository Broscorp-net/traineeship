package net.broscorp.classpath;

import java.util.Scanner;

public class MainAndReadFromConsole {

  /**
   * Чтение значения из консоли и вывод на экран.
   */
  public static void main(String[] args) {
    Scanner scanner = new Scanner(System.in);
    SecondClass output = new SecondClass();
    System.out.println("Write some text!");
    String str = scanner.nextLine();
    output.outputToConsole(str);
  }

}
