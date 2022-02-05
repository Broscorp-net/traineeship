package net.broscorp.boxingTest;

import static org.junit.jupiter.api.Assertions.assertSame;
import static org.junit.jupiter.api.Assertions.assertNotSame;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.Test;

public class BoxingTest {

  @Test
    public void equals() {
    Integer first = 1;
    Integer second = 1;
    assertSame(first, second);
  }

  @Test
    public void notEquals() {
    Integer first = 1;
    Integer second = new Integer(1);
    assertNotSame(first, second);
  }

  @Test
    public void notEquals2() {
    Integer first = new Integer(1);
    Integer second = new Integer(1);
    assertNotSame(first, second);
  }

  @Test
    public void exception() {
    Integer integer = null;
    NullPointerException thrown = assertThrows(
            NullPointerException.class, () -> {
            int local = 0;
        local += integer;
        });
    System.out.println(thrown.getMessage());
    assertTrue(thrown.getMessage().contains("is null"));
  }
}
