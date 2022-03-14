package net.broscorp.override.overload;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

public class MathAdditionTest {

  @Test
  public void additionDoubleTest() {
    MathAddition math = new MathAddition();
    assertEquals(11, math.arithmeticAddition(5.5, 5.5));
  }

  @Test
  public void additionIntTest() {
    MathAddition math = new MathAddition();
    assertEquals(10, math.arithmeticAddition(5, 5));
  }

  @Test
  public void additionIntegerTest() {
    MathAddition math = new MathAddition();
    Integer x = 6;
    Integer y = 6;
    assertEquals(12, math.arithmeticAddition(x, y));
  }

  @Test
  public void additionDoubleWrapperTest() {
    MathAddition math = new MathAddition();
    Double x = 5.5;
    Double y = 5.5;
    assertEquals(11, math.arithmeticAddition(x, y));
  }

  @Test
  public void additionMixedTest() {
    MathAddition math = new MathAddition();

    //This would have a compile time error, because both primitive and wrapper versions match
    //Integer x = 6;
    //assertEquals(12, math.arithmeticAddition(6, x));

    //This would have a compile time error, because both primitive and wrapper versions match
    //Double y = 6.0;
    //assertEquals(12, math.arithmeticAddition(6.0, y));

    //Here primitive double method is called
    Double z = 6.0;
    assertEquals(12, math.arithmeticAddition(6, z));

    //Here primitive double method is called
    Integer a = 6;
    assertEquals(12, math.arithmeticAddition(6.0, a));
  }
}