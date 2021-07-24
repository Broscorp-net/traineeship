package net.broscorp.boxing;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.Test;

public class WrappersAndBoxingTest {

  // 1. Comparison of two wrapper types with the same value, expected - true

  @Test
  public void shouldReturnTrue_InterningObjects() {
    //given
    Integer intObj1 = 127;
    Integer intObj2 = 127;
    //when
    //then
    assertTrue(intObj1 == intObj2);
  }

  // 2. Comparison of two wrapper types with the same value, expected - false

  @Test
  public void shouldReturnFalse_NonInterningObjects() {
    //given
    Integer intObj1 = 128;
    Integer intObj2 = 128;
    //when
    //then
    assertFalse(intObj1 == intObj2);
  }

  @Test
  public void shouldReturnFalse_NonInterningObjects_ExplicitObjectCreating() {
    //given
    Integer intObj1 = 3;
    Integer intObj2 = new Integer(3);
    //when
    //then
    assertFalse(intObj1 == intObj2);
  }

  // Interning applies only to Integer, Long (in range: -128...127), Byte and Boolean
  @Test
  public void shouldReturnFalse_ComparingDoubles() {
    //given
    Double doubleObj1 = 2.0;
    Double doubleObj2 = 2.0;
    //when
    //then
    assertFalse(doubleObj1 == doubleObj2);
  }

  // 3. Implicit unboxing throws an exception

  @Test
  public void nullPointerExceptionShouldBeThrown() {
    //given
    Integer intObj = null;
    //when
    //then
    assertThrows(NullPointerException.class, () -> {
      int sum = intObj + 10;
    });
  }
}
