package net.broscorp.bytecode;

public class CheckCode {

  private static int incr = 0;

  /**
   * Main method for class CheckCode.
   *
   * @param args - argument for console
   */
  public static void main(String[] args) {
    System.out.println("Hello!\nDear user.");
    for (incr = 0; incr <= 10; incr++) {
      System.out.println(method(incr));
    }
  }

  private static Integer method(Integer q) {
    System.out.println("Method start");
    return q * q;
  }
}
