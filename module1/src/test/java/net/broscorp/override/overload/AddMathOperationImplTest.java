package net.broscorp.override.overload;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.MethodOrderer.OrderAnnotation;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;

@TestMethodOrder(OrderAnnotation.class)
public class AddMathOperationImplTest {
  private final MathOperation mathOperation = new AddMathOperationImpl();
  private double expectedResult;

  //  Method with two doubles is called
  @Test
  @Order(1)
  public void checkOperateWithTwoPrimitiveDoublesTest() {
    System.out.print("double + double: ");
    double summand1 = 4.191;
    double summand2 = 1.27;
    expectedResult = 5.461;
    assertEquals(expectedResult, mathOperation.operate(summand1, summand2));
  }

  //  Method with two ints is called
  @Test
  @Order(2)
  public void checkOperateWithTwoIntsTest() {
    System.out.print("int + int: ");
    int summand1 = 2;
    int summand2 = 8;
    expectedResult = 10;
    assertEquals(expectedResult, mathOperation.operate(summand1, summand2));
  }

  //  Method with two Doubles is called
  @Test
  @Order(3)
  public void checkOperateWithTwoDoublesTest() {
    System.out.print("Double + Double: ");
    Double summand1 = 3.45;
    Double summand2 = 13.8;
    expectedResult = 17.25;
    assertEquals(expectedResult, mathOperation.operate(summand1, summand2));
  }

  //  Method with two Integers is called
  @Test
  @Order(4)
  public void checkOperateWithTwoIntegersTest() {
    System.out.print("Integer + Integer: ");
    Integer summand1 = 25;
    Integer summand2 = 2;
    expectedResult = 27;
    assertEquals(expectedResult, mathOperation.operate(summand1, summand2));
  }

  //  Method with two doubles is called
  @Test
  @Order(5)
  public void checkOperateWithIntAndPrimitiveDoubleTest() {
    System.out.print("int + double: ");
    int summand1 = 25;
    double summand2 = 2.77;
    expectedResult = 27.77;
    assertEquals(expectedResult, mathOperation.operate(summand1, summand2));
  }

  //  Method with two doubles is called
  @Test
  @Order(6)
  public void checkOperateWithIntAndDoubleTest() {
    System.out.print("int + Double: ");
    int summand1 = 25;
    Double summand2 = 2.77;
    expectedResult = 27.77;
    assertEquals(expectedResult, mathOperation.operate(summand1, summand2));
  }

  //  Method with two doubles is called
  @Test
  @Order(7)
  public void checkOperateWithIntegerAndPrimitiveDoubleTest() {
    System.out.print("Integer + double: ");
    Integer summand1 = 25;
    double summand2 = 2.77;
    expectedResult = 27.77;
    assertEquals(expectedResult, mathOperation.operate(summand1, summand2));
  }

  //  Method with two doubles is called
  @Test
  @Order(8)
  public void checkOperateWithTwoDifferentWrappersTest() {
    System.out.print("Integer + Double: ");
    Integer summand1 = 25;
    Double summand2 = 2.77;
    expectedResult = 27.77;
    assertEquals(expectedResult, mathOperation.operate(summand1, summand2));
  }

  // When primitive and its wrapper are passed to a method, the compiler reports an error:
  // "java: reference to operate is ambiguous" because both method operate (primitive, primitive)
  // and method operate (Wrapper, Wrapper) match.
  // Therefore, we need to cast parameters to the same type.

  //  Method with two ints is called
  @Test
  @Order(9)
  public void checkOperateWithIntAndIntegerTest() {
    System.out.print("int + (int) Integer: ");
    int summand1 = 7;
    Integer summand2 = 2;
    expectedResult = 9;
    assertEquals(expectedResult, mathOperation.operate(summand1, (int) summand2));
  }

  //  Method with two Doubles is called
  @Test
  @Order(10)
  public void checkOperateWithDoubleAndPrimitiveDoubleTest() {
    System.out.print("Double + Double.valueOf(double): ");
    Double summand1 = 5.7;
    double summand2 = 0;
    expectedResult = 5.7;
    assertEquals(expectedResult, mathOperation.operate(summand1, Double.valueOf(summand2)));
  }
}
