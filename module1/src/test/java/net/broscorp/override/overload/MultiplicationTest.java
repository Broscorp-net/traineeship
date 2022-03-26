package net.broscorp.override.overload;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

public class MultiplicationTest {
  Multiplication math = new Multiplication();

  @Test
  public void multiplicationDoubleTest() {
    System.out.println("Multiplication double Test start");
    assertEquals(30.25, math.arithmeticOperation(5.5, 5.5));
  }

  @Test
  public void multiplicationIntTest() {
    System.out.println("Multiplication int Test start");
    assertEquals(25, math.arithmeticOperation(5, 5));
  }

  @Test
  public void multiplicationIntegerTest() {
    System.out.println("Multiplication Integer wrapper Test start");
    Integer x = 6;
    Integer y = 6;
    assertEquals(36, math.arithmeticOperation(x, y));
  }

  @Test
  public void multiplicationDoubleWrapperTest() {
    System.out.println("Multiplication Double wrapper Test start");
    Double x = 5.5;
    Double y = 5.5;
    assertEquals(30.25, math.arithmeticOperation(x, y));
  }

  @Test
  public void multiplicationMixedTest() {
    System.out.println("Multiplication Mixed Test start");
    //This would have a compile time error, because both primitive and wrapper versions match
    //Integer x = 6;
    //assertEquals(12, math.arithmeticAddition(6, x));

    //This would have a compile time error, because both primitive and wrapper versions match
    //Double y = 6.0;
    //assertEquals(12, math.arithmeticAddition(6.0, y));

    //Here primitive double method is called
    Double z = 6.0;
    assertEquals(36, math.arithmeticOperation(6, z));

    //Here primitive double method is called
    Integer a = 6;
    assertEquals(36, math.arithmeticOperation(6.0, a));
  }
}