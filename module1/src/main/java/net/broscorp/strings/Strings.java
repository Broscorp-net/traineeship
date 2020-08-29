package net.broscorp.strings;

import java.util.Random;

public class Strings {

  public boolean isPalindrom(String s) {
    String reverce = new StringBuffer().append(s).reverse().toString();
    return s.equalsIgnoreCase(reverce);
  }

  public String firstWord(String s) {
    return s.substring(0, s.indexOf(" "));
  }

  // по условиям задачи не понятно нужно ли заменять L...
  public String replace_l(String s) {
    return s.replaceAll("l", "");
  }

  // тот же вопрос с Uppercase
  public String replace_o_to_q(String s) {
    return s.replaceAll("o", "q");
  }

  /**
   * print words, and it's length.
   */
  public void wordsListWithCharsCount(String s) {
    String[] words = s.split(" ");
    for (String word : words) {
      System.out.println(word + " - has " + word.length() + " chars");
    }
  }

  /**
   * create variable song text.
   * @param bugs - bugs quantity from begin
   * @param couplet - couplet quantity
   * @return song text
   */
  public String getSongText(int bugs, int couplet) {
    String text = ""
        + "%d little bugs in the code,\n"
        + "%d little bugs in the code.\n"
        + "Take one down, patch it around %d little bugs in the code.\n";
    int n = bugs;
    int m;
    Random random = new Random(bugs * couplet);
    StringBuffer sb = new StringBuffer();

    for (int i = 0; i < couplet; i++) {
      m = n - 10 + random.nextInt(20);
      sb.append(String.format(text, n, n, m));
      n = m;
    }
    return sb.toString();
  }
}
