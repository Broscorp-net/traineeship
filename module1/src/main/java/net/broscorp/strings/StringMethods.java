package net.broscorp.strings;

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
    StringBuilder reverseWorkLine = new StringBuilder(ourWorkLine.toLowerCase());
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
   *  Make splits in the introduced string, and print on the screen
   *  quantity of each words.
   */
  public void outQuantityOfWordsInTheLineAndItLength(String str) {
    String[] stringsWasSplit = str.split(" ");

    for (String s : stringsWasSplit) {
      System.out.println(s + ": " + s.length());
    }
  }

  /**
   * Make a song.
   */
  public void singMethod(int quantityOfBags, int quantityOfCouplets) {
    while (quantityOfCouplets > 0) {
      int m = (int) ((Math.random() * 10) + 1);
      for (int i = quantityOfBags; i > 1; i--) {
        System.out.printf("%d little bugs in the code,\n", i);
      }
      System.out.printf("%d little bug in the code.\n", 1);
      if (m == 1) {
        System.out.printf("Take one down, patch it %d little bug in the code.\n", m);
      } else {
        System.out.printf("Take one down, patch it around %d little bugs in the code.\n", m);
      }
      quantityOfBags = m;
      quantityOfCouplets--;
    }
  }
}
