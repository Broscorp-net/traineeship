package net.broscorp.bytecode;

public class WorkWithByteCode {

  /**
   * Work with byte code.
   */

  public static void main(String[] args) {
    for (int i = 5; i > -2; i--) {
      callPrint(i);
    }
  }

  private static void callPrint(int num) {
    if (num >= 0) {
      System.out.println(num + "...");
    } else {
      System.out.println("ByteCode!!!");
      System.out.println("Changed");
    }
  }
}
