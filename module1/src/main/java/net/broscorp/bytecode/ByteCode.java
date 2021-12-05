package net.broscorp.bytecode;

public class ByteCode {

  /**.
  * Test class
  */
  public static void main(String[] args) {
    int x = 1;
    for (int i = 0; i < 5; i++) {
      x++;
    }
    System.out.println(x);
    someMethod();
    helloMethod();
  }

  static void someMethod() {
    int a = 1;
    int b = 2;
    System.out.println(a + b);
  }

  static void helloMethod() {
    System.out.println("Hello world");
  }
}
