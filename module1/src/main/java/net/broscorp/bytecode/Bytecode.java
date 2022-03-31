package net.broscorp.bytecode;

public class Bytecode {
  /** Main Method of Bytecode class. **/
  public static void main(String[] args) {
    int integer = 5;
    for (int i = 0; i < 10; i++) {
      integer++;
    }
    System.out.println(integer);
    greetings();
    for (String s: args) {
      System.out.println(s);
    }
  }

  public static void greetings() {
    System.out.println("Hello");
  }
}
