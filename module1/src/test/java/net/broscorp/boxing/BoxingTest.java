package net.broscorp.boxing;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class BoxingTest {

  int firstPrimitiveNumber = 2;
  int secondPrimitiveNumber = 2;

  Integer firstNumber;
  Integer secondNumber;

  //task1
  // in this case two variables reference to one object Integer type
  @Test
  void isWrappersEqual() {
    firstNumber = Integer.valueOf(firstPrimitiveNumber);
    secondNumber = Integer.valueOf(secondPrimitiveNumber);
    Assertions.assertTrue(firstNumber == secondNumber);
  }

  //task2
  // in this test we get false, the whole thing is in the cache of IntegerCache.class
  @Test
  void whenWrapperIsNotEqualThroughCash() {
    firstNumber = 50;
    secondNumber = firstNumber;
    System.out.println(firstNumber == secondNumber);
    firstNumber = 200;
    secondNumber = 200;
    Assertions.assertFalse(firstNumber == secondNumber);
  }

  //task2
  // in this case two objects have different own reference
  @Test
  void whenWrapperIsNotEqual() {
    firstNumber = new Integer(8);
    secondNumber = new Integer(8);
    Assertions.assertFalse(firstNumber == secondNumber);
  }

  //task3
  //we can't assign null to primitive data type
  @Test
  void troughNullPointException() {
    firstNumber = null;
    Assertions.assertThrows(NullPointerException.class, () -> firstPrimitiveNumber = firstNumber);
  }

}
