package net.broscorp.bytecode;

public class BytecodeExample {

  /**
   * Entry point.
   * @param args external arguments
   */
  public static void main(String[] args) {

    int i = 0;

    for (int k = 0; k < 10; k++) {
      System.out.println("Step - " + i);
      i = incrementAndGet(i);
    }

    System.out.println("Hello, world!");
  }

  private static int incrementAndGet(int i) {
    return i + 1;
  }

}
