package net.broscorp.strings;

import java.util.Arrays;

public class StringOperations {

  /**
   *isItPalindrome.
   *
   *
   */
  public boolean isItPalindrome(String a) {
    char[] chars = a.replaceAll(" ", "").toLowerCase().toCharArray();

    char[] rev = new char[chars.length];

    for (int i = 0; i < rev.length; i++) {

      rev[i] = chars[chars.length - 1 - i];
    }

    return Arrays.equals(chars, rev);
  }

  public String deleteWorld(String a) {

    return a.replaceAll("World", "").trim();
  }

  public String deleteAllL(String a) {

    return a.replaceAll("l", "");
  }

  public String replaceAllO(String a) {

    return a.replaceAll("o", "q");
  }

  /**
   * wordsList.
   *
   */
  public void wordsList(String a) {
    String[] strings = a.split(" ");

    for (String s : strings) {
      System.out.println(s + ": " + s.length());
    }
  }

  /**
   * singBagsSong.
   *
   *
   */
  public void singBagsSong(int bagsAmount, int versesAmount) {

    while (versesAmount > 0) {
      int m = (int) ((Math.random() * 10) + 1);
      for (int i = bagsAmount; i > 1; i--) {
        System.out.printf("%d little bugs in the code,\n", i);
      }
      System.out.printf("%d little bug in the code.\n", 1);
      if (m == 1) {
        System.out.printf("Take one down, patch it %d little bug in the code.\n", m);
      } else {
        System.out.printf("Take one down, patch it around %d little bugs in the code.\n", m);
      }
      bagsAmount = m;
      versesAmount--;
    }
  }
}
