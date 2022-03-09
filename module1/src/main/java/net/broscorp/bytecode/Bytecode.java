package net.broscorp.bytecode;

public class Bytecode {

  /**.
   * Test class.
   */
  public static void main(String[] args) {
    int a = 0;
    for (int i = 0; i < 5; i++) {
      a += 1;
    }
    String hello = "Hello world!";
    hello.length();
    System.out.println(hello);
  }
}
