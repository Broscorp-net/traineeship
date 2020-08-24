package net.broscorp.bytecode;

public class PostfixIncrement {

  public static void main(String[] args) {
    int val = 1;
    System.out.println("Hello, this is post increment - " + incrementVariable(val));
  }

  private static int incrementVariable(int val) {
    for (int i = 0; i < 10; i++) {
      val++;
    }
    return val;
  }
}
