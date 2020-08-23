package net.broscorp.bytecode;

public class BytecodeMe2 {

  private int anInt;

  private void hello() {
    System.out.println("Hello!");
  }

  public BytecodeMe2(int anInt) {
    this.anInt = anInt;
  }

  public BytecodeMe2() {
  }

  /** Entry point.
   */
  public static void main(String[] args) {
    BytecodeMe2 obj = new BytecodeMe2(0);
    System.out.println("anInt = " + obj.anInt);
    System.out.println("Incrementing anInt");
    for (int i = 0; i < 100; i++) {
      obj.anInt += 1;
    }
    System.out.println("anInt = " + obj.anInt);
  }
}
