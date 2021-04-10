package net.broscorp.override.overload;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.MethodOrderer.OrderAnnotation;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;

@TestMethodOrder(OrderAnnotation.class)
public class MultMathOperationImplTest {
  private final MathOperation mathOperation = new MultMathOperationImpl();
  private final double expectedResult = 2 * 4;

  //  Method with two doubles is called
  @Test
  @Order(1)
  public void checkOperateWithTwoPrimitiveDoublesTest() {
    System.out.print("double * double: ");
    double multiplicand = 2;
    double multiplier = 4;
    assertEquals(expectedResult, mathOperation.operate(multiplicand, multiplier));
  }

  //  Method with two ints is called
  @Test
  @Order(2)
  public void checkOperateWithTwoIntsTest() {
    System.out.print("int * int: ");
    int multiplicand = 2;
    int multiplier = 4;
    assertEquals(expectedResult, mathOperation.operate(multiplicand, multiplier));
  }

  //  Method with two Doubles is called
  @Test
  @Order(3)
  public void checkOperateWithTwoDoublesTest() {
    System.out.print("Double * Double: ");
    Double multiplicand = 2.;
    Double multiplier = 4.;
    assertEquals(expectedResult, mathOperation.operate(multiplicand, multiplier));
  }

  //  Method with two Integers is called
  @Test
  @Order(4)
  public void checkOperateWithTwoIntegersTest() {
    System.out.print("Integer * Integer: ");
    Integer multiplicand = 2;
    Integer multiplier = 4;
    assertEquals(expectedResult, mathOperation.operate(multiplicand, multiplier));
  }

  //  Method with two doubles is called
  @Test
  @Order(5)
  public void checkOperateWithIntAndPrimitiveDoubleTest() {
    System.out.print("int * double: ");
    int multiplicand = 2;
    double multiplier = 4;
    assertEquals(expectedResult, mathOperation.operate(multiplicand, multiplier));
  }

  //  Method with two doubles is called
  @Test
  @Order(6)
  public void checkOperateWithIntAndDoubleTest() {
    System.out.print("int * Double: ");
    int multiplicand = 2;
    Double multiplier = 4.;
    assertEquals(expectedResult, mathOperation.operate(multiplicand, multiplier));
  }

  //  Method with two doubles is called
  @Test
  @Order(7)
  public void checkOperateWithIntegerAndPrimitiveDoubleTest() {
    System.out.print("Integer * double: ");
    Integer multiplicand = 2;
    double multiplier = 4;
    assertEquals(expectedResult, mathOperation.operate(multiplicand, multiplier));
  }

  //  Method with two doubles is called
  @Test
  @Order(8)
  public void checkOperateWithTwoDifferentWrappersTest() {
    System.out.print("Integer * Double: ");
    Integer multiplicand = 2;
    Double multiplier = 4.;
    assertEquals(expectedResult, mathOperation.operate(multiplicand, multiplier));
  }

  // When primitive and its wrapper are passed to a method, the compiler reports an error:
  // "java: reference to operate is ambiguous" because both method operate (primitive, primitive)
  // and method operate (Wrapper, Wrapper) match.
  // Therefore, we need to cast parameters to the same type.

  //  Method with two ints is called
  @Test
  @Order(9)
  public void checkOperateWithIntAndIntegerTest() {
    System.out.print("int * (int) Integer: ");
    int multiplicand = 2;
    Integer multiplier = 4;
    assertEquals(expectedResult, mathOperation.operate(multiplicand, (int) multiplier));
  }

  //  Method with two Doubles is called
  @Test
  @Order(10)
  public void checkOperateWithDoubleAndPrimitiveDoubleTest() {
    System.out.print("Double * Double.valueOf(double): ");
    Double multiplicand = 2.;
    double multiplier = 4;
    assertEquals(expectedResult, mathOperation.operate(multiplicand, Double.valueOf(multiplier)));
  }
}
