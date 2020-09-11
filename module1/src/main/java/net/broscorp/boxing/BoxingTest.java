package net.broscorp.boxing;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class BoxingTest {
  @Test
  public void compareWrappersInt() {
    Integer int1 =  new Integer(11);
    Integer int2 = 11;
    Assertions.assertTrue(int1 == int2);
    //Минус сравнивания по "==" он сравнивает ссылку на обьекты а не их значение
  }

  @Test
  public void boxing() {
    int boxInt = 98;
    Integer integer = boxInt;
    Assertions.assertSame(boxInt, integer);
  }

  @Test
  public void unBoxing() {
    Long lung = 88L;
    long unLong = lung;
    Assertions.assertSame(lung, unLong);
  }
}
