package net.broscorp.strings;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

/**
 * Class describing the main functionality.
 * @author Hryhorii Perets
 * @version 1.0
 */
public class Philologist {

  /**
   * Checking string for palindrome.
   * @param str input string
   * @return result true or false
   */
  public boolean isPalindrome(String str) {
    if (str != null) {
      String newStr = str.toLowerCase().replaceAll("\\s", "");
      int n = newStr.length();

      for (int i = 0; i < (n / 2); ++i) {
        if (newStr.charAt(i) != newStr.charAt(n - i - 1)) {
          return false;
        }
      }
      return true;
    }
    return false;

  }

  /**
   * Cut word from string.
   * @param originStr input string
   * @param cutStr string to be cut
   * @return output string or null
   */
  public String cutWord(String originStr, String cutStr) {
    if (originStr != null) {
      return originStr.replaceAll(cutStr, "").trim();
    }
    return null;
  }

  /**
   * Delete char from word.
   * @param originStr input string
   * @param ch remove character
   * @return output string or null
   */
  public String deleteChar(String originStr, char ch) {
    if (originStr != null) {
      return originStr.replaceAll("" + ch, "");
    }
    return null;
  }

  /**
   * Replace character in string.
   * @param originStr input string
   * @param oldChar first char
   * @param newChar second char
   * @return output string or null
   */
  public String replaceChar(String originStr, char oldChar, char newChar) {
    if (originStr != null) {
      return originStr.replace(oldChar, newChar);
    }
    return null;
  }

  /**
   * Split string for array.
   * @param str input string
   * @return output array strings
   */
  public String[] splitString(String str) {
    String[] strings;
    if (str != null) {
      strings = str.split(" ");
      return strings;
    }
    return null;
  }

  /**
   * Return list words and lengths.
   * @param strings base string
   * @return words with lengths
   */
  public List<String> getWordWithLength(String[] strings) {
    if (strings != null) {
      List<String> wordsAndLengths = new ArrayList<>();
      for (String word: strings) {
        wordsAndLengths.add(word + " " + word.length());
      }
      return wordsAndLengths;
    }
    return null;
  }


  /**
   * Random song with bags and verses.
   * @param bugs number of bags
   * @param verses number of verses
   * @return The song with same verses
   */
  public String randomSong(int bugs, int verses) {
    Random random = new Random(bugs * verses);
    StringBuilder stringBuilder = new StringBuilder();
    for (int i = 0; i < verses; i++) {
      int m = Math.abs(bugs - 10 + random.nextInt(20));
      stringBuilder.append(bugs + " little bugs in the code,\n");
      stringBuilder.append(bugs + " little bugs in the code.\n");
      stringBuilder.append("Take one down, patch it around " + m + " little bugs in the code.\n");
      bugs = m;
    }
    return stringBuilder.toString();
  }

}
