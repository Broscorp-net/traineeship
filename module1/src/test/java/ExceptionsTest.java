
import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import net.broscorp.j_exceptions.Exceptions;

class ExceptionsTest {

  private static Exceptions exceptions;

  @BeforeAll
  public static void initialization() {
    exceptions = new Exceptions();
  }

  @Test
  void testFinallyBlockExecution() {
    String fileTap = "myFile.txt";
    assertDoesNotThrow(() -> {
      exceptions.finallyBlockExecution(fileTap);
    });
  }

  @Test
  void testArithmeticException() {
    assertDoesNotThrow(() -> {
      exceptions.arithmeticException();
    });
  }

  @Test
  void testPredecessorException() {
    assertDoesNotThrow(() -> {
      exceptions.predecessorException();
    });
  }

  @Test
  void testPredecessorThrowable() {
    assertDoesNotThrow(() -> {
      exceptions.pedecessorThrowable();
    });
  }
}

