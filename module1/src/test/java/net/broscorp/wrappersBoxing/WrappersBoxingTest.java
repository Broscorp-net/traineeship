
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;


public class WrappersBoxingTest {
  @Test
    public void variablesMustBeEqualTest() {
    Byte a = 127;
    Byte a1 = 127;
    Assertions.assertTrue(a == a1);
  }

  @Test
    public void variablesMustBeNotEqualTest() {
    Integer i1 = 128;
    Integer i2 = 128;

    Assertions.assertFalse(i1 == i2);
  }

  @Test
    public void unboxingThrowExceptionTest() {
    Byte i1 = null;
    Assertions.assertThrows(NullPointerException.class, () -> {
      byte a = i1;
    }, "unboxing null");

  }
}
