package net.broscorp.strings;

import java.util.Random;
import javax.print.attribute.standard.RequestingUserName;

public class StringUtils {

  public static boolean isPalindrome(String str) {
    return new StringBuilder(str).reverse().toString().equals(str);
  }

  public static String removeWorldFromString(String str) {
    return str.replace("World", "").trim();
  }

  public static String removeAllOccurrencesOfLetterL(String str) {
    return str.replace("l", "");
  }

  public static String replaceAllOccurrencesOfOWithQ(String str) {
    return str.replace('o', 'q');
  }

  /**
   * Returns string that consists of words and their lengths in the following format:
   * {@code word: length\n}.
   * @param str String on which operation is performed
   * @return
   */
  public static String getListOfWordsAndNumOfChars(String str) {
    StringBuilder sb = new StringBuilder();
    String[] words = str.split(" ");

    for (String word : words) {
      sb.append(String.format("%s: %d\n", word, word.length()));
    }

    return sb.toString();
  }

  /**
   * Creates a song with specified parameters.
   * @param numOfBugs Number of bugs.
   * @param numOfVerses Number of verses.
   * @return A song with specified parameters that was created
   */
  public static String createSong(int numOfBugs, int numOfVerses) {
    StringBuilder sb = new StringBuilder();
    final String verseFormatStr = String.join(
        "",
        "%d little bugs in the code,\n",
        "%d little bugs in the code.\n",
        "Take one down, patch it around %d little bugs in the code.\n"
    );
    Random rnd = new Random(numOfBugs + numOfVerses);
    int m;

    for (int i = 0; i < numOfVerses; i++) {
      m = numOfBugs - 10 + rnd.nextInt(20);
      sb.append(String.format(verseFormatStr, numOfBugs, numOfBugs, m));
      numOfBugs = m;
    }

    return sb.toString();
  }

}
