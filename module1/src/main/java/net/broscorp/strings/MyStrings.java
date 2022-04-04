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
    StringBuilder builder = new StringBuilder(s);
    String reversed = builder.reverse().toString();
    return s.equals(reversed);
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

  /**
   * Counts letters and returns the resulting string.
   */
  public String countCharacters(String line) {
    StringBuilder result = new StringBuilder();
    String[] array = line.split(" ");
    for (String indexer : array) {
      result.append(indexer);
      result.append(": ").append(indexer.length()).append(" characters\n");
    }
    return result.toString();
  }

  /**
   * DeveloperSong.mp3
   */
  public String compose(int bugs, int verses) {
    StringBuilder result = new StringBuilder();
    int seed = bugs + verses;

    String firstline = "Take one down, patch it around ";
    String secondline = " little bugs in a code,\n";
    String thirdline = " little bugs in a code.\n";

    Random random = new Random(seed);
    for (int i = 0; i < verses; i++) {
      result.append(bugs).append(secondline).append(bugs).append(thirdline);
      bugs = bugs - 10 + random.nextInt(20);
      result.append(firstline).append(bugs).append(thirdline);
    }
    System.out.println(result.toString());
    return result.toString();
  }
}
