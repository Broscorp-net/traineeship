package net.broscorp.override.overload;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

class AddMethodTest {

  AddMethod operationAdd = new AddMethod();

  @Test
  void primitiveDoubleTest() {
    double a = 2.0;
    double b = 3.0;

    double result = operationAdd.arguments(a, b);
    assertEquals(5.0, result);
  }

  @Test
  void primitiveIntTest() {
    int a = 2;
    int b = 3;

    double result = operationAdd.arguments(a, b);
    assertEquals(5.0, result);
  }

  @Test
  void wrapperIntTest() {
    Integer a = 3;
    Integer b = 5;

    double result = operationAdd.arguments(a, b);
    assertEquals(8.0, result);
  }
}