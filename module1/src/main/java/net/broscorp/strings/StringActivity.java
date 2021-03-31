package net.broscorp.strings;

import java.util.List;
import java.util.Map;
import java.util.Random;
import java.util.stream.Collectors;

public class StringActivity {

  /**
   * Checks if a string is a palindrome.
   *
   * @param string - string on check palindrome
   * @return true if string palindrome, false if not
   */
  public boolean palindrome(String string) {
    return string.replaceAll("\\W", "")
        .equalsIgnoreCase(new StringBuilder(string.replaceAll("\\W", ""))
            .reverse().toString());
  }

  public String deleteEverythingExpectSaveWord(String string, String save) {
    return string.replaceAll(string.replaceAll(save, ""), "");
  }

  public String deleteChar(String string, String chars) {
    return string.replaceAll(chars, "");
  }

  public String replaceOtoQ(String string, String target, String replacement) {
    return string.replace(target, replacement);
  }

  /**
   * Counts the number of letters in word.
   *
   * @param list - list words
   * @return map with a long word
   */
  public Map<String, Integer> outputListWords(List<String> list) {
    Map<String, Integer> map = list.stream()
        .collect(Collectors.toMap(String::toString, String::length));
    System.out.println(map);
    return map;
  }

  /**
   * Generated song about bags.
   *
   * @param numberBag   - number bags
   * @param numberVerse - number verses
   * @return song about bags
   */
  public String randomSong(Integer numberBag, Integer numberVerse) {

    StringBuilder stringBuilder = new StringBuilder();

    Random random = new Random((long) numberBag * numberVerse);
    int n = numberBag;
    int m;

    String verse = "Verse %d \n"
        + "%d little bugs in the code, \n"
        + "%d little bugs in the code. \n"
        + "Take one down, patch it around %d little bugs in the code.\n";

    for (int i = 0; i < numberVerse; i++) {
      m = n - 10 + random.nextInt(20);
      stringBuilder.append("\n").append(String.format(verse, i + 1, n, n, m));
      n = m;
    }
    return stringBuilder.toString();
  }
}
