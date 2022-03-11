package net.broscorp.bytecode;

public class Main {
  static int a = 0;

  static void increment()  {
    a++;
  }

  /**
   * Bytecode increment sample.
   */
  public static void main(String[] args) {
    for (int i = 0; i < 20; i++)  {
      increment();
    }
    System.out.println("Hello!");
  }
}
