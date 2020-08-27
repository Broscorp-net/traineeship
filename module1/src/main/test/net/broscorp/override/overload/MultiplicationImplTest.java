package net.broscorp.override.overload;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class MultiplicationImplTest {

  MathOperation mul;

  @BeforeEach
  void setUp() {
    mul = new MultiplicationImpl();
  }

  @Test
  void executePrimitiveDoubleTest() {
    double first = 5, second = 0.5;
    double expected = 2.5;
    double actual = mul.execute(first, second);

    assertEquals(expected, actual);
  }

  @Test
  void executeWrapperDoubleTest() {
    Double first = 5d, second = 0.1;
    double expected = 0.5;
    double actual = mul.execute(first, second);

    assertEquals(expected, actual);
  }

  @Test
  void executePrimitivesIntTest() {
    int first = 5, second = 2;
    double expected = 10d;
    double actual = mul.execute(first, second);

    assertEquals(expected, actual);
  }

  @Test
  void executeWrapperIntegerTest() {
    Integer first = 20, second = 5;
    double expected = 100d;
    double actual = mul.execute(first, second);

    assertEquals(expected, actual);
  }

  /**
   * java: reference to execute is ambiguous.
   * JVM не понимает, какой из методов вызвать
   */
//  @Test
//  void executeWrapperDoubleAndPrimitiveDoubleTest() {
//    double first = 5d;
//    Double second = 0.1d;
//    double expected = 0.5;
//    double actual = mul.execute(first, second);
//
//    assertEquals(expected, actual);
//  }
}