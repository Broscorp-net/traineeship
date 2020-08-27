package net.broscorp;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;

import org.junit.jupiter.api.Test;

public class BoxingTest {
  Integer a = new Integer(5);
  Integer b = new Integer(5);

  @Test
  public void shouldBeFalseWhenCompareWrappersLikeThis() {
    assertFalse(a == b);
  }

  @Test
  public void shouldBeTrueWhenCompareWrappersWithEquals() {
    assertEquals(a, b);
  }

  @Test
  public void boxing() {
    int c = 5;
    assertEquals(a, c);
  }

  @Test
  public void unboxing() {
    int c = 5;
    assertEquals(c, a);
  }
}
