package net.broscorp.bytecode;

public class ByteCode {

  static void printHello() {

    System.out.println("Hello World");
  }

  static void increment(int a) {
    for (int i = 0; i <= 100; i++) {
      a++;
    }
    System.out.println(a);
  }

  public static void main(String[] args) {
    increment(0);
    printHello();
  }
}
