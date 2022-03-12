package net.broscorp.bytecode;

public class ByteCodeExample {
  public static void main(String[] args) {
    int dummy = 0;

    for (int i = 0; i < 10; i++) {
      dummy++;
    }

    printHelloAndIntValue(dummy);
  }

  private static void printHelloAndIntValue(int i) {
    System.out.println("Hello, the value is " + i);
  }
}
