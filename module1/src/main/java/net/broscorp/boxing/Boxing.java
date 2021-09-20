package net.broscorp.boxing;

public class Boxing {

  /**{ @summary This is summary.}
   * @param a int.
   * @param b string.
   * @return boolean.
   */
  public static boolean returnTrue(int a, String b) {
    Integer i = a;
    Integer j = Integer.parseInt(b);
    if (i == j) {
      return true;
    } else {
      return false;
    }
  }

  /**{ @summary This is summary.}
   * @param a int.
   * @return boolean.
   */
  public static boolean returnFalseOne(int a) {
    Integer i = new Integer(a);
    Integer j = new Integer(a);
    return i == j;
  }

  /**{ @summary This is summary.}
   * @param a int.
   * @return boolean.
   * @throws Exception if less.
   */
  public static boolean returnFalseTwo(int a) throws Exception {
    if (a > 127 || a < -128) {
      Integer i = a;
      Integer j = a;
      return i == j;
    } else {
      throw new Exception();
    }
  }

  /**{ @summary This is summary.}
   * @return j int.
   */
  public static int returnException() {
    Integer i = null;
    int j = i.intValue();
    return j;
  }

}
