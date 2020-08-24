package net.broscorp.bytecode;

public class Main {

  /**
   * @author Yulian Belov
   */
  public static void main(String[] args) {

    int a = 0;

    while (a < 100) {
      a++;
    }

    sayHello();

  }

  public static void sayHello() {

    System.out.println("Hello!");
  }

}
