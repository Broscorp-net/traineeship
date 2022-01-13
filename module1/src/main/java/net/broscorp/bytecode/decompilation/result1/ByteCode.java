/* Decompiler 15ms, total 12652ms, lines 22 */

package net.broscorp.bytecode.decompilation.result1;


public class ByteCode {
  public static void main(String[] var0) {
    increase();
    print();
  }

  private static void increase() {
    int var0 = 0;
    for (int var1 = 0; var1 < 10; ++var1) {
      ++var0;
    }
  }

  private static void print() {
    System.out.println("hello world");
  }
}
