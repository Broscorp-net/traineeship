package net.broscorp.override.overload;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class MultiplyOperationsTest {
  private MathOperations mathOperations;

  @BeforeEach
  public void setUp() {
    mathOperations = new MultiplyOperations();
  }

  @Test
  public void doubleArgsTest() {
    Assertions.assertEquals(15.0, mathOperations.someMathOperation(5.0, 3.0));
  }

  @Test
  public void intArgsTest() {
    Assertions.assertEquals(15.0, mathOperations.someMathOperation(5, 3));
  }

  @Test
  public void wrappersArgsTest() {
    Assertions.assertEquals(15.0, mathOperations.someMathOperation(new Integer(3), new Double(5)));
  }
}
