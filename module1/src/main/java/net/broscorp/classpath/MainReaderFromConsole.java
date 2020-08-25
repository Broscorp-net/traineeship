package net.broscorp.classpath;

import java.util.Scanner;

public class MainReaderFromConsole {

  /**
   * Main method: Read from And write To.
   */
  public static void main(String[] args) {
    Scanner scanner = new Scanner(System.in);
    WriterToConsole writerToConsole = new WriterToConsole();
    String string = scanner.nextLine();
    writerToConsole.writeToConsole(string);
  }

}
