package net.broscorp.boxing;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.Test;


public class BoxingTest {

  //1
  @Test
  void shouldReturnTrue() {
    Integer integer1 = 456123;
    Integer integer11 = integer1;
    Integer integer22 = integer1;
    assertTrue(integer11 == integer22);
  }

  //2
  @Test
  void shouldReturnFalse() {
    Integer integer1 = 456123;
    Integer integer2 = 456123;
    System.out.println(integer1 == integer2);
    assertFalse(integer1 == integer2);
  }

  //3
  @Test
  void undefinedUnboxingShouldReturnException() {
    // Unboxing the Object
    Long longWr = null;
    assertThrows(NullPointerException.class, () -> {
      long longPr = longWr;
    });
  }
}
