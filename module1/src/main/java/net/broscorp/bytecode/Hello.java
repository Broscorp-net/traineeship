package net.broscorp.bytecode;

public class Hello {

  public static void main(String[] args) {
    int count = 0;
    while (count < 1) {
      draw();
      System.out.println("Hello! I'm BRO BOT!");
      count++;
    }
  }

  private static void draw() {
    System.out.println("       ___      ");
    System.out.println("----- |*_*| -----");
    System.out.println("     BRO BOT      ");
  }
}
