package net.broscorp.override.overload;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class MultiplyTest {

  Multiply multiply;

  @BeforeEach
  void create() {
    multiply = new Multiply();
  }

  @Test
  void mathOperationMultiplyDob() {
    double a = 15.5;
    double b = 17.4;
    assertEquals(multiply.mathOperation(a, b), 269.7);
  }

  @Test
  void mathOperationMultiplyInt() {
    int a = 15;
    int b = 17;
    assertEquals(multiply.mathOperation(a, b), 255);
  }

  @Test
  void mathOperationMultiplyDouble() {
    Double a = 15.5;
    Double b = 17.4;
    assertEquals(multiply.mathOperation(a, b), 269.7);
  }

  @Test
  void mathOperationMultiplyInteger() {
    Integer a = 15;
    Integer b = 17;
    assertEquals(multiply.mathOperation(a, b), 255);
  }
}