package net.broscorp.classpath;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class ConsoleReader {
  /**
   * method read from console.
   * @return String
   */
  public static String read() {
    try (BufferedReader reader = new BufferedReader(new InputStreamReader(System.in))) {
      System.out.println("Input something");
      return reader.readLine();
    } catch (IOException e) {
      e.printStackTrace();
      throw new RuntimeException();
    }
  }
}
