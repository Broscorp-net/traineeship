package net.broscorp.bytecode;

public class MyByteCode {

  public void printCount(int count) {
    System.out.println("Count is " + count);
  }

  /**
   * Main method invoke printCount.
   */
  public static void main(String[] args) {
    MyByteCode myByteCode = new MyByteCode();

    int count = 0;

    for (int i = 0; i < 20; i++) {
      count++;
    }

    myByteCode.printCount(count);

    System.out.println("Hello!!!");
  }

}
