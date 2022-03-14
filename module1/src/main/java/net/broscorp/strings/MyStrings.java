package net.broscorp.strings;

import java.util.Random;

public class MyStrings {

  /**
   * Checks if palindrome.
   *
   * @param s is an input string.
   * @return true if palindrom; false if not.
   */
  public boolean checkIfPalindrome(String s) {
    String reversed = reverse(s);
    if (s.equals(reversed)) {
      return true;
    } else {
      return false;
    }
  }

  /**
   * Reverses a string recursively.
   *
   * @param line is an input string.
   * @return returns a reversed string.
   */
  public String reverse(String line) {
    if (line.isEmpty()) {
      return line;
    }
    return reverse(line.substring(1)) + line.charAt(0);
  }

  public String cutWorld(String line) {
    return line.replaceAll(" World", "");
  }

  public String cutL(String line) {
    return line.replaceAll("l", "");
  }

  public String replaceO(String line) {
    return line.replaceAll("o", "q");
  }

  /** Counts letters and returns the resulting string.
   */
  public String countCharacters(String line) {
    String result = "";
    String[] array = line.split(" ");
    for (String indexer : array) {
      result += indexer;
      result += ": " + indexer.length() + " characters\n";
    }
    return result;
  }

  /**
   * DeveloperSong.mp3
   */
  public String compose(int bugs, int verses) {
    String result = "";
    int seed = bugs + verses;
    Random random = new Random(seed);
    for (int i = 0; i < verses; i++) {
      //System.out.println(bugs + " little bugs in a code,\n" + bugs + " little bugs in a code.");
      result += bugs + " little bugs in a code,\n" + bugs + " little bugs in a code.";
      bugs = bugs - 10 + random.nextInt(20);
      //System.out.println("Take one down, patch it around " + bugs + " little bugs in a code.\n");
      result += "\nTake one down, patch it around " + bugs + " little bugs in a code.\n";
    }
    return result;
  }
}
