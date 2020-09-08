package net.broscorp.strings;

import java.util.Random;

public class StringMethods {

  /**
   * Method which return boolean (true/false) if String is palindrome.
   *
   * @param str String which we will check on a palindrome
   * @return true if IS/false if is NOT
   */
  public boolean isPalindrome(String str) {
    str = str.replaceAll(" ", "");
    String ourWorkLine = str.toLowerCase();
    StringBuilder reverseWorkLine = new StringBuilder(ourWorkLine);
    reverseWorkLine.reverse();
    return ourWorkLine.equals(reverseWorkLine.toString());
  }

  public String helloInEnd(String str) {
    return str.substring(0, 5);
  }

  public String deleteAllSymbolsLFromTheLine(String str) {
    return str.replace("l", "");
  }

  public String swapSymbolsOOnQInTheLine(String str) {
    return str.replace("o", "q");
  }

  /**
   * Make splits in the introduced string, and print on the screen quantity of each words.
   */
  public String outQuantityOfWordsInTheLineAndItLength(String str) {
    String[] stringsWasSplit = str.split(" ");
    StringBuilder waitString = new StringBuilder();

    for (String s : stringsWasSplit) {
      System.out.println(s + ": " + s.length());
      waitString.append(s).append(": ").append(s.length()).append("\n");
    }

    return waitString.toString();
  }

  /**
   * Make a song.
   */
  public String singMethod(int quantityOfBugs, int quantityOfCouplets) {
    StringBuilder song = new StringBuilder();
    Random random = new Random();

    for (int i = 0; i < quantityOfCouplets; i++) {
      int currentQuantityOfBugs = 0;

      if (quantityOfBugs > 0) {
        currentQuantityOfBugs = quantityOfBugs - 10 + random.nextInt(20);
      }
      song.append(quantityOfBugs).append(" little bugs in the code,\n")
          .append(quantityOfBugs).append(" little bugs in the code.\n")
          .append("Take one down, patch it around ")
          .append(currentQuantityOfBugs).append(" little bugs in the code.\n");
      quantityOfBugs = currentQuantityOfBugs;
    }

    System.out.println(song.toString());
    return song.toString();
  }
}
