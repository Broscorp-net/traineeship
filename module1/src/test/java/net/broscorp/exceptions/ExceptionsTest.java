package net.broscorp.exceptions;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import org.junit.jupiter.api.Test;

public class ExceptionsTest {

  @Test
  void readFile() {
    File file = new File("D:/test.txt");
    try (BufferedReader reader = new BufferedReader(new FileReader(file))) {
      String line;
      while ((line = reader.readLine()) != null) {
        System.out.println(line);
        throw new IOException();
      }
    } catch (FileNotFoundException ex) {
      System.out.println("Catch FileNotFoundException");
    } catch (IOException e) {
      System.out.println("Catch IOException");
    } finally {
      System.out.println("Finally here");
    }
  }
}
