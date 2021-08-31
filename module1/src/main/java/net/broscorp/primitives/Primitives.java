package net.broscorp.primitives;

import java.math.BigDecimal;
import java.math.RoundingMode;

public class Primitives {
  public static boolean intToByte(int a){
    byte num = (byte) a;
    if (num==a){
      return true;
    }else{
      return false;
    }
  }

  public static int longToInt(long a) {
    if (a >= -2147483648 && a <= 2147483647) {
      int newVar = (int) a;
      return newVar;
    } else {
      return -1;
    }
  }

  public static double floatToDoubleVarOne(float a){
    return (double) a;
  }

  public static double floatToDoubleVarTwo(float a){
    String newVar =Float.toString(a);
    return Double.parseDouble(newVar);
  }

  public static double floatToDoubleVarThree(float a){
    BigDecimal bd = BigDecimal.valueOf((double) a);
    bd = bd.setScale(2, RoundingMode.DOWN);
    return bd.doubleValue();
  }

}
