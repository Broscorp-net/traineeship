package net.broscorp.bytecode;

public class BytecodeMe {

  private static int anInt = 0;

  private static void increment() {
    while (anInt < 100) {
      anInt += 1;
    }
  }

  /** Entry point.
   */
  public static void main(String[] args) {
    System.out.println("anInt = " + anInt);
    System.out.println("Incrementing anInt");
    increment();
    System.out.println("anInt = " + anInt);
  }
}
