package net.broscorp.strings;

import java.util.HashMap;
import java.util.Map;
import java.util.Random;

public class MyStringUtils {

  /**
   * Check if word is palindrome.
   *
   * @param str word to check
   * @return true if word is palindrome, else - false
   */
  public boolean isPalindrome(String str) {
    if (!isEmpty(str)) {
      return false;
    }

    str = str.trim().toLowerCase();

    StringBuilder sb = new StringBuilder(str);
    String reversed = sb.reverse().toString();

    return str.equals(reversed);
  }

  /**
   * Returns searched value in the string, else null.
   *
   * @param text  string to search in
   * @param value string to find
   * @return value if input string contains it, else - null
   */
  public String returnValueIfContains(String text, String value) {
    boolean isPresent = text.contains(value);

    if (isPresent) {
      return value;
    }

    return null;
  }

  /**
   * Removes all mentioned characters in the string.
   *
   * @param text   input text
   * @param letter letter to remove
   * @return string without mentioned characters
   */
  public String removeAllLetters(String text, char letter) {
    if (!isEmpty(text)) {
      return null;
    }

    return text.replaceAll(String.valueOf(letter), "");
  }

  /**
   * Replaces all 'o' character to 'q' character.
   *
   * @param text text
   * @return string
   */
  public String replaceOToQ(String text) {
    return text.replaceAll("o", "q");
  }

  /**
   * Calculates word's length.
   *
   * @param text text
   * @return map in which key - word, value - length of the word
   */
  public Map<String, Integer> getWordsLengths(String text) {
    if (!isEmpty(text)) {
      return null;
    }

    String[] words = text.split(" ");

    Map<String, Integer> map = new HashMap<>();
    for (String word : words) {
      map.put(word, word.length());
    }

    return map;
  }

  /**
   * Creates song about bugs in the code.
   *
   * @param bugsNumber   number of bugs
   * @param versesNumber number of verses
   * @return full song
   */
  public String createSong(int bugsNumber, int versesNumber) {
    String verse = "%d little bugs in the code, \n"
        + "%d little bugs in the code. \n"
        + "Take one down, patch it around %d little bugs in the code.\n\n";

    Random random = new Random(bugsNumber * versesNumber);
    StringBuilder sb = new StringBuilder();

    for (int i = 0; i < versesNumber; i++) {
      int m = bugsNumber - 10 + random.nextInt(20);
      sb.append(String.format(verse, bugsNumber, bugsNumber, m));

      bugsNumber = m;
    }

    return sb.toString();
  }

  private boolean isEmpty(String str) {
    return str == null || !str.trim().isEmpty();
  }

}
