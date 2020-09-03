package net.broscorp.override.overload;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

class MyMultiplicationClassTest {
  MyMultiplicationClass myMultiplicationClass = new MyMultiplicationClass();

  @Test
  void operationDouble() {
    double first = 2.7;
    double second = 5.5;
    double result = myMultiplicationClass.operation(first,second);
    assertEquals((first * second),result);
    assertEquals("Это два double", myMultiplicationClass.method);
  }

  @Test
  void testOperationInt() {
    int first = 10;
    int second = 25;
    double result = myMultiplicationClass.operation(first,second);
    assertEquals((first * second),result);
    assertEquals("Это два int", myMultiplicationClass.method);
  }

  @Test
  void testOperation1Integer() {
    Integer first = 5;
    Integer second = 10;
    double result = myMultiplicationClass.operation(first,second);
    assertEquals((first * second),result);
    assertEquals("Это два Integer", myMultiplicationClass.method);
  }

  @Test
  void testOperationDouble2() {
    Double first = 4.5;
    Double second = 3.8;
    double result = myMultiplicationClass.operation(first,second);
    assertEquals((first * second),result);
    assertEquals("Это два Double", myMultiplicationClass.method);
  }
}