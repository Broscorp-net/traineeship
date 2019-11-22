package net.broscorp.n_strings;

import java.util.HashMap;
import java.util.Map;
import java.util.Random;

public class StringTask {

  public static boolean isPalindrome(String line) {
    String stringLowerCase = line.toLowerCase();
    return stringLowerCase.contentEquals(new StringBuilder(stringLowerCase).reverse());
  }

  public static String cutLine(String line) {
    String[] strings = line.split(" ");
    return strings[0];
  }

  public static String deleteSymbolInLine(String line) {
    return line.replace("l", "");
  }

  public static String changeSymbol(String line) {
    return line.replace("o", "q");
  }

  public static String countWordsAndCountSymbols(String line) {
    String[] words = line.split(" ");
    Map<String, Integer> stringIntegerMap = new HashMap<>();
    for (String word : words) {
      stringIntegerMap.put(word, word.length());
    }
    return stringIntegerMap.toString();
  }

  public static String makeSong(int n, int m) {
    Random random = new Random();
    StringBuilder builder = new StringBuilder();

    for (int i = 0; i < n; i++) {
      m = n - 10 + random.nextInt(20);
      if (m > 0) {
        for (int j = 1; j <= m; j++) {
          builder.append(String.format("%d little bugs in the code,%n", j));
        }
        builder.append(String.format("Take one down, patch it around "
            + "%d little bugs in the code.%n%n", m));
      } else {
        builder.append(String.format("There will be no bugs%n%n"));
      }
    }
    return builder.toString();
  }
}
