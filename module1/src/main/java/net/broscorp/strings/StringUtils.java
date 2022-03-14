package net.broscorp.strings;

import java.util.HashMap;
import java.util.Map;
import java.util.Random;

public class StringUtils {

  static final String HELLOWORLD = "Hello World";

  /**
   * Check if String is Polindrom.
   */
  public boolean isPolindrom(String input) {
    char[] symbols = input.toCharArray();
    int i = 0;
    int j = symbols.length - 1;
    while (i < symbols.length) {
      if (symbols[i] == ' ') {
        i++;
      }
      if (symbols[j] == ' ') {
        j--;
      }
      if (symbols[i] != symbols[j]) {
        return false;
      }
      i++;
      j--;
    }
    return true;
  }

  /**
   * Leaves first 5 letters.
   */
  public String noWorldHello() {
    return HELLOWORLD.substring(0, 5);
  }

  /**
   * Remove all 'l' from String.
   */
  public String noMoreLWillBeHere() {
    return HELLOWORLD.replaceAll("l", "");
  }

  /**
   * Replace all O by Q.
   */
  public String pasteQInsteadO() {
    return HELLOWORLD.replaceAll("o", "q");
  }

  /**
   * Gives count of letters in each word.
   */
  public String letterCounter() {
    String[] words = HELLOWORLD.split(" ");
    Map<String, Integer> map = new HashMap<>();
    for (String word : words) {
      map.put(word, word.length());
    }
    return map.toString();
  }

  /**
   * How many bugs you want today?.
   */
  public String singSong(int countOfBugs, int countOfCouplet) {
    StringBuilder stringBuilder = new StringBuilder();
    Random random = new Random((long) countOfBugs * countOfCouplet);
    for (int i = 0; i < countOfCouplet; i++) {
      int futureCountOfBugs = countOfBugs - 10 + random.nextInt(20);
      if (futureCountOfBugs < 0) {
        futureCountOfBugs = 0;
      }
      stringBuilder.append(countOfBugs + " little bugs in the code, \n" + countOfBugs
          + " little bugs in the code. \nTake one down, patch it around " + futureCountOfBugs
          + " little bugs in the code.\n");
      if (futureCountOfBugs == 0) {
        break;
      }
      countOfBugs = futureCountOfBugs;
    }
    return stringBuilder.toString();
  }
}
