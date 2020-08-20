package net.broscorp.boxing;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;

import org.junit.jupiter.api.Test;

public class BoxingTest {
  
  @Test
  public void wrapperCompare() {
    Integer firstNumber = 999;
    Integer secondNumber = 999;
    assertFalse(firstNumber == secondNumber);
  }
  
  @Test
  public void boxing() {
    int primitive = 35;
    Integer wrapper = primitive;
    assertEquals(primitive,wrapper);
  }
  
  @Test
  public void unboxing() {
    Integer wrapper = 40;
    int primitive = wrapper;
    assertEquals(wrapper,primitive);
  }
}
