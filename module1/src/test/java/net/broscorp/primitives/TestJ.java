package net.broscorp.primitives;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;


public class TestJ {

  public static int inc(int i){
    return ++i;
  }

  public int intValue(long i){
    int x = (int) i;
    return x;
  }

  public float floatValue(double d){
    float f = (float) d;
    return f;
  }

  @Test
  public void isIntegerOverflow(){
    int i =  Integer.MAX_VALUE;
    Assertions.assertFalse(inc(i) == Integer.MIN_VALUE, "Переполнение численного типа");
  }

  @Test
  public void checkLongToInt(){
    long i = Long.MAX_VALUE;
    Assertions.assertEquals(intValue(i), i, "Изначальное значение не поместилось");
  }

  @Test
  public void checkDoubleToFloatOverflow(){
    double d = Double.MAX_VALUE;
    if (d == Double.POSITIVE_INFINITY) return;
    Assertions.assertFalse(floatValue(d) == Float.POSITIVE_INFINITY, "Изначальное значение не поместилось");
  }

  @Test
  public void checkDoubleToFloatAccuracy(){
    double d = 222222.2;
    System.out.println("act " + (double) floatValue(d));
    System.out.println("exp " + d);
    Assertions.assertTrue(Math.abs(floatValue(d) - d) < 0.000005, "Погрешность больше 0.000005");
  }
}
