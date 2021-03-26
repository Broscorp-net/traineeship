package net.broscorp.strings;

import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Random;

public class StringOperation {

  /**
   * check string for palindrome.
   *
   * @param str input string
   * @return boolean
   */
  public boolean isPalindrome(String str) {
    String reverse = new StringBuilder(str)
        .reverse()
        .toString();
    return str.equals(reverse);
  }

  /**
   * return Hello if exist.
   *
   * @param input string
   * @return Hello if exist
   */
  public String cutHello(String input) {
    String[] str = input.split(" ");
    for (int i = 0; i < str.length; i++) {
      if (str[i].equals("Hello")) {
        return str[i];
      }
    }
    return "Hello doesn`t exist";
  }

  /**
   * Remove all letters l in string.
   *
   * @param input string
   * @return string with remove all letters l
   */
  public String removeL(String input) {
    return input.replace("l", "");
  }

  /**
   * Replace all letters o and q.
   *
   * @param input string
   * @return string with replace letters o and q
   */
  public String replaceOAndQ(String input) {
    return input.replace("o", "q");
  }

  /**
   * Print words and quantity letters in words.
   *
   * @param input string
   */
  public void printLetterAndWords(String input) {
    String[] array = input.split(" ");
    StringBuilder builder = new StringBuilder();
    for (int i = 0; i < array.length; i++) {
      builder.append(String.format("Word : %s with "
          + "quantity letters : %d\n", array[i], array[i].length()));
    }
    System.out.println(builder);
  }

  /**
   * Method consumes quantity bugs and verses and return text of song.
   *
   * @param bugsQuantity   quantity bugs
   * @param versesQuantity quantity verses
   * @return text Song
   */
  public String textSong(int bugsQuantity, int versesQuantity) {
    Random random = new Random(bugsQuantity * versesQuantity);
    String songText = "%d little bugs in the code, \n"
        + "%d little bugs in the code. \n"
        + "Take one down, patch it around %d little bugs in the code.\n";
    StringBuilder builder = new StringBuilder();
    int n = bugsQuantity;
    for (int i = 0; i < versesQuantity; i++) {
      int m = n - 10 + random.nextInt(20);
      builder.append(String.format(songText, n, n, m));
      n = m;
    }
    return builder.toString();
  }
}
