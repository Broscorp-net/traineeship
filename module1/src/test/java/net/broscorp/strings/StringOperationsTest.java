package net.broscorp.strings;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.Test;

class StringOperationsTest {

  private final StringOperations operations = new StringOperations();

  @Test
  void isPalindromeTest() {
    String text1 = "Лёша на полке клопа нашёл";
    String text2 = "Просто не палиндром";

    assertTrue(operations.isPalindrome(text1));
    assertFalse(operations.isPalindrome(text2));
  }

  @Test
  void saveFirstWordInTextTest() {
    String text1 = "Hello world!!";
    String text2 = "First Second";

    assertEquals("Hello", operations.saveFirstWordInText(text1));
    assertEquals("First", operations.saveFirstWordInText(text2));
  }

  @Test
  void removeLetterLTest() {
    String text = "Hello world";

    assertEquals("Heo word", operations.removeLetterL(text));
  }

  @Test
  void changeSomeLettersTest() {
    String text = "Hello world";

    assertEquals("Hellq wqrld", operations.changeSomeLetters(text, "o", "q"));
  }

  @Test
  void wordStatisticTest() {
    String text = "Hello world!!";
    String sb = "Hello -> 5\n"
        + "world!! -> 7\n";

    assertEquals(sb, operations.wordStatistic(text));
  }

  @Test
  void getSongTest() {
    String result = "5 little bugs in the code,\n"
        + "5 little bugs in the code.\n"
        + "Take one down, patch it around 8 little bugs in the code.\n"
        + "8 little bugs in the code,\n"
        + "8 little bugs in the code.\n"
        + "Take one down, patch it around -2 little bugs in the code.\n";
    assertEquals(result, operations.getSong(5, 2));
  }
}