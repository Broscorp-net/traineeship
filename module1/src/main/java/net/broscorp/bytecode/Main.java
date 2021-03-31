package net.broscorp.bytecode;

public class Main {

  public static void main(String[] args) {
    System.out.println("Hello" + increment(18, 59));
  }

  /**
   * increment and return value.
   */
  public static int increment(int value, int count) {
    int temp = value;
    for (; temp < value + count; temp++) {
      System.out.println("temp");
    }
    return temp;
  }
}
