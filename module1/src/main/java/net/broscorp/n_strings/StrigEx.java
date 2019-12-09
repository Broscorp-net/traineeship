package net.broscorp.n_strings;

import java.util.Random;

public class StrigEx {

  public boolean isPalindrome(String s){
    return s.equalsIgnoreCase(new StringBuilder(s).reverse().toString());
  }

  public String dellL(String s){
    return s.replace("l", "");

  }
  public String replaceOnQ(String s){
    return s.replace("o", "q");
  }

  public String justHello(String s){
    StringBuilder strB= new StringBuilder();
    char[] arr = s.toCharArray();
    for(char c: arr){
      if (String.valueOf(c).equals(" ")){
        break;
      }
      strB.append(c);
    }
    s = new String(strB);
    return s;
  }
  public void counter(String s){
    StringBuilder strB= new StringBuilder();
    char[] arr = s.trim().toCharArray();
    for(char c: arr) {
      if (String.valueOf(c).equals(" ")){
        System.out.println( strB + " chars = " +strB.length());
        strB = new StringBuilder();
      }else {
        strB.append(c);
      }
    }
    System.out.println( strB + " chars = " +strB.length());
  }

  public void format(int bags, int couplets) {
    Random random = new Random(bags*couplets);
    for (int i = 0; i < couplets; i++) {
      int m = bags - 10 + random.nextInt(20);
      if (m<0)m =0;
      if (bags<0)bags =0;
      String s = String.format("%d little bugs in the code, \n"
          + "%d little bugs in the code. \n " +
          "Take one down, patch it around %d little bugs in the code.", bags, bags, m);
      bags = m;
      System.out.println(s);
    }

  }
}
