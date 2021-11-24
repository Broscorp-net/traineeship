package net.broscorp.primitives;

public class Primitives {

  public int add(int a, int b) {
    return a + b;
  }

  public int conversion(long a) {
    return (int) a;
  }

  public double conversion2(float a) {
    double b = a;
    return b;
  }

  /**
   * Some javadoc. // OK
   *
   * @author Some javadoc. // OK
   * @since Some javadoc. // OK
   * @serialData // OK
   */
  public double count(int a) {
    double number = 0;
    for (int i = 0; i < a; i++) {
      number = number + 0.001;
    }
    return number;
  }

}
