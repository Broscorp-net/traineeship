package net.broscorp.boxing;

public class Boxing {

  /**
   * Comparison method for 2 identical wrapper types.
   */

  public static boolean comparisonOfWrapperTypes(Integer var1, Integer var2) {
    if (var1 != var2) {
      return false;
    }
    return true;
  }

  /**
   * Demonstration of getting an error when implicitly unboxing.
   */

  public static int demonstrationOfGettingAnError(Integer var1) {
    int var2 = 0;
    try {
      var2 = var1;
      return var2;
    } catch (NullPointerException e) {
      System.out.println("Null value cannot be converted to int ");
    }
    return var2;
  }
}
