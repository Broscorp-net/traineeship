package net.broscorp.strings;

import java.util.HashMap;
import java.util.Map;

public class WordsAndLettersCount {
  private int wordsCount;
  private final Map<String, Integer> wordsLength = new HashMap<>();

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
