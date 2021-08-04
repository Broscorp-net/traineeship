package net.broscorp.override.overload;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;

public class AdditionOperationTest {

  @Test
  public void shouldReturnSumOfTwoDoublePrimitives() {
    //given
    MathOperation addition = new AdditionOperation();
    //when
    double result = addition.calculate(3.14, 3.14);
    //then
    assertEquals(6.28, result);
  }

  @Test
  public void shouldReturnSumOfTwoWrappedDoubles() {
    //given
    MathOperation addition = new AdditionOperation();
    //when
    double result = addition.calculate(Double.valueOf("3.14"), Double.valueOf("3.14"));
    //then
    assertEquals(6.28, result);
  }

  @Test
  public void shouldReturnSumOfTwoIntegerPrimitives() {
    //given
    MathOperation addition = new AdditionOperation();
    //when
    double result = addition.calculate(3, 3);
    //then
    assertEquals(6.0, result);
  }

  @Test
  public void shouldReturnSumOfTwoWrappedIntegers() {
    //given
    MathOperation addition = new AdditionOperation();
    //when
    double result = addition.calculate(Integer.valueOf("3"), Integer.valueOf("3"));
    //then
    assertEquals(6.0, result);
  }

  /*
    The method invocation is impossible because a compilation error occur
    - reference to calculate is ambiguous both method.
    This is happens because int is not subtype of Integer and Integer is not a subtype of int,
    so a more specific method cannot be chosen.
   */

  @Test
  @Disabled
  public void shouldReturnSumOfOneIntegerPrimitiveAndOneWrappedInteger() {
    //given
    MathOperation addition = new AdditionOperation();
    /*
    //when
      double result = addition.calculate(Integer.valueOf(3), 3);
    //then
      assertEquals(6.0, result);
    */
  }

}
