import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.Test;

public class BoxingTest {
  Integer first = 1234;
  Integer second = 1234;

  @Test
  public void compareIntegerWithEqualsSign() {
    assertFalse(first == second);
  }

  @Test
  public void compareIntegerWithEqual() {
    assertTrue(first.equals(second));
  }

  @Test
  public void integerBoxing() {
    Integer fromInt = Integer.valueOf(1234);
    int fromInteger = fromInt;
    int intValue = fromInt.intValue();
    assertEquals(fromInteger, intValue);
  }
}
