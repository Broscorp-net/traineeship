package net.broscorp.bytecode;
/**
 * bytecode task.
 * @author Nikita Oleksin
 * @version 1.0
 */

public class Main {
  /**
   * main method.
   * @param args - params
   */
  public static void main(String[] args) {
    int i = 2;
    while (i++ < 8) {
      System.out.println("i = " + i);
    }

    i = print(5545);

    System.out.println("new i = " + i);
    System.out.println("Hello World! by Nikita");
  }

  /**
   * print method.
   * @param tmp - user value
   * @return int
   */
  public static int print(int tmp) {
    tmp += 10;
    return tmp;
  }
}
