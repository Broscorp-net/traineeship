package net.broscorp.boxing;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

public class BoxingTest {

  @Test
  public void equalsValueLowerCash() {
    Integer a = 127;
    Integer b = 127;
    boolean result = a == b;
    assertEquals(true, result);
  }

  @Test
  public void equalsValueInt() {
    Integer a = 128;
    Integer b = 128;
    boolean result = a == b;
    assertEquals(false, result);
  }

  @Test
  public void equalsValueDoub() {
    Double a = 127.;
    Double b = 127.;
    assertEquals(false, a == b);
  }

  @Test
  public void unboxingException() throws NullPointerException {
    Integer b = null;
    int a;
    String message = "Cannot invoke \"java.lang.Integer.intValue()\" because \"b\" is null";
    try {
      a = b;
    } catch (NullPointerException e) {
      assertEquals(e.getMessage(), message);
    }
  }
}