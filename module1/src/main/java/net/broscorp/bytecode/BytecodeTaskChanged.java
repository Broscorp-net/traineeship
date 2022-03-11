package net.broscorp.bytecode;

public class BytecodeTaskChanged {



  /**
   * BytecodeTaskChanged with public static void main.
   */

  public static void main(String[] args) {
    int maxCounter = 15;
    for (int i = 0; i < maxCounter; ) {
      i = incrementIntValue(i);
    }
    System.out.println("Hello");

  }

  private static int incrementIntValue(int i) {
    i++;
    return i;
  }

}
