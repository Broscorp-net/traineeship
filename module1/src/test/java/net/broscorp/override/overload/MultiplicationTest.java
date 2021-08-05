package net.broscorp.override.overload;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class MultiplicationTest {

  MathOperation mathOperation;
  double expected;

  @BeforeEach
  void setup() {
    mathOperation = new Multiplication();
  }

  @Test
  void testReceivesDoublePrimitivesAndReturnsTheProduct() {
    double a = 2.5;
    double b = 2.5;
    expected = a * b;
    assertEquals(expected, mathOperation.doMathOperation(a, b));
  }

  @Test
  void testReceivesIntAndReturnsTheProduct() {
    int a = 20;
    int b = 150;
    expected = a * b;
    assertEquals(expected, mathOperation.doMathOperation(a, b));
  }

  @Test
  void testReceivesDoubleWrapperAndReturnsTheProduct() {
    Double a = 2.5;
    Double b = 3.1452;
    expected = a * b;
    assertEquals(expected, mathOperation.doMathOperation(a, b));
  }

  @Test
  void testReceivesIntegerAndReturnsTheProduct() {
    Integer a = 20;
    Integer b = 150;
    expected = a * b;
    assertEquals(expected, mathOperation.doMathOperation(a, b));
  }

  // Test method that invokes method passing double and Double fails at compile time with
  // "Ambiguous method call"

  //  @Test
  //  void testReceivesDoublePrimitiveAndDoubleWrapperAndReturnsTheProduct() {
  //    double a = 15.6;
  //    Double b = 15.6;
  //    double expected = a * b;
  //    assertEquals(expected, mathOperation.doMathOperation(a, b)); // "Ambiguous method call"
  //  }
}