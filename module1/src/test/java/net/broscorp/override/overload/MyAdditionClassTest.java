package net.broscorp.override.overload;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

class MyAdditionClassTest {
  MyAdditionClass myAdditionClass = new MyAdditionClass();

  @Test
  void operationDouble() {
    double first = 2.7;
    double second = 5.5;
    double result = myAdditionClass.operation(first,second);
    assertEquals((first + second),result);
    assertEquals("Это два double", myAdditionClass.method);
  }

  @Test
  void testOperationInt() {
    int first = 10;
    int second = 25;
    double result = myAdditionClass.operation(first,second);
    assertEquals((first + second),result);
    assertEquals("Это два int", myAdditionClass.method);
  }

  @Test
  void testOperation1Integer() {
    Integer first = 5;
    Integer second = 10;
    double result = myAdditionClass.operation(first,second);
    assertEquals((first + second),result);
    assertEquals("Это два Integer", myAdditionClass.method);
  }

  @Test
  void testOperationDouble2() {
    Double first = 4.5;
    Double second = 3.8;
    double result = myAdditionClass.operation(first,second);
    assertEquals((first + second),result);
    assertEquals("Это два Double", myAdditionClass.method);
  }

  //  @Test
  //  void testOperationDouble3() {
  //    double first = 11.1;
  //    Double second = 5.3;
  //    double result = myAdditionClass.operation(first,second);
  //    assertEquals((first + second),result);
  //    assertEquals("Это два Double", myAdditionClass.method);
  //  }
  //Ambiguous method call. Both operation() match.
}