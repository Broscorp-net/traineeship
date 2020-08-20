package net.broscorp.bytecode;

public class Main {

  public static void main(String[] args) {
    for (int i = 0; i < 10; i++) {
      System.out.println(i);
    }

    show("Paul");
    show("Paul");

    System.out.println("Hello World");
    System.out.println("Hello World");
  }

  public static void show(String name) {
    System.out.println(name);
  }
}
