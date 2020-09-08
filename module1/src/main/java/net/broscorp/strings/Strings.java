package net.broscorp.strings;

import java.util.Random;

public class Strings {

  public boolean isPalindrom(String s) {
    String reverce = new StringBuilder().append(s).reverse().toString();
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
   * @param bugsCount  - bugs quantity from begin
   * @param coupletsAmount - couplet quantity
   * @return song text
   */
  public String getSongText(int bugsCount, int coupletsAmount) {
    String text = ""
        + "%d little bugs in the code,\n"
        + "%d little bugs in the code.\n"
        + "Take one down, patch it around %d little bugs in the code.\n";
    int bugs = bugsCount;
    int bugsAfterPatch;
    Random random = new Random(bugsCount * coupletsAmount);
    StringBuilder stringBuilder = new StringBuilder();

    for (int i = 0; i < coupletsAmount; i++) {
      bugsAfterPatch = bugs - 10 + random.nextInt(20);
      if (bugsAfterPatch < 0) bugsAfterPatch *= -1;
      stringBuilder.append(String.format(text, bugs, bugs, bugsAfterPatch));
      bugs = bugsAfterPatch;
    }
    return stringBuilder.toString();
  }
}
