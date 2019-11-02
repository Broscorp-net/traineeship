package net.broscorp.b_bytecode.decompiler;/*
/*   0 */ 
/*   0 */ public class MainSecond {
/*   0 */   public static void main(String[] paramArrayOfString) {
/*   6 */     int[] arrayOfInt = new int[10];
/*   8 */     for (byte b = 0; b < arrayOfInt.length; b++) {
/*   9 */       arrayOfInt[b] = b;
/*  10 */       write("Hello, count inside for: " + arrayOfInt[b]);
/*   0 */     } 
/*   0 */   }
/*   0 */   
/*  15 */   public static void write(String paramString) { System.out.println(paramString); }
/*   0 */ }
