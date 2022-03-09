package test.java.net.broscorp.boxing;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.Test;

public class BoxingTest {

  @Test
  public void showcaseTrueWrapperTest() {
    String firstNumber = "We are the same object";
    String secondNumber = "We are the same object";
    assertTrue(firstNumber == secondNumber);
  }

  @Test
  public void showcaseFirstFalseWrapperTest() {
    String firstString = new String("We are not the same object");
    String secondString = new String("We are not the same object");
    assertFalse(firstString == secondString);
  }

  @Test
  public void showcaseSecondFalseWrapperTest() {
    Double firstNumber = 3.14;
    Double secondNumber = 3.14;
    //Same number
    assertTrue(firstNumber.equals(secondNumber));
    //Not the same object
    assertFalse(firstNumber == secondNumber);
  }

  @Test
  public void showcaseThirdFalseWrapperTest() {
    Integer firstNumber = 3;
    Integer secondNumber = 3;
    Integer thirdNumber = 3000;
    Integer fourthNumber = 3000;
    //Same because JVM caches Integer values between -128 and 127
    assertTrue(firstNumber == secondNumber);
    //Not the same
    assertFalse(thirdNumber == fourthNumber);
  }

  @Test
  public void showcaseUnboxingExceptionTest() {
    Integer problem = null;
    Exception e = assertThrows(NullPointerException.class, () -> {
      //int cant be null
      int number = problem;
    });
  }
}
