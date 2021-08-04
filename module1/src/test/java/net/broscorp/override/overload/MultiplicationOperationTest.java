package net.broscorp.override.overload;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

public class MultiplicationOperationTest {

  @Test
  public void shouldReturnProductOfTwoDoublePrimitives() {
    //given
    MathOperation multiplication = new MultiplicationOperation();
    //when
    double result = multiplication.calculate(2.0, 2.0);
    //then
    assertEquals(4.0, result);
  }

  @Test
  public void shouldReturnProductOfTwoWrappedDoubles() {
    //given
    MathOperation multiplication = new MultiplicationOperation();
    //when
    double result = multiplication.calculate(Double.valueOf("2.1"), Double.valueOf("2.1"));
    //then
    assertEquals(4.41, result);
  }

  @Test
  public void shouldReturnProductOfTwoIntegerPrimitives() {
    //given
    MathOperation multiplication = new MultiplicationOperation();
    //when
    double result = multiplication.calculate(3, 3);
    //then
    assertEquals(9.0, result);
  }

  @Test
  public void shouldReturnProductOfTwoWrappedIntegers() {
    //given
    MathOperation multiplication = new MultiplicationOperation();
    //when
    double result = multiplication.calculate(Integer.valueOf("3"), Integer.valueOf("3"));
    //then
    assertEquals(9.0, result);
  }

}
