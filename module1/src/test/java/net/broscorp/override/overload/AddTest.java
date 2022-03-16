package net.broscorp.override.overload;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class AddTest {

  Add add;

  @BeforeEach
  void create() {
    add = new Add();
  }

  @Test
  void mathOperationAddingdouble() {
    double a = 15.5;
    double b = 17.4;
    assertEquals(add.mathOperation(a, b), 32.9);
  }

  @Test
  void mathOperationAddingInt() {
    int a = 15;
    int b = 17;
    assertEquals(add.mathOperation(a, b), 32);
  }

  @Test
  void mathOperationAddingDouble1() {
    Double a = 15.5;
    Double b = 17.4;
    assertEquals(add.mathOperation(a, b), 32.9);
  }

  @Test
  void mathOperationAddingInteger() {
    Integer a = 15;
    Integer b = 17;
    assertEquals(add.mathOperation(a, b), 32);
  }
}