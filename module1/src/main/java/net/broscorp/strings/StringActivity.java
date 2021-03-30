package net.broscorp.strings;

import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class StringActivity {

  public static boolean palindrome(String string) {
    return string.replaceAll("\\W", "")
        .equalsIgnoreCase(new StringBuilder(string.replaceAll("\\W", ""))
            .reverse().toString());
  }

  public static String deleteEverythingExpectSaveWord(String string, String save) {
    return string.replaceAll(string.replaceAll(save, ""), "");
  }

  public static String deleteChar(String string, String chars) {
    return string.replaceAll(chars, "");
  }

  public static String replaceOtoQ(String string, String target, String replacement) {
    return string.replace(target, replacement);
  }

  public static void outputListWords(List<String> list) {
    Map<String, Integer> map = list.stream()
        .collect(Collectors.toMap(String::toString, String::length));
    System.out.println(map);
  }

  public static void main(String[] args) {

    outputListWords(Arrays.asList("Hello", "Firstaaaa"));
  }

}
