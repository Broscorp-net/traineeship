package net.broscorp.strings;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.Test;

class StringRealizationTest {

  StringRealization stringRealization = new StringRealization();

  @Test
  void isPalindrom() {
    assertTrue(stringRealization.isPalindrom("потоп"));
    assertTrue(stringRealization.isPalindrom("поп"));
    assertFalse(stringRealization.isPalindrom("кот"));
  }

  @Test
  void splitWord() {
    assertEquals("Hello", stringRealization.splitWord("Hello world"));
  }

  @Test
  void deleteLiteral() {
    assertEquals("Heo", stringRealization.deleteLiteral("Hello"));
  }

  @Test
  void changeLiteral() {
    assertEquals("Hellq", stringRealization.changeLiteral("Hello"));
  }

  @Test
  void printWordsAndCountLetters() {
    assertEquals("Words : \"Hello\" \"world\" Count litters - 10",
        stringRealization.printWordsAndCountLetters("Hello world"));
  }
}