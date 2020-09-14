package net.broscorp.boxing;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.Test;

public class BoxingTest {

  @Test
  public void shouldBeFalseWhenCompareWrappersLikeThis() {
    Integer integer1 = new Integer(5);
    Integer integer2 = new Integer(5);
    assertFalse(integer1 == integer2);
  }

  @Test
  public void shouldBeTrueWhenCompareWrappersLikeThis() {
    Integer integer1 = new Integer(5);
    Integer integer2 = integer1;
    assertTrue(integer1 == integer2);
  }

  @Test
  public void shouldBeTrueWhenCompareWrappersWithEquals() {
    Integer integer1 = new Integer(5);
    Integer integer2 = new Integer(5);
    assertEquals(integer1, integer2);
  }

  @Test
  public void autoboxing() {
    Integer integer1 = new Integer(5);
    int someInt = integer1;
    assertEquals(integer1, someInt);
  }

  @Test
  public void unboxing() {
    Integer integer1 = new Integer(5);
    int someInt = 5;
    assertEquals(someInt, integer1);
  }
}
