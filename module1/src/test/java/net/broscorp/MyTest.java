package net.broscorp;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

class MyTest {

  @Test
  void testIOException() {
    try {
      File file = new File("./nonExistingFile.txt");
      InputStream is = new FileInputStream(file);
    } catch (IOException ex) {
      System.out.println(ex.getMessage());
    } finally {
      System.out.println("Goodbye");
    }
  }

  @Test
  void testAncestors() {
    try {
      File file = new File("./nonExistingFile.txt");
      InputStream is = new FileInputStream(file);
    } catch (Exception ex) {
      System.out.println(ex.getMessage());
    }
  }
}