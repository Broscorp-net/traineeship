package net.broscorp.boxing;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.Test;


public class BoxingTest {

  //1
  @Test
  void shouldReturnTrue() {
    String firstStr = "Hello java developers";
    String secondStr = "Hello java developers";
    assertTrue(firstStr == secondStr);
  }


  //2
  @Test
  void shouldReturnFalse() {
    String firstStr = new String("Hello java developers");
    String secondStr = new String("Hello java developers");
    assertFalse(firstStr == secondStr);
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
