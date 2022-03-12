package net.broscorp.exceptions;

import java.io.FileReader;
import org.junit.jupiter.api.Test;

public class ExceptionTask {

  @Test
  void tryCatchWithResourcesWithException() {
    try {
      System.out.println("Try to read file");
      new FileReader("fileName");
    } catch (Exception e) {
      System.out.println("Get IO exception" + e.getLocalizedMessage());
    } finally {
      System.out.println("Operation ended");
    }
  }

  @Test
  void tryCatchWithResourcesSuccessfully() {
    try {
      System.out.println("Try to read file");
      new FileReader("src/main/java/net/broscorp/exceptions/diagram.gv");
      System.out.println("We have done it!");
    } catch (Exception e) {
      System.out.println("Get IO exception" + e.getLocalizedMessage());
    } finally {
      System.out.println("Operation ended");
    }
  }
}
