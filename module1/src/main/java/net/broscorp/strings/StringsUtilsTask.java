package net.broscorp.strings;

import java.util.Random;

public class StringsUtilsTask {

  /**
   * Check for palindrom.
   */
  public static boolean checkForPalindrom(String str) {

    for (int i = 0; i < str.length(); i++) {
      if (str.charAt(i) != str.charAt(str.length() - 1 - i)) {
        return false;
      }
    }
    return true;
  }

  /**
   * Cut all symbols after first word.
   */
  public static String cutAllAfterFirstWord(String str) {
    int pointer = str.indexOf(" ");
    if (pointer != -1) {
      String second = str.substring(++pointer);
      return str.replaceAll(second, "").trim();
    } else {
      return str;
    }
  }

  /**
   * Remove symbol "l".
   */
  public static String removeSymbolL(String str) {
    return str.replaceAll("l", "");
  }

  /**
   * Replace symbol "o" to "q".
   */
  public static String replaceSymbolO(String str) {
    return str.replaceAll("o", "q");
  }

  /**
   * Count words and symbols.
   */
  public static String countWordsAndSymbols(String str) {
    String result = "";
    String[] array = str.split(" ");

    for (String word : array) {
      result += word;
      if (word.length() != 0) {
        result += "(" + word.length() + ")\t";

      }
    }
    return result + "// word counter -> " + array.length;
  }

  /**
   * Song with bugs.
   */
  public static String songWithBugs(int bugs, int couplets) {
    String result = "";
    Random random = new Random(bugs + couplets);

    int m;
    int n = bugs;

    for (int i = 0; i < couplets; i++) {

      result += n + " little bugs in a code,\n" + n + " little bugs in a code.";
      m = bugs - 10 + random.nextInt(20);
      result += "\nTake one down, patch it around " + m + " little bugs in a code.\n";
      n = m;
    }
    return result;
  }

}
