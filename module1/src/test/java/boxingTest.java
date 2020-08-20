import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.Test;

public class boxingTest {

  Integer a = new Integer(4);
  Integer b = new Integer(4);

  @Test
  public void falseTest() {
    assertFalse(a == b);
  }

  @Test
  public void trueTest() {
    assertTrue(a.equals(b));
  }
}
