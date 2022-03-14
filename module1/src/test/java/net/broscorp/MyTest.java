package net.broscorp;

import net.broscorp.override.overload.Adding;
import net.broscorp.override.overload.Multiplying;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

class MyTest {

  @Test
  void testIntAdding() {
    Adding adding = new Adding();
    int a = 5;
    int b = 5;

    Assertions.assertEquals(adding.operation(a, b), 10);
  }

  @Test
  void testIntegerAdding() {
    Adding adding = new Adding();
    Integer a = 5;
    Integer b = 5;

    Assertions.assertEquals(adding.operation(a, b), 10);
  }

  @Test
  void testMixedIntAdding() {
    Adding adding = new Adding();
    Integer a = 5;
    int b = 5;

    Assertions.assertEquals(adding.operation(a, b), 10);
  }

  @Test
  void testPrimitiveDoubleAdding() {
    Adding adding = new Adding();
    double a = 5;
    double b = 5;

    Assertions.assertEquals(adding.operation(a, b), 10);
  }

  @Test
  void testDoubleAdding() {
    Adding adding = new Adding();
    Double a = 5.0;
    Double b = 5.0;

    Assertions.assertEquals(adding.operation(a, b), 10);
  }

  @Test
  void testMixedDoubleAdding() {
    Adding adding = new Adding();
    Double a = 5.0;
    double b = 5.0;

    Assertions.assertEquals(adding.operation(a, b), 10);
  }

  @Test
  void testIntMultiplying() {
    Multiplying multiplying = new Multiplying();
    int a = 5;
    int b = 5;

    Assertions.assertEquals(multiplying.operation(a, b), 25);
  }

  @Test
  void testIntegerMultiplying() {
    Multiplying multiplying = new Multiplying();
    Integer a = 5;
    Integer b = 5;

    Assertions.assertEquals(multiplying.operation(a, b), 25);
  }

  @Test
  void testMixedIntMultiplying() {
    Multiplying multiplying = new Multiplying();
    Integer a = 5;
    int b = 5;

    Assertions.assertEquals(multiplying.operation(a, b), 25);
  }

  @Test
  void testPrimitiveDoubleMultiplying() {
    Multiplying multiplying = new Multiplying();
    double a = 5;
    double b = 5;

    Assertions.assertEquals(multiplying.operation(a, b), 25);
  }

  @Test
  void testDoubleMultiplying() {
    Multiplying multiplying = new Multiplying();
    Double a = 5.0;
    Double b = 5.0;

    Assertions.assertEquals(multiplying.operation(a, b), 25);
  }

  @Test
  void testMixedDoubleMultiplying() {
    Multiplying multiplying = new Multiplying();
    Double a = 5.0;
    double b = 5.0;

    Assertions.assertEquals(multiplying.operation(a, b), 25);
  }
}