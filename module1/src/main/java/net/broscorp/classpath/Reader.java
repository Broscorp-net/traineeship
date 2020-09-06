package net.broscorp.classpath;

import java.util.Scanner;

public class Reader {

  /**
   * Entry point.
   * @param args Command-line arguments.
   */
  public static void main(String[] args) {
    try (Scanner scanner = new Scanner(System.in)) {
      System.out.print("Waiting for input: ");
      String line = scanner.nextLine();

      Writer.writeLineToOutStream(line);
    }
  }

}
