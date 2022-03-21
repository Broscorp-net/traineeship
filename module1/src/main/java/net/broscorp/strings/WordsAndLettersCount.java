package net.broscorp.strings;

import java.util.HashMap;
import java.util.Map;

public class WordsAndLettersCount {
  private int wordsCount;
  private final Map<String, Integer> wordsLength = new HashMap<>();

  /**
   * This class is the container of words numbers and words length.
   * @param string - string to parse.
   */
  public WordsAndLettersCount(String string) {
    String[] splitter = string.split(" ");
    this.wordsCount = splitter.length;
    for (String s : splitter) {
      wordsLength.put(s, s.length());
    }
  }

  public int getWordsCount() {
    return wordsCount;
  }

  public Map<String, Integer> getWordsLength() {
    return wordsLength;
  }
}
