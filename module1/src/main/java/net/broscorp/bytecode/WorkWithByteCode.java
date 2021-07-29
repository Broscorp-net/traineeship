package net.broscorp.bytecode;

public class WorkWithByteCode {

  public static void main(String[] args) {
    for (int i = 3; i > -2; i--) {
      callPrint(i);
    }
  }

  private static void callPrint(int num) {
    if (num >= 0) {
      System.out.println(num + "...");
    } else {
      System.out.println("ByteCode!!!");
    }
  }
}
