package net.broscorp.strings;

import java.util.Map;
import java.util.Random;
import java.util.regex.Pattern;

public class StringUtils {

  public static boolean isPalindrome(String string) {
    String reversed = new StringBuilder(string).reverse().toString();
    return reversed.equals(string);
  }

  public static String worldRemover(String string) {
    return Pattern.compile("world", Pattern.CASE_INSENSITIVE).matcher(string).replaceAll("").trim();
  }

  public static String letterRemover(String string) {
    return Pattern.compile("l", Pattern.CASE_INSENSITIVE).matcher(string).replaceAll("");
  }

  public static String letterReplacer(String string) {
    return Pattern.compile("o", Pattern.CASE_INSENSITIVE).matcher(string).replaceAll("q");
  }

  /**
   * Method that counts words in string, and counts length of each word.
   * @param string - string to parse.
   * @return - instance which contains words count and words lengths.
   */
  public static WordsAndLettersCount countWordsAndLettersOfEachWord(String string) {
    WordsAndLettersCount wordsAndLettersCount = new WordsAndLettersCount(string);

    System.out.println("Words count: " + wordsAndLettersCount.getWordsCount());

    for (Map.Entry<String, Integer> entry : wordsAndLettersCount.getWordsLength().entrySet()) {
      System.out.println("length of \"" + entry.getKey() + "\": " + entry.getValue());
    }

    return wordsAndLettersCount;
  }

  /**
   * Fun method to build song.
   * @param bugsCount - count of bugs.
   * @param versesCount - count of verses.
   * @return - created song.
   */
  public static String song(int bugsCount, int versesCount) {
    long seed = (long) bugsCount * versesCount;
    Random random = new Random(seed);

    StringBuilder stringBuilder = new StringBuilder();

    for (int i = 0; i < versesCount; i++) {
      int m = bugsCount - 10 + random.nextInt(20);
      String verse = String.format(
              "%d little bugs in the code,\n"
                      + "%d little bugs in the code.\n"
                      + "Take one down, patch it around %d little bugs in the code.",
              bugsCount, bugsCount, m);
      stringBuilder.append(verse);
      stringBuilder.append("\n");
      bugsCount = m;
    }
    return stringBuilder.toString();
  }
}
