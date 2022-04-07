package exceptions;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import org.junit.jupiter.api.Test;


public class ExceptionTest {

  @Test
  public void getInputOutputExceptionTest() {
    try (FileReader fileReader = new FileReader("java.txt")) {
      fileReader.read();
    } catch (FileNotFoundException e) {
      e.printStackTrace();
    } catch (IOException e) {
      e.printStackTrace();
    } finally {
      System.out.println("Final message!");
    }
  }

}
