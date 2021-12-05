package net.broscorp.classpath;

import java.util.Scanner;

public class ConsoleValue {

  public static void main(String[] args) {
    Scanner scanner = new Scanner(System.in);
    System.out.println("Print some stuff");
    ConsolePrintValue consolePrintValue = new ConsolePrintValue();
    consolePrintValue.printSomeStuff(scanner.next());
  }
}
