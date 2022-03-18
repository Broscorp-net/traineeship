package net.broscorp.strings;

import java.util.Arrays;
import java.util.Random;

public class StringOperations {

  /**
   * check for palindrome.
   * @param text text
   * @return boolean
   */
  public boolean isPalindrome(String text) {
    return text.replaceAll(" ", "")
        .equalsIgnoreCase(new StringBuilder(text.replaceAll(" ", ""))
            .reverse().toString());
  }

  /**
   * return first world from phrase.
   * @param text text
   * @return String
   */
  public String saveFirstWordInText(String text) {
    String[] array = text.split(" ");
    return array[0];
  }

  /**
   * remove letter l.
   * @param text text
   * @return String
   */
  public String removeLetterL(String text) {
    return text.replaceAll("l", "");
  }

  /**
   * change letter o on q.
   * @param text text
   * @param changedLetter changed letter
   * @param newLetter new letter
   * @return String
   */
  public String changeSomeLetters(String text, String changedLetter, String newLetter) {
    return text.replaceAll(changedLetter, newLetter);
  }

  /**
   * return word statistic in phrase.
   * @param text text
   * @return String
   */
  public String wordStatistic(String text) {
    StringBuilder sb = new StringBuilder();

    Arrays.asList(text.split(" "))
        .forEach(s -> sb.append(s).append(" -> ").append(s.length()).append("\n"));

    return sb.toString();
  }

  /**
   * construct song.
   * @param bugs bugs count
   * @param couplets couplets count
   * @return String
   */
  public String getSong(int bugs, int couplets) {
    StringBuilder sb = new StringBuilder();
    Random random = new Random((long) bugs * couplets);
    int m;

    for (int i = 0; i < couplets; i++) {
      m = bugs - 10 + random.nextInt(20);
      sb.append(bugs).append(" little bugs in the code,\n");
      sb.append(bugs).append(" little bugs in the code.\n");
      sb.append("Take one down, patch it around ").append(m).append(" little bugs in the code.\n");
      bugs = m;
    }
    return sb.toString();
  }
}
