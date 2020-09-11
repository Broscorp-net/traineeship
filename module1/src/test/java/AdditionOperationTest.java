import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class AdditionOperationTest {

  private MathOperation operation;

  @BeforeEach
  public void start() {
    operation = new AdditionOperation();
  }

  @Test
  void operationWithTwoPrimitiveDoublesTest() {
    double methodResult = operation.operation(2.5, 3.5);
    double result = 2.5 + 3.5;

    assertEquals(methodResult, result);
  }

  @Test
  void operationWithTwoPrimitiveIntegersTest() {
    double methodResult = operation.operation(25, 4);
    int result = 25 + 4;

    assertEquals(methodResult, result);
  }

  @Test
  void operationWithTwoDoubleWrappersTest() {
    Double num1 = 56.5;
    Double num2 = 2.0;
    double methodResult = operation.operation(num1, num2);
    double result = num1 + num2;

    assertEquals(methodResult, result);
  }

  @Test
  void operationWithTwoIntegerWrappersTest() {
    Integer num1 = 100;
    Integer num2 = 25;
    double methodResult = operation.operation(num1, num2);
    double result = num1 + num2;

    assertEquals(methodResult, result);
  }

  @Test
  void operationWithPrimitiveIntegerAndDoubleWrapperTest() {
    int num2 = 25;
    Double num1 = 100.5;

    double methodResult = operation.operation(num1, num2);
    double result = num1 + num2;

    assertEquals(methodResult, result);
  }

  @Test
  void operationWithPrimitiveDoubleAndIntegerWrapperTest() {
    Integer num2 = 25;
    double num1 = 100.5;

    double methodResult = operation.operation(num1, num2);
    double result = num1 + num2;

    assertEquals(methodResult, result);
  }

  /*
    This test provides compilation error because we don't have overload method for double num1 and
    Double num2 parameters.
   */

  /*@Test
  void operationWithPrimitiveDoubleAndDoubleWrapperTest() {
    double num1 = 100.5;
    Double num2 = 25.5;

    double methodResult = operation.operation(num1, num2);
    double result = num1 + num2;

    assertEquals(methodResult, result);
  }*/
}