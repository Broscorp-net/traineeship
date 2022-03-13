package net.broscorp.strings;

import java.util.Locale;
import java.util.Random;

public class StringRealization {

  /**.
   * @param line words.
   * @return This words palindrom or not.
   */
  public boolean isPalindrom(String line) {
    String lowerCaseLine = line.toLowerCase();
    return lowerCaseLine.equals(new StringBuilder(lowerCaseLine).reverse().toString());
  }

  public String splitWord(String word) {
    return word.split(" ")[0];
  }

  public String deleteLiteral(String word) {
    return word.replaceAll("l", "");
  }

  public String changeLiteral(String word) {
    return word.replaceAll("o", "q");
  }

  /**.
   * @param line just you line.
   * @return print all Words in line and count Letters.
   */
  public String printWordsAndCountLetters(String line) {
    String[] words = line.split(" ");
    int countLitters = 0;
    StringBuilder sb = new StringBuilder("Words : ");
    for (String str : words) {
      sb.append("\"").append(str).append("\" ");
      countLitters += str.replaceAll("[^a-zA-Zа-яёА-ЯЁ]", "").getBytes().length;
    }
    return sb.append("Count litters - ").append(countLitters).toString();
  }


  /**.
   * @param bugs count bugs.
   * @param couplets count couplets.
   * @return joined cuplets.
   */
  public String
  getVerse(int bugs, int couplets) {
    if (bugs <= 0 || couplets <= 0) {
      return "";
    }
    int nextIntValue = bugs * couplets;
    Random random = new Random();
    StringBuilder sb = new StringBuilder();
    for (int i = 0; i < couplets; i++) {
      int m = bugs - 10 + random.nextInt(nextIntValue);
      sb.append(joinCouplets(bugs, m));
      bugs = m;
    }
    return sb.toString();
  }

  private String joinCouplets(int bugs, int nextBugs) {
    String part1 = String.format("%d Little bugs in the code\n"
        + "%d Little bugs in the code\n", bugs, bugs);
    String part2 = String.format("Take one down, patch it around, %d little bugs in the code \n"
        + "\n", nextBugs);
    return String.format("%1$s%2$s", part1, part2);
  }

}
