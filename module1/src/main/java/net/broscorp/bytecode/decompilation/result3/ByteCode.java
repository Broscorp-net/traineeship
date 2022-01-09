/* Decompiler 16ms, total 416ms, lines 24 */

package net.broscorp.bytecode.decompilation.result3;

public class ByteCode {
  public static void main(String[] var0) {
    increase();
  }

  private static void increase() {
    int var0 = 0;

    for (int var1 = 0; var1 < 10; ++var1) {
      ++var0;
      if (var0 >= 9) {
        print(var0);
      }
    }

  }

  private static void print(int var0) {
    System.out.println("hello world" + var0);
  }
}
