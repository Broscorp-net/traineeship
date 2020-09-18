package net.broscorp.bytecode;

public class Bytecode {
  /**
   * comment for checker.
   */
  private static int digit = 0;

  public static int increament() {
    return 10;
  }

  /**
   * method before changed. public static void increament() { for (int i = 0; i < 10; i++) {
   * digit++; } } }.
   */

  public static void main(String[] args) {

    System.out.println("Before increament");
    System.out.println(digit);
    System.out.println("After increament");
    digit = increament();
    System.out.println(digit);
  }
}
