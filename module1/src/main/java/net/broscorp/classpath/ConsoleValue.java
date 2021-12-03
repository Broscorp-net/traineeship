package net.broscorp.classpath;

import java.util.Scanner;

public class ConsoleValue {

  public static void main(String[] args) {
    Scanner scanner = new Scanner(System.in);
    ConsolePrintValue.printSomeStuff(scanner.next());
  }
}
