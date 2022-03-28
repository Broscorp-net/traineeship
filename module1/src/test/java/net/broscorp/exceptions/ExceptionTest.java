package net.broscorp.exceptions;

import java.io.FileInputStream;
import java.io.IOException;
import org.junit.jupiter.api.Test;

public class ExceptionTest {

  @Test
  void tryWithResourcesTest() {
    String src = "C:\\non-existentFolder\\non-existentFile";
    try (FileInputStream inputStream = new FileInputStream(src)) {
      int data;
      while ((data = inputStream.read()) != -1) {
        System.out.print((char) data);
      }
    } catch (IOException e) {
      e.printStackTrace();
    } finally {
      System.out.println("See you later :)");
    }
  }

  @Test
  void ancestorExceptionTest() {
    try {
      String n = null;
      n.toUpperCase();
    } catch (RuntimeException e) {
      e.printStackTrace();
    }
  }
}