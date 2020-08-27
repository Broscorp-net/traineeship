package net.broscorp.override.overload;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class AdditionImplTest {
  MathOperation add;

  @BeforeEach
  void setUp() {
    add = new AdditionImpl();
  }

  @Test
  void executePrimitiveDoubleTest() {
    double first = 1.3, second = 2.5;
    double expected = 3.8;
    double actual = add.execute(first, second);

    assertEquals(expected, actual);
  }

  @Test
  void executeWrapperDoubleTest() {
    Double first = 3d, second = 7.1;
    double expected = 10.1;
    double actual = add.execute(first, second);

    assertEquals(expected, actual);
  }

  @Test
  void executePrimitivesIntTest() {
    int first = 3, second = 2;
    double expected = 5d;
    double actual = add.execute(first, second);

    assertEquals(expected, actual);
  }

  @Test
  void executeWrapperIntegerTest() {
    Integer first = 43, second = 5;
    double expected = 48d;
    double actual = add.execute(first, second);

    assertEquals(expected, actual);
  }

  /**
   * java: reference to execute is ambiguous.
   * JVM не понимает, какой из методов вызвать
   */
//  @Test
//  void executeWrapperDoubleAndPrimitiveDoubleTest() {
//    double first = 3d;
//    Double second = 0.4;
//    double expected = 3.4;
//    double actual = add.execute(first, second);
//
//    assertEquals(expected, actual);
//  }
}