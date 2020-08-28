package net.broscorp.strings;

import java.util.Random;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * MyString class.
 * @author Nikita
 *
 * @version 1.0
 */
public class MyString {

  /**
   * palindrome test.
   * @param word - word for test
   * @return true or false
   */
  public boolean isPalindrome(String word) {
    word = word.replaceAll(" ", "");
    String palindromeWord = new StringBuilder(word).reverse().toString().toLowerCase();
    return palindromeWord.equalsIgnoreCase(word);
  }

  /**
   * only hello stay in string.
   * @param string - input string
   * @return string
   */
  public String onlyHello(String string) {
    Pattern pattern = Pattern.compile("(\\W|^)hello(\\W|$)", Pattern.CASE_INSENSITIVE);
    Matcher matcher = pattern.matcher(string);
    matcher.find();
    return string.substring(matcher.start(), matcher.end()).trim();
  }

  /**
   * delete all letters l.
   * @param string - input string
   * @return string without l
   */
  public String deleteAllLettersL(String string) {
    return string.replaceAll("[lL]", "");
  }

  /**
   * replace all letters o to q.
   * @param string - input string
   * @return replace string
   */
  public String replaceAllLettersOToQ(String string) {
    return string.replaceAll("[oO]", "q");
  }

  /**
   * output all worlds in string ans their size.
   * @param string - input string
   */
  public void outputWordsAndLength(String string) {
    String[] strings = string.split("\\s");
    for (String s : strings) {
      System.out.println("Word \"" + s + "\" : size = " + s.length());
    }
  }

  /**
   * singing song.
   * @param bugsSize - number of bugs
   * @param versesSize - number of verses
   */
  public void singSong(int bugsSize, int versesSize) {
    Random random = new Random();
    int m;
    for (int i = 0; i < versesSize; i++) {
      m = Math.abs(bugsSize - 10 + random.nextInt(20));
      System.out.printf("%d little bugs in the code,\n"
              + "%d little bugs in the code.\n", bugsSize, bugsSize);
      System.out.printf("Take one down, patch it around %d little bugs in the code.\n", m);
      bugsSize = m;
    }
  }
}
