package net.broscorp.strings;

import java.util.Random;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class StringManipulation {

  /**
   * returns true when the word is palindrome.
   */
  public boolean isPalindrome(String target) {
    String stringBuilder = new StringBuilder(target).reverse().toString();
    return stringBuilder.equals(target);
  }

  /**
   * removes the word 'World' and returns only 'Hello'.
   */
  public String onlyHello(String word) {
    return Stream.of(word)
        .map(i -> i.replaceFirst("World", "")
            .trim()).collect(Collectors.joining());
  }

  /**
   * removes letter in the word.
   */
  public String deleteLetterInWord(String word, char c) {
    char[] chars = word.toCharArray();
    StringBuilder str = new StringBuilder();
    for (char appendChar : chars) {
      if (appendChar != c) {
        str.append(appendChar);
      }
    }
    return str.toString();
  }

  /**
   * replace letter in the word.
   */
  public String replaceLetterInWord(String word, char regex, char replacement) {
    return word.replace(regex, replacement);
  }

  /**
   * shows statistics for the words.
   */
  public String wordStatistic(String word) {
    String[] s = word.split(" ");
    StringBuilder stringBuilder = new StringBuilder();
    for (String value : s) {
      stringBuilder.append(value)
          .append(" - ")
          .append(value.length())
          .append(" letters")
          .append("\n");
    }
    return stringBuilder.toString();
  }

  /**
   * returns some song.
   * bugs - number of bugs.
   * verse - number of verses.
   */
  public String lyrics(int bugs, int verse) {
    StringBuilder song = new StringBuilder();
    Random newRandom = new Random((long) bugs * verse);
    for (int i = 0; i < verse; i++) {
      int m = bugs - 10 + newRandom.nextInt(20);
      String oneVerse = String.format("%d little bugs in the code, \n"
          + "%d little bugs in the code. \n"
          + "Take one down, patch it around %d little bugs in the code.\n", bugs, bugs, m);
      song.append(oneVerse);
      bugs = m;
    }
    return song.toString();
  }
}
