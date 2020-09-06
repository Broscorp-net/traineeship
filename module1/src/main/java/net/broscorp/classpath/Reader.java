package net.broscorp.classpath;

import java.util.Scanner;

public class Reader {

  public static void main(String[] args) {
    try (Scanner scanner = new Scanner(System.in)) {
      System.out.print("Waiting for input: ");
      String line = scanner.nextLine();

      Writer.writeLineToOutStream(line);
    }
  }

}
