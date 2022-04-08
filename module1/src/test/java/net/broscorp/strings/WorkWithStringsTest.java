package net.broscorp.strings;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.Test;

class WorkWithStringsTest {
  private WorkWithStrings strings = new WorkWithStrings();

  @Test
  void isPalindrome() {
    String arg = "level";
    assertTrue(strings.isPalindrome(arg));
  }

  @Test
  void leftHello() {
    assertEquals(strings.leftHello(), "Hello");
  }

  @Test
  void deleteLetter() {
    assertEquals(strings.deleteLetter(), "Heo word");
  }

  @Test
  void replaceLetters() {
    assertEquals(strings.replaceLetters(), "Hellq wqrld");
  }

  @Test
  void checkListOfWordsAndCountLetters() {
    strings.listOfWordsAndCountLetters();
  }

  @Test
  void checkSong() {
    strings.printSong(15, 4);
  }
}