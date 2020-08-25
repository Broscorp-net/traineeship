package net.broscorp.boxing;

import org.junit.Assert;
import org.junit.Test;

public class BoxingTest {
  @Test
  public void compareWrappersInt() {
    Integer int1 =  new Integer(11);
    Integer int2 = 11;
    Assert.assertTrue(int1 == int2);
    //Минус сравнивания по "==" он сравнивает ссылку на обьекты а не их значение
  }

  @Test
  public void boxing() {
    int boxInt = 98;
    Integer integer = boxInt;
    Assert.assertSame(boxInt, integer);
  }

  @Test
  public void unBoxing() {
    Long lung = 88L;
    long unLong = lung;
    Assert.assertSame(lung, unLong);
  }
}
