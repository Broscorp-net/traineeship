package net.broscorp.strings;

import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Random;
import java.util.Set;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Strings {

  /**
   * Method is case insensitive.
   */
  boolean isPalindrome(String str) {
    str = str.toLowerCase();
    StringBuilder sb = new StringBuilder(str);
    sb.reverse();
    return str.equals(sb.toString());
  }

  String leaveOnlyFirstWord(String str) {
    String hello = "";
    String[] strings = str.split(" ");
    for (String string : strings) {
      if (string.equals("Hello")) {
        hello = string;
      }
    }
    return hello;
  }

  /**
   * Case insensitive. Leaves all occurrences of word "hello" in input string.
   */
  String leaveOnlyHello(String str) {
    StringBuilder helloString = new StringBuilder();
    String regex = "(?i)\\b(hello)\\b";
    Pattern pattern = Pattern.compile(regex);
    Matcher matcher = pattern.matcher(str);
    while (matcher.find()) {
      helloString.append(matcher.group()).append("\n");
    }
    return helloString.toString();
  }

  String removeL(String str) {
    return str.replaceAll("l", "");
  }

  String replaceOWithQ(String str) {
    return str.replaceAll("o", "q");
  }

  Map<String, Integer> returnListOfWordsAndTheirCount(String str) {
    Map<String, Integer> listOfWordsAndCount = new HashMap<>();
    String[] stringArray = removeUselessChars(str);
    int count = 0;
    for (String s : stringArray) {
      if (!s.isEmpty() && !listOfWordsAndCount.containsKey(s)) {
        for (String value : stringArray) {
          if (s.equalsIgnoreCase(value)) {
            count++;
          }
        }
        listOfWordsAndCount.put(s, count);
        count = 0;
      }
    }
    return listOfWordsAndCount;
  }

  Map<String, Integer> returnListOfWordsAndNumberOfLettersInEach(String str) {
    Map<String, Integer> map = new HashMap<>();
    String[] stringArray = removeUselessChars(str);
    Set<String> uniqueWords = new HashSet<>(Arrays.asList(stringArray));
    for (String word : uniqueWords) {
      map.put(word, word.length());
    }
    return map;
  }

  String bugLyrics(int bugs, int verses) {
    if (bugs <= 0 || verses <= 0) {
      return "";
    }
    int nextIntValue = bugs * verses;
    Random random = new Random();
    StringBuilder fullLyrics = new StringBuilder();
    for (int i = 0; i < verses; i++) {
      int m = bugs - 10 + random.nextInt(nextIntValue);
      fullLyrics.append(composeLyrics(bugs, m));
      bugs = m;
    }
    return fullLyrics.toString();
  }

  private String composeLyrics(int bugs, int nextBugs) {
    String part1 = String.format("%d Little bugs in the code\n"
        + "%d Little bugs in the code\n", bugs, bugs);
    String part2 = String.format("Take one down, patch it around, %d little bugs in the code \n"
        + "\n", nextBugs);
    return String.format("%1$s%2$s", part1, part2);
  }

  private String[] removeUselessChars(String str) {
    str = str.replaceAll("\\s+", " ");
    str = str.replaceAll("[^a-zA-Z\\s]", "").toLowerCase();
    return str.split(" ");
  }
}