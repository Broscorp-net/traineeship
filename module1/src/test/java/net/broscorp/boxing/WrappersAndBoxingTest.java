package net.broscorp.boxing;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.Test;

public class WrappersAndBoxingTest {

  @Test
  public void trueEquality() {
    String str1 = "string";
    String str2 = "string";

    assertTrue(str1 == str2);
  }

  @Test
  public void falseNewStringEquality() {
    assertFalse(new String("string") == new String("string"));
  }

  @Test
  public void falseNewIntegerEquality() {
    assertFalse(new Integer(2) == new Integer(2));
  }

  @Test
  public void unboxingException() {
    Integer i = null;
    assertThrows(NullPointerException.class,
        () -> System.out.println(i == 0));
  }
}
