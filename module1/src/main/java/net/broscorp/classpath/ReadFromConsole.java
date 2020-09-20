package net.broscorp.classpath;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class ReadFromConsole {
  /**
   * Read from console and print into console in main method.
   * 
   * @param args - args
   */
  public static void main(String[] args) {
    WriteToConsole write = new WriteToConsole();
    System.out.println("Input your value:");
    try (BufferedReader reader = new BufferedReader(new InputStreamReader(System.in))) {
      write.printToConsole(reader.readLine());
    } catch (IOException e) {
      e.printStackTrace();
    }
  }
}
