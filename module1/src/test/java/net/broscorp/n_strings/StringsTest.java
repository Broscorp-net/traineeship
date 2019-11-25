package net.broscorp.n_strings;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

class StringsTest {
  private static Strings strings;

  @BeforeAll
  public static void initialization() {
    strings = new Strings();
  }
  
  @Test
  void testIsPalindrom() {
    strings.isPalindrom("mam");
    assertTrue(strings.isPalindrom("mam"));
  }

  @Test
  void testWordDeletion() {
    assertEquals("jhgllho", strings.wordDeletion("Hello world"));
  }

  @Test
  void testLetterDeletion() {
    assertEquals("Heo fsord", strings.letterDeletion("Hello world"));
  }

  @Test
  void testLettersChaneging() {
    assertEquals("Hellq wqrld", strings.lettersChaneging("Hello world"));
  }

  @Test
  void testWordsLetters() {
    assertEquals(2, strings.wordsLetters("Hello world").size());
  }

  @Test
  void testMakeSong() {
    assertTrue(strings.makeSong(2, 3) instanceof String);
  }

}
