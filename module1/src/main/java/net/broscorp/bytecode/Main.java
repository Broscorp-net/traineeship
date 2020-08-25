package net.broscorp.bytecode;

public class Main {
  /**
  * method main.
  * @param args args
  */
  public static void main(String[] args) {
    String number = "";
    for (int i = 0; i < 5; i++) {
      number += i;
    }
    System.out.println(helloWorld() + " " + number);
  }

  public static String helloWorld() {
    return "Hello world!";
  }
}
