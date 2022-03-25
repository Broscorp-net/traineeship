package net.broscorp.primitives;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class PrimitivesTest {

  @Test
  public void overflowShortTest() {
    // Arrange
    short value = Short.MAX_VALUE;
    // Act
    value++;
    // Assert
    Assertions.assertEquals(-32768, value);
  }

  @Test
  public void overflowByteTest() {
    // Arrange
    byte value = Byte.MAX_VALUE;
    // Act
    value++;
    // Assert
    Assertions.assertEquals(-128, value);
  }

  @Test
  public void overflowIntTest() {
    // Arrange
    int value = Integer.MAX_VALUE;
    // Act
    value++;
    // Assert
    Assertions.assertEquals(-2147483648, value);
  }

  @Test
  public void overflowLongTest() {
    // Arrange
    long value = Long.MAX_VALUE;
    // Act
    value++;
    // Assert
    Assertions.assertEquals(-9223372036854775808L, value);
  }

  @Test
  public void convertLongToIntTest() {
    // Arrange
    long value = Integer.MAX_VALUE;
    // Act
    value++;
    int res = (int) value;
    // Assert
    Assertions.assertNotEquals(value, res);
  }

  @Test
  public void convertDoubleToFloatTest() {
    // Arrange
    double doubleValue = 1.0 / 3.0;
    // Act
    float floatValue = (float) doubleValue;
    // Assert
    Assertions.assertNotEquals(doubleValue, floatValue);
  }

  @Test
  public void errorPointTest() {
    // Arrange
    double value = 0;
    // Act
    for (int i = 0; i < 10; i++) {
      value += 0.1;
    }
    // Assert
    Assertions.assertNotEquals(value, 1);
  }
}

