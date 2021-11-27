package net.broscorp.classpath;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Application {
  private static String data;
  /**
   * read data from console.
   */
  public static void main(String[] args) {
    try (BufferedReader reader = new BufferedReader(new InputStreamReader(System.in))) {
      data = reader.readLine();
    } catch (IOException e) {
      System.out.println("Can't read data" + e);
    }
    DisplayOutput.print(data);
  }

}