package net.broscorp.strings;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Random;
import java.util.stream.Collectors;

public class StringService {

  /** The method to check palindrome.
   * @param word - a word to check.
   * @return true if a word is palindrome.
   */
  public boolean isPalindrome(String word) {
    if (word.isEmpty()) {
      return false;
    }
    word = word.toLowerCase();
    StringBuilder reverseWord = new StringBuilder(word).reverse();
    return word.contentEquals(reverseWord);
  }

  /** The method remove a word from a string.
   * @param string - the string from which remove.
   * @param word - the word to remove.
   * @return the modified string.
   */
  public String removeWord(String string, String word) {
    String[] words = string.split(" ");
    return Arrays.stream(words)
      .filter(s -> !s.equals(word)).collect(Collectors.joining(" "));
  }

  /** The method remove a letter from a string.
   * @param string - the string from which remove.
   * @param letter - the char to remove.
   * @return the modified string.
   */
  public String removeLetter(String string, char letter) {
    return string.replace(String.valueOf(letter), "");
  }

  /** The method replaces one letter with another.
   * @param string - the string in which replace.
   * @param oldLetter - the letter to replace.
   * @param newLetter - the letter to set.
   * @return the modified string.
   */
  public String replaceLetter(String string, char oldLetter, char newLetter) {
    return string.replace(oldLetter, newLetter);
  }

  /** The method prints each word with its length from the input string.
   * @param string - the source.
   */
  public String printNumberOfCharacters(String string) {
    String[] words = string.split(" ");
    StringBuilder result = new StringBuilder();
    Arrays.stream(words)
      .forEach(w -> result.append(String.format("%s contains %d letters;%n", w, w.length())));

    System.out.print(result.toString());
    return result.toString();
  }


  /** The method creates a song.
   * @param bugs - number of bugs.
   * @param verses - number of verses.
   * @return the song text.
   */
  public String getSong(int bugs, int verses) {
    String verseText = "%d little bugs in the code,\n"
        + "%d little bugs in the code.\n"
        + "Take one down, patch it around %d little bugs in the code.\n";

    Random random = new Random(bugs * verses);
    StringBuilder song = new StringBuilder();
    int n = bugs;

    while (verses > 0) {
      int m = n - 10 + random.nextInt(20);
      song.append(String.format(verseText, n, n, m));

      n = m;
      verses--;
    }

    return song.toString();
  }

}
