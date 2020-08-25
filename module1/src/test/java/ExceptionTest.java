import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import org.junit.jupiter.api.Test;

public class ExceptionTest {


  @Test
  public void exceptionTest() {

    try (FileReader reader = new FileReader("notExistingFile.txt");
        BufferedReader bufferedReader = new BufferedReader(reader);) {

      while (bufferedReader.ready()) {
        System.out.println(bufferedReader.readLine());

      }
    } catch (IOException e) {
      System.out.println("Exception was catched.");
    } finally {
      System.out.println("Message from finally.");
    }
  }
}
