package net.broscorp.strings;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.Map;

import static org.junit.jupiter.api.Assertions.*;

class StringUtilsTest {

  private static final String SONG_TO_TEST =
      "32 little bugs in the code,\n"
          + "32 little bugs in the code.\n"
          + "Take one down, patch it around 29 little bugs in the code.\n"
          + "29 little bugs in the code,\n"
          + "29 little bugs in the code.\n"
          + "Take one down, patch it around 21 little bugs in the code.\n"
          + "21 little bugs in the code,\n"
          + "21 little bugs in the code.\n"
          + "Take one down, patch it around 29 little bugs in the code.\n"
          + "29 little bugs in the code,\n"
          + "29 little bugs in the code.\n"
          + "Take one down, patch it around 36 little bugs in the code.\n"
          + "36 little bugs in the code,\n"
          + "36 little bugs in the code.\n"
          + "Take one down, patch it around 37 little bugs in the code.\n";

  @Test
  public void isPalindromeTest() {
    Assertions.assertTrue(StringUtils.isPalindrome("somemos"));
  }

  @Test
  public void worldRemoverTest() {
    Assertions.assertEquals("hello", StringUtils.worldRemover("hello world"));
  }

  @Test
  public void lRemoverTest() {
    Assertions.assertEquals("heo word", StringUtils.lLetterRemover("hello world"));
  }

  @Test
  public void oReplacerTest() {
    Assertions.assertEquals("hellq wqrld", StringUtils.oLetterReplacer("hello world"));
  }

  @Test
  public void wordsCountTest() {
    String string = "Hello my beautiful world";

    WordsAndLettersCount wordsAndLettersCount = StringUtils.countWordsAndLettersOfEachWord(string);

    Assertions.assertEquals(4, wordsAndLettersCount.getWordsCount());
  }

  @Test
  public void wordsLengthTest() {
    String string = "Hello my beautiful world";

    WordsAndLettersCount wordsAndLettersCount = StringUtils.countWordsAndLettersOfEachWord(string);

    Map<String, Integer> map = wordsAndLettersCount.getWordsLength();

    Assertions.assertEquals(4, map.size());
  }

  @Test
  public void songTest() {
    Assertions.assertEquals(SONG_TO_TEST, StringUtils.song(32, 5));
  }
}
