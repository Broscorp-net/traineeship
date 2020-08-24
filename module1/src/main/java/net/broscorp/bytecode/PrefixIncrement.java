package net.broscorp.bytecode;

public class PrefixIncrement {
  /**
   * Префиксальный инкремент.
   */
  public static void main(String[] args) {
    int val = 1;
    for (int i = 0; i < 10; i++) {
      ++val;
    }
    System.out.println("Hello, this is prefix increment - " + val);
  }
}