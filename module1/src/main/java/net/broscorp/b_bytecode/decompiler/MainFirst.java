package net.broscorp.b_bytecode.decompiler;/*   0 */ import net.broscorp.b_bytecode.MainFirst;
/*   0 */ 
/*   0 */ public class MainFirst {
/*   0 */   public static void main(String[] paramArrayOfString) {
/*   6 */     byte b1 = 0;
/*   8 */     for (byte b2 = 0; b2 < 10; b2++)
/*   9 */       b1++; 
/*  12 */     write("Hello, count after for: " + b1);
/*   0 */   }
/*   0 */   
/*  16 */   public static void write(String paramString) { System.out.println(paramString); }
/*   0 */ }
