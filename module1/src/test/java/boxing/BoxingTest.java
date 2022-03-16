package boxing;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class BoxingTest {

  @Test
  public void compareTwoObjectsExpectedTrueResult() {
    Integer integer1 = 11;

    Integer integer2 = 11;

    boolean comparison = (integer1 == integer2);
    Assertions.assertEquals(true, comparison);
  }

  @Test
  public void compareTwoObjectsExpectedFalseResult() {
    Integer integer1 = 500;

    Integer integer2 = 500;

    boolean comparison = (integer1 == integer2);
    Assertions.assertEquals(false, comparison);
  }

  @Test
  public void compareTwoObjectsExpectedFalseResultSecondVariant() {
    Integer integer1 = new Integer(5);

    Integer integer2 = new Integer(5);

    boolean comparison = (integer1 == integer2);
    Assertions.assertEquals(false, comparison);
  }

  @Test
  public void gettingExceptionFromUnboxing() {
    Integer integer1 = null;

    Assertions.assertThrows(NullPointerException.class, () -> integer1.intValue());
  }
}
