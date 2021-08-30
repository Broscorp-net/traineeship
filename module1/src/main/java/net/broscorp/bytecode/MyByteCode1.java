package net.broscorp.bytecode;

public class MyByteCode1 {

  public static void printCount(int count) {
    System.out.println("Count in static method is " + count);
  }

  public static void main(String[] args) {

    int count = 0;

    for (int i = 0; i < 20; i++) {
      count++;
    }

    printCount(count);

    System.out.println("Hello!!!");
  }

}
