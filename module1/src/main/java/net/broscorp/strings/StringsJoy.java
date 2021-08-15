/*
 * Copyright (c) 2021.
 * Danylo Havrylchenko
 * GitHub: @akellanotavailable
 */

package net.broscorp.strings;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.stream.IntStream;

public class StringsJoy {

  public static final String SONG_TEXT = "\n\n%d little bugs in the code, \n"
      + "%d little bugs in the code. \n"
      + "Take one down, patch it around %d little bugs in the code.";

  /**
   * Method checks given string whether it is palindrome or not.
   *
   * @param string string to check.
   * @return boolean true - is palindrome; false - is not palindrome.
   */
  public static boolean isPalindrome(String string) {
    String temp = string.replaceAll("\\s+", "").toLowerCase();
    return IntStream.range(0, temp.length() / 2)
        .noneMatch(i -> temp.charAt(i) != temp.charAt(temp.length() - i - 1));
  }

  /**
   * Cuts string to single "Hello" word.
   *
   * @param string string to be cut.
   * @return "Hello" if string contained it, "" if not.
   */
  public static String cutToHello(String string) {
    Pattern pattern = Pattern.compile("Hello");
    Matcher matcher = pattern.matcher(string);
    if (matcher.find()) {
      return matcher.group();
    }
    return "";
  }

  /**
   * Removes letters 'l' from the string.
   *
   * @param string string with l's.
   * @return string without l's.
   */
  public static String removeAllL(String string) {
    return string.replaceAll("l", "").replaceAll("L", "");
  }

  /**
   * Replaces letters 'o' with 'q' in the string.
   *
   * @param string string with o's.
   * @return string with q's.
   */
  public static String replaceOToQ(String string) {
    return string.replaceAll("o", "q").replaceAll("O", "Q");
  }

  /**
   * Lists the words of given string and counts number of letters.
   *
   * @param string any string.
   */
  public static void countWordsAndLetters(String string) {
    Pattern pattern = Pattern.compile("[\\w-]+");
    Matcher matcher = pattern.matcher(string);
    List<String> words = new ArrayList<>();
    while (matcher.find()) {
      words.add(matcher.group());
    }
    System.out.print("words: ");
    words.forEach((String s) -> System.out.print(s + ", "));
    System.out.println("; letters count: " + string.replaceAll(" ", "").length());
  }

  /**
   * Prints a meme song.
   *
   * @param n      starting number of bugs.
   * @param verses number of verses.
   */
  public static void memeSong(int n, int verses) {
    Random random = new Random();
    int m;
    for (; verses > 0; verses--) {
      m = n - 10 + random.nextInt(n * verses);
      System.out.printf(SONG_TEXT, n, n, m);
      n = m;
    }
  }


}
