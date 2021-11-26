package net.broscorp.classpath;

import java.util.Scanner;

public class ReadFromConsole {

  public static void main(String[] args) {
    Scanner scanner = new Scanner(System.in);
    System.out.print("Write your message: ");
    WriteToConsole.write(scanner.nextLine());
  }
}
