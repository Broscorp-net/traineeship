package net.broscorp.strings;

import java.util.Random;

public class MyStrings {

  public static final String HELLO_WORLD = "Hello World";

  /**
   * Checking if string is a palindrome.
   * @param str - string to be checked.
   * @return true if string is a palindrome, otherwise false.
   */
  public static boolean isPalindrome(String str) {
    StringBuilder sb = new StringBuilder(str);
    sb.reverse();
    String rev = sb.toString();
    if (str.equals(rev)) {
      return true;
    } else {
      return false;
    }
  }

  /**
   * из словосочетания "Hello World": 1. Оставляет только слово Hello.
   * @param str - input string
   * @return result string
   */
  public static String helloWorld1(String str) {
    if (str.equals(HELLO_WORLD)) {
      return str.substring(0, 5);
    } else {
      throw new IllegalArgumentException(
        String.format("Method accepts only %s as an argument", HELLO_WORLD));
    }
  }

  /**
   * из словосочетания "Hello World": 2. Удаляет все буквы "l" в строке.
   * @param str - input string
   * @return result string
   */
  public static String helloWorld2(String str) {
    if (str.equals(HELLO_WORLD)) {
      return str.replace("l", "");
    } else {
      throw new IllegalArgumentException(
        String.format("Method accepts only %s as an argument", HELLO_WORLD));
    }
  }

  /**
   * из словосочетания "Hello World": 3. Меняет все буквы "о" на букву "q".
   * @param str - input string
   * @return result string
   */
  public static String helloWorld3(String str) {
    if (str.equals(HELLO_WORLD)) {
      return str.replace("o", "q");
    } else {
      throw new IllegalArgumentException(
        String.format("Method accepts only %s as an argument", HELLO_WORLD));
    }
  }

  /**
   * из словосочетания "Hello World": 4. Выводит список слов и количество
   * букв в соответствующем слове.
   * @param str - input string
   * @return result string
   */
  public static String helloWorld4(String str) {
    if (str.equals(HELLO_WORLD)) {
      StringBuilder sb = new StringBuilder();
      String[] arr = str.split(" ");

      for (String ss : arr) {
        sb.append(ss + " " + ss.length());
        sb.append(System.lineSeparator());
      }
      return sb.toString();
    } else {
      throw new IllegalArgumentException(
        String.format("Method accepts only %s as an argument", HELLO_WORLD));
    }
  }

  /**
   * Returns a song.
   * @param bugsNum - initial number of bugs
   * @param coupletNum - number of couplets
   * @return song text
   */
  public static String songText(int bugsNum, int coupletNum) {

    StringBuilder sb = new StringBuilder();
    Random random = new Random(bugsNum * coupletNum);
    int bugsLeft = bugsNum;

    int couplet = 1;
    while (couplet++ <= coupletNum) {
      sb.append(String.format("%d little bugs in the code,\n", bugsLeft));
      sb.append(String.format("%d little bugs in the code.\n", bugsLeft));
      bugsLeft = bugsLeft - 10 + random.nextInt(20);
      sb.append(String.format(
          "Take one down, patch it around %d little bugs in the code.\n\n",
          bugsLeft));
    }

    return sb.toString();
  }
}
