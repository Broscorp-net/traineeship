package net.broscorp.boxing;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class BoxingTest {

  @Test
  public void comparisonTwoWrappingTypeWithCache() {
    Integer first = 100;
    Integer second = 100;
    Assertions.assertSame(first, second);
  }

  @Test
  public void comparisonTwoWrappingTypeWithoutCache() {
    Integer first = 300;
    Integer second = 300;
    Assertions.assertNotSame(first, second);
  }

  @Test
  public void comparisonTwoWrappingTypeWithNew() {
    Integer first = new Integer(100);
    Integer second = new Integer(100);
    Assertions.assertNotSame(first, second);
  }

  @Test
  public void exceptionWithAutoBoxing() {
    Integer maybeNull = null;
    Assertions.assertThrows(NullPointerException.class, () -> {
      int number = maybeNull;
    });
  }
}
