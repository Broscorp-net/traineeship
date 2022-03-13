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

  @Test
  void printSong() {
    assertEquals("15 little bugs in the code, \n"
            + "15 little bugs in the code. \n"
            + "Take one down, patch it around 20 little bugs in the code.20 little bugs in the code, \n"
            + "20 little bugs in the code. \n"
            + "Take one down, patch it around 17 little bugs in the code.17 little bugs in the code, \n"
            + "17 little bugs in the code. \n"
            + "Take one down, patch it around 25 little bugs in the code.25 little bugs in the code, \n"
            + "25 little bugs in the code. \n"
            + "Take one down, patch it around 25 little bugs in the code.",
        stringRealization.printSong(15, 4));
  }
}