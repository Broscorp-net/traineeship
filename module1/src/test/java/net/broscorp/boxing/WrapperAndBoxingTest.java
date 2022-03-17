package net.broscorp.boxing;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class WrapperAndBoxingTest {

  @Test
  public void wrapperEqualsTrueTest() {
    // Arrange
    //range[-128,127]
    int value = (int) (Math.random() * (256)) - 128;
    // Act
    Integer firstValue = value;
    Integer secondValue = value;
    //Assert
    Assertions.assertTrue(firstValue == secondValue);
  }

  @Test
  public void wrapperEqualsFalseTest() {
    // Arrange
    int value = 128;
    // Act
    Integer firstValue = new Integer(value);
    Integer secondValue = new Integer(value);
    //Assert
    Assertions.assertFalse(firstValue == secondValue);
  }

  @Test
  public void secondWrapperEqualsFalseTest() {
    // Arrange
    int value = 128;
    // Act
    Integer firstValue = value;
    Integer secondValue = value;
    //Assert
    Assertions.assertFalse(firstValue == secondValue);
  }

  @Test
  public void throwExceptionTest() {
    Integer value = null;
    Assertions.assertThrows(NullPointerException.class, () -> {
      int res = value;
    });
  }
}
