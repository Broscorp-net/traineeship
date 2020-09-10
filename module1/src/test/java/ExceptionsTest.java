import static org.junit.jupiter.api.Assertions.assertTrue;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import org.junit.jupiter.api.Test;

public class ExceptionsTest {

  @Test
  public void tryWithResourcesTest() {

    /*
    this file does not exist, so we get FileNotFoundException. Than we go to catch,
    because IOException is a parent of FileNotFoundException.
     */
    File file = new File("TestFile.txt");

    try (BufferedReader reader = new BufferedReader(new FileReader(file))) {

      while (reader.ready()) {
        int num = reader.read();
        System.out.println(num);
      }
    } catch (IOException e) {
      //e.printStackTrace();
      System.out.println("Hello from catch");
    } finally {
      System.out.println("Goodbye from finally");
    }
  }

  @Test
  public void catchParentExceptionTest() {
    try {
      int result = 5 / 0;
    } catch (Exception e) {
      //e.printStackTrace();
      System.out.println(e.getMessage() + " provides ArithmeticException");
      assertTrue(e instanceof ArithmeticException);
    }
  }
}
