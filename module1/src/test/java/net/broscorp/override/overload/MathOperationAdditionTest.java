package net.broscorp.override.overload;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;


class MathOperationAdditionTest {

  private MathOperation mathOperation;

  @BeforeEach
  void setUp() {
    mathOperation = new MathOperationAddition();
  }

  @AfterEach
  void tearDown() {
  }


  @Test
  @DisplayName("Should call method with int")
  void shouldMathOperationWithInt() {
    int arg1 = 10;
    int agr2 = 15;
    double actual = mathOperation.mathOperation(arg1, agr2);
    assertEquals(25, actual);
  }

  @Test
  @DisplayName("Should call method with Integer")
  void shouldMathOperationWithInteger() {
    Integer arg1 = 10;
    Integer agr2 = 15;
    double actual = mathOperation.mathOperation(arg1, agr2);
    assertEquals(25, actual);
  }

  @Test
  @DisplayName("Should call method with double")
  void shouldMathOperationWithDoublePrimitive() {
    double arg1 = 10.0;
    double agr2 = 15.0;
    double actual = mathOperation.mathOperation(arg1, agr2);
    assertEquals(25, actual);
  }

  @Test
  @DisplayName("Should call method with Double")
  void shouldMathOperationWithDouble() {
    Double arg1 = 10.0;
    Double agr2 = 15.0;
    double actual = mathOperation.mathOperation(arg1, agr2);
    assertEquals(25, actual);
  }

  /**
   * unboxing -> widening
   * mathOperation(double, double).
   */
  @Test
  @DisplayName("Should call method with double and Integer")
  void shouldMathOperationWithDoubleAndInteger() {
    double arg1 = 10.0;
    Integer agr2 = 15;
    double actual = mathOperation.mathOperation(arg1, agr2);
    assertEquals(25.0, actual);
  }

  /**
   * widening -> unboxing
   * mathOperation(double, double).
   */
  @Test
  @DisplayName("Should call method with Double and int")
  void shouldMathOperationWithDoubleAndInt() {
    Double arg1 = 10.0;
    int agr2 = 15;
    double actual = mathOperation.mathOperation(arg1, agr2);
    assertEquals(25, actual);
  }

  /**
   * widening
   * mathOperation(int, int).
   */
  @Test
  @DisplayName("Should call method with short and int")
  void shouldMathOperationWithShortAndInt() {
    short arg1 = 10;
    int agr2 = 15;
    double actual = mathOperation.mathOperation(arg1, agr2);
    assertEquals(25, actual);
  }

  /**
   * widening -> unboxing
   * mathOperation(int, int).
   */
  @Test
  @DisplayName("Should call method with short and int")
  void shouldMathOperationWithShortAndInteger() {
    short arg1 = 10;
    Integer agr2 = 15;
    double actual = mathOperation.mathOperation(arg1, agr2);
    assertEquals(25, actual);
  }

}