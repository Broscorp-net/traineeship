package net.broscorp.strings;

import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Random;

public class StringOperation {
  public boolean isPalindrome(String str) {
    String reverse = new StringBuilder(str)
        .reverse()
        .toString();
    return str.equals(reverse);
  }

  public String cutHello(String input) {
    String[] str = input.split(" ");
    for (int i = 0; i < str.length; i++) {
      if (str[i].equals("Hello")) {
        return str[i];
      }
    }
    return "Hello doesn`t exist";
  }

  public String removeL(String input) {
    return input.replace("l", "");
  }

  public String replaceOAndQ(String input) {
    return input.replace("o", "q");
  }

  public void printLetterAndWords(String input) {
    String[] array = input.split(" ");
    Map<String, Integer> mapWords = new LinkedHashMap<>();
    for (int i = 0; i < array.length; i++) {
      mapWords.put(array[i], array[i].length());
    }
    System.out.println(mapWords);
  }

  public String textSong(int bugsCount, int verseCount) {
    Random random = new Random(bugsCount * verseCount);
    String songText = "%d little bugs in the code, \n" +
        "%d little bugs in the code. \n" +
        "Take one down, patch it around %d little bugs in the code.";
    StringBuilder builder = new StringBuilder();
    int n = bugsCount;
    for (int i = 0; i < verseCount; i++) {
      int m = n - 10 + random.nextInt(20);
      builder.append(String.format(songText, n, n, m));
      n = m;
    }
    return builder.toString();
  }
}
