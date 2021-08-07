package net.broscorp.exceptions;

import java.io.BufferedInputStream;
import java.io.FileInputStream;
import java.io.IOException;
import org.junit.jupiter.api.Test;

public class ExceptionsTest {

  @Test
  void openFileWisExceptionTest() {
    try (BufferedInputStream in = new BufferedInputStream(new FileInputStream("index.html"),
        1024)) {
      in.read();
    } catch (IOException e) {
      System.out.println("e.fillInStackTrace() = " + e.fillInStackTrace());
    } finally {
      System.out.println("Hasta la vista");
    }
  }

  @Test
  void parentClassExceptionTest() {
    try (MyClosableExceptionClass myClass = new MyClosableExceptionClass()) {
      myClass.throwsMyException();
    } catch (IOException e) {
      System.out.println("e.fillInStackTrace() = " + e.fillInStackTrace());
    }

  }

}
