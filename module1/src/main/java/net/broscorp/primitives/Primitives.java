package net.broscorp.primitives;

import java.math.BigDecimal;
import java.math.RoundingMode;

public class Primitives {

  /**{ @summary This is summary.}
   * @param a float.
   * @return boolean.
   */
  public static boolean intToByte(int a) {
    byte num = (byte) a;
    if (num != a) {
      return false;
    } else {
      return true;
    }
  }

  /**{ @summary This is summary.}
   * @param a long.
   * @return int.
   */
  public static int longToInt(long a) {
    if (a >= -2147483648 && a <= 2147483647) {
      return (int) a;
    } else {
      return -1;
    }
  }

  public static double floatToDoubleVarOne(float a) {
    return (double) a;
  }

  public static double floatToDoubleVarTwo(float a) {
    String newVar = Float.toString(a);
    return Double.parseDouble(newVar);
  }

  /**{ @summary This is summary.}
   * @param a float.
   * @return double.
   */
  public static double floatToDoubleVarThree(float a) {
    BigDecimal bd = BigDecimal.valueOf((double) a);
    bd = bd.setScale(2, RoundingMode.DOWN);
    return bd.doubleValue();
  }

}
