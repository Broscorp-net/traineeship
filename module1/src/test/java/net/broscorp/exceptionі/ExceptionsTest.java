package net.broscorp.exceptionі;

import java.io.FileInputStream;
import java.io.IOException;
import org.junit.jupiter.api.Test;

public class ExceptionsTest {
  @Test
  void exceptionTest(){
    String filePath = "c:/xxx.txt";
    try {
      FileInputStream fir = (new FileInputStream(filePath));
    } catch (IOException e) {
      System.out.println(e.getMessage());
    } finally {
      System.out.println("Bay-bay!");
    }
  }

}
