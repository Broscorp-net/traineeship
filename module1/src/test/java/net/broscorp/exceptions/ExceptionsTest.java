package net.broscorp.exceptions;

import java.io.FileInputStream;
import java.io.IOException;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class ExceptionsTest {
  @Test
  void exceptionTest() {
    String filePath = "c:/xxx.txt";
    try {
      IOException e = Assertions.assertThrows(IOException.class,() -> {
        FileInputStream fir = (new FileInputStream(filePath));
      });
      System.out.println(e.getMessage());
    } finally {
      System.out.println("Bay-bay!");
    }
  }

}
