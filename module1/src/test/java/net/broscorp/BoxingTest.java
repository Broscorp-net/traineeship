package net.broscorp;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;

import org.junit.jupiter.api.Test;

public class BoxingTest {
  Integer integer1 = new Integer(5);
  Integer integer2 = new Integer(5);

  @Test
  public void shouldBeFalseWhenCompareWrappersLikeThis() {
    assertFalse(integer1 == integer2);
  }

  @Test
  public void shouldBeTrueWhenCompareWrappersWithEquals() {
    assertEquals(integer1, integer2);
  }

  @Test
  public void boxing() {
    int someInt = 5;
    assertEquals(integer1, someInt);
  }

  @Test
  public void unboxing() {
    int someInt = 5;
    assertEquals(someInt, integer1);
  }
}
