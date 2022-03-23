package net.broscorp.bytecode;

public class BytecodeTask {

  /**
   * BytecodeTask with public static void main.
   */

  public static void main(String[] args) {
    int maxCounter = 15;
    for (int i = 0; i < maxCounter; ) {
      i = incrementIntValue(i);
    }
  }

  private static int incrementIntValue(int i) {
    i++;
    System.out.println("Hello #" + i);
    return i;
  }

}
