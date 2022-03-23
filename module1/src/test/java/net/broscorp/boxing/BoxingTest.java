package net.broscorp.boxing;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class BoxingTest {

  Integer value1 = 4;
  Integer value2 = 4;
  Integer value3 = new Integer(4);
  Integer value4 = new Integer(4);


  @Test
  void comparingTypesTrue1() {
    Assertions.assertTrue(value1 == value2);
  }

  @Test
  void comparingTypesFalse1() {
    Integer valueV1 = 300;
    Integer valueV2 = 300;
    Assertions.assertFalse(valueV1 == valueV2);
  }

  @Test
  void comparingTypesFalse2() {
    Assertions.assertFalse(value3 == value4);
  }

  @Test
  void comparingTypesFalse3() {
    Assertions.assertFalse(value2 == value3);
  }

  @Test
  void implicitUnboxingWithException() {
    Integer value = null;
    Assertions.assertThrows(NullPointerException.class, () -> {
      int result = value;
    });
  }
}