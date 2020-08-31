import static org.junit.jupiter.api.Assertions.assertTrue;

import java.io.File;
import java.io.IOException;
import java.util.Scanner;

import org.junit.jupiter.api.Test;

public class ExceptionsTest {

  @Test
  public void readFileWithException() throws IOException {
    try (Scanner scanner = new Scanner(new File("test.txt"))) {
      while (scanner.hasNext()) {
        System.out.println(scanner.nextLine());
      }
    } catch (IOException e) {
      e.getMessage();
    } finally {
      System.out.println("Bye-Bye!");
    }
  }

  @Test
  public void catchParent() {
    try {
      throw new RuntimeException();
    } catch (Exception e) {
      assertTrue(e instanceof RuntimeException);
    }
  }
}
