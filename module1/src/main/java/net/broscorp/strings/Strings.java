package net.broscorp.strings;

import java.util.Arrays;
import java.util.Random;

public class Strings {

  /**
   * Checks string to be palindrom.
   * @param str String
   * @return boolean
   */
  public boolean palindrom(String str) {
    str = str.replace(" ","").replace(",","");
    char[] strs = str.toCharArray();
    String str2 = "";
    for (int i = strs.length - 1; i >= 0; i--) {
      str2 += strs[i];
    }
    return str2.equalsIgnoreCase(str.replace(" ",""));
  }

  private final String helloWorld = "Hello World";

  public String hello() {
    return helloWorld.split(" ")[0];
  }

  public  String ldel() {
    return helloWorld.replace("l","");
  }

  public  String change() {
    return helloWorld.replace("o","q");
  }

  /**
   *  {@inheritDoc}
   *  */
  public int reconLater() {
    String [] words = helloWorld.split(" ");
    Arrays.stream(words).forEach(w -> System.out.println(w + ":" + w.length()));
    return words.length;
  }

  /**
   *  {@inheritDoc}
   *  */
  public String song(int n, int couplet) {
    Random random = new Random(n * couplet);
    String coplets = "";
    for (int i = 0; i < couplet; i++) {
      int m;
      if (i == 0) {
        m = n - 10 + random.nextInt(20);
      } else {
        m = n;
      }
      coplets += String.format("%d little bugs in the code, \n"
          + "%d little bugs in the code. \n"
          + "Take one down, patch it around %d little bugs in the code."
          + "\n\n",n,n,m);
    }
    return coplets;
  }
}
