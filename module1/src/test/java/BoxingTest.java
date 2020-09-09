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
  public void integerImplicitBoxing() {
    int a = 1;
    Integer b = a;
    assertTrue(b instanceof Integer);
  }

  @Test
  public void integerExplicitBoxing() {
    Integer fromInt = Integer.valueOf(1234);
    int fromInteger = fromInt;
    int intValue = fromInt.intValue();
    assertEquals(fromInteger, intValue);
  }

  @Test
  public void integerExplicitBoxingWithBrackets() {
    int a = 1234;
    Integer fromInt = (Integer) a;
    int fromInteger = fromInt;
    assertEquals(fromInteger, a);
  }

  @Test
  public void integerExplicitUnBoxing() {
    Integer fromInt = 1234;
    int intValue = (int) fromInt;
    assertEquals(fromInt, intValue);
  }


}
