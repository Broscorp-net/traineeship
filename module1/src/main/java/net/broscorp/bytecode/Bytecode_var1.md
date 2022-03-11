Compiled from "TestApp.java"
public class net.broscorp.bytecode.TestApp {
  public net.broscorp.bytecode.TestApp();
    Code:
       0: aload_0
       1: invokespecial #1                  // Method java/lang/Object."<init>":()V
       4: return

  public static void main(java.lang.String[]);
    Code:
       0: iconst_0
       1: istore_1
       2: iload_1
       3: iconst_5
       4: if_icmpge     13
       7: iinc          1, 1
      10: goto          2
      13: invokestatic  #2                  // Method helloMethod:()V
      16: return
}
