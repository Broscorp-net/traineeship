package net.broscorp.strings;

import java.util.Arrays;
import java.util.Map;
import java.util.Random;
import java.util.TreeMap;

public class StringHandler {

  /**
   * Checks if a word is a palindrome.
   *
   * @param word - word to check palindrome
   * @return true if word is palindrome, false if not
   */
  public boolean checkIfWordIsPalindrome(String word) {
    String handledWord = word.replaceAll("\\W", "");
    String reversedWord = new StringBuilder(handledWord).reverse().toString();
    return handledWord.equalsIgnoreCase(reversedWord);
  }

  /**
   * Removes everything from string except first occurrence of desired substring.
   *
   * @param originalString - a string from which everything is removed except for the first
   *     occurrence of the desired substring
   * @param substringToSave - the substring to be left in the original string
   * @return the resulting string
   */
  public String removeEverythingExceptFirstOccurrenceOfDesiredSubstring(
      String originalString, String substringToSave) {
    int firstIndex = originalString.indexOf(substringToSave);
    int lastIndex = firstIndex + substringToSave.length();
    return new StringBuilder(originalString)
        .delete(lastIndex, originalString.length())
        .delete(0, firstIndex)
        .toString();
  }

  /**
   * Removes every occurrence of some character from string.
   *
   * @param originalString - a string from which all occurrences of character is removed
   * @param charToRemove - the character to be removed from the original string
   * @return the resulting string
   */
  public String removeEveryCharOccurrence(String originalString, char charToRemove) {
    return originalString
        .chars()
        .mapToObj(c -> (char) c)
        .filter(c -> c != charToRemove)
        .collect(StringBuilder::new, StringBuilder::append, StringBuilder::append)
        .toString();
  }

  /**
   * Removes every occurrence of some substring from string.
   *
   * @param originalString - a string from which all occurrences of substring is removed
   * @param substringToRemove - the substring to be removed from the original string
   * @return the resulting string
   */
  public String removeEverySubstringOccurrence(String originalString, String substringToRemove) {
    return originalString.replaceAll(substringToRemove, "");
  }

  /**
   * Replaces every occurrence of some substring by other substring.
   *
   * @param originalString - a string in which all occurrences of substring is replaced
   * @param targetSubstring - the substring of the original string to be replaced
   * @param replacementSubstring - the replacement substring
   * @return the resulting string
   */
  public String replaceEverySubstringOccurrence(
      String originalString, String targetSubstring, String replacementSubstring) {
    return originalString.replaceAll(targetSubstring, replacementSubstring);
  }

  /**
   * Returns a map whose keys are the words included in the text, and the values are the numbers of
   * letters in these words.
   *
   * @param originalText - the text from the words of which the corresponding map should be made
   * @return a map whose keys are the words included in the text, and the values are the numbers of
   *     letters in these words
   */
  public Map<String, Integer> getAllWordsWithNumberOfLettersInEach(String originalText) {
    String textOfOnlyWords =
        originalText
            .toLowerCase()
            .replaceAll("[\\[%\\-+*/=\"\\\\&\\d.,^«»…?!~`$—():<>';|\\]]", " ")
            .replaceAll("\\s+", " ");
    return Arrays.stream(textOfOnlyWords.split(" "))
        .distinct()
        .filter(w -> w.length() > 0)
        .collect(TreeMap::new, (map, word) -> map.put(word, word.length()), Map::putAll);
  }

  /**
   * Provides a song with a randomly generated numbers of bugs in text.
   *
   * @param numberOfBugs - initial number of bugs for further generation of random numbers of bugs
   * @param numberOfVerses - number of verses of the song
   * @return text of the song with the specified number of verses in which the pseudo-randomly
   *     generated according to a given rule numbers of bugs are inserted
   */
  public String getSong(Integer numberOfBugs, Integer numberOfVerses) {
    String songVerse =
        "\n%d little bugs in the code,\n"
            + "%d little bugs in the code.\n"
            + "Take one down, patch it around %d little bugs in the code.\n";
    Random random = new Random((long) numberOfBugs * numberOfVerses);
    int n = numberOfBugs;
    int m;
    int i = 0;
    StringBuilder stringBuilder = new StringBuilder();
    while (i < numberOfVerses) {
      m = n - 10 + random.nextInt(20);
      stringBuilder.append(String.format(songVerse, n, n, m));
      n = m;
      i++;
    }
    return stringBuilder.toString();
  }
}
