package net.broscorp.bytecode;

public class ByteCode {

  /**
  * Some javadoc. // OK
  */
  public static void main(String[] args) {
    increase();
  }

  private static void increase() {
    int x = 0;
    for (int i = 0; i < 10; i++) {
      x++;
      if (x >= 9) {
        print(x);
      }
    }
  }

  private static void print(int x) {
    System.out.println("hello world" + x);
  }

}
