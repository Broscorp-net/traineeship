package net.broscorp.bytecode;
/**
 * Program Hello.
 *
 * @author  Dmitriy Tverdokhlibov
 * @version  1.0
 * @since 2021-08-30
 */

public class Hello {
  /**.
   * The class code changes and analyze
   * how the bytecode changes
   */
  public static void main(String[] args) {
    int count = 0;
    while (count < 1) {
      draw();
      System.out.println("Hello! I'm BRO BOT!");
      count++;
    }
  }

  private static void draw() {
    System.out.println("       ___      ");
    System.out.println("----- |*_*| -----");
    System.out.println("     BRO BOT      ");
  }
}
