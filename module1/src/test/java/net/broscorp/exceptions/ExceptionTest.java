package net.broscorp.exceptions;

import java.io.FileInputStream;
import java.io.IOException;
import org.junit.jupiter.api.Test;

public class ExceptionTest {

  @Test
  public void tryWithResourcesException() {
    try (FileInputStream fis = new FileInputStream("pathName")) {
      fis.read();
    } catch (IOException e) {
      e.printStackTrace();
    } finally {
      System.out.println("Good bye!");
    }
  }

  @Test
  public void tryWithResourcesExtendsException() {
    try (FileInputStream fis = new FileInputStream("pathName")) {
      fis.read();
    } catch (Exception e) {
      e.printStackTrace();
    }
  }
}
