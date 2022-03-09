package net.broscorp.boxing;

import static org.junit.jupiter.api.Assertions.assertNotSame;
import static org.junit.jupiter.api.Assertions.assertSame;
import static org.junit.jupiter.api.Assertions.assertThrows;

import org.junit.jupiter.api.Test;

public class BoxingTest {

  @Test
  public void checkTrueWrapperType() {
    Integer first = 10;
    Integer second = 10;
    assertSame(first, second);
  }

  @Test
  public void checkFalseWrapperType() {
    Integer first = 1000;
    Integer second = 1000;
    assertNotSame(first, second);
  }

  @Test
  public void checkErrorUnboxingWrapperType() {
    Integer valueNull = null;
    assertThrows(NullPointerException.class, () -> {
      int x = valueNull;
    });
  }

}
