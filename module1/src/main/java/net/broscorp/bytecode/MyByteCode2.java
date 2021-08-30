package net.broscorp.bytecode;

public class MyByteCode2 {
  public void printCount(int count) {
    System.out.println("Count with incrementation 50 is " + count);
  }

  public static void main(String[] args) {
    MyByteCode2 myByteCode2 = new MyByteCode2();

    int count = 0;

    for (int i = 0; i < 50; i++) {
      count++;
    }

    myByteCode2.printCount(count);

    System.out.println("Hello!!!");
  }

}
