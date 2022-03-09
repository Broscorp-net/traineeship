package net.broscorp.boxing;

import static org.junit.jupiter.api.Assertions.assertNotSame;
import static org.junit.jupiter.api.Assertions.assertSame;
import static org.junit.jupiter.api.Assertions.assertThrows;

import org.junit.jupiter.api.Test;

public class BoxingTest {

  @Test
  public void equalsTest() {
    Integer a = 127;
    Integer b = 127;
    assertSame(a, b);
  }

  @Test
  public void notEqualsWithIntegerValuesTest() {
    Integer a = 300;
    Integer b = 300;
    assertNotSame(a, b);
  }

  @Test
  public void notEqualsWithIntegerObjectsTest() {
    Integer a = new Integer(100);
    Integer b = new Integer(100);
    assertNotSame(a, b);
  }

  @Test
  public void autoboxingThrowExceptionTest() {
    Integer x = null;
    assertThrows(NullPointerException.class, () -> {
      int result = x;
    });
  }
}
