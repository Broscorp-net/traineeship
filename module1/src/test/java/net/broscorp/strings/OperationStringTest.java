package net.broscorp.strings;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

class OperationStringTest {
  private static final String HELLO_WORLD = "Hello World";
  private static final OperationString operationString = new OperationString();
  private static final String SONG = "14 little bugs in the code, \n"
      + "14 little bugs in the code. \n"
      + "Take one down, patch it around 10 little bugs in the code.\n"
      + "10 little bugs in the code, \n"
      + "10 little bugs in the code. \n"
      + "Take one down, patch it around 10 little bugs in the code.\n"
      + "10 little bugs in the code, \n"
      + "10 little bugs in the code. \n"
      + "Take one down, patch it around 10 little bugs in the code.\n"
      + "10 little bugs in the code, \n"
      + "10 little bugs in the code. \n"
      + "Take one down, patch it around 15 little bugs in the code.\n"
      + "15 little bugs in the code, \n"
      + "15 little bugs in the code. \n"
      + "Take one down, patch it around 6 little bugs in the code.\n";

  @Test
  void findPalindrome() {
    Assertions.assertTrue(operationString.findPalindrome("bob"));
    Assertions.assertTrue(operationString.findPalindrome("Bob"));
    Assertions.assertFalse(operationString.findPalindrome("Home"));
  }

  @Test
  void cutWord() {
    Assertions.assertEquals("World", operationString.cutWord(HELLO_WORLD));
    Assertions.assertEquals(HELLO_WORLD, operationString.cutWord(" " + HELLO_WORLD));
  }

  @Test
  void deleteLetter() {
    Assertions.assertEquals("Heo Word", operationString.deleteLetter(HELLO_WORLD, "l"));
  }

  @Test
  void replaceLetterWithAnother() {
    Assertions.assertEquals("Heqqo Worqd",
        operationString.replaceLetterWithAnother(HELLO_WORLD, "l", "q"));
  }

  @Test
  void showListWordAndNumberLetters() {
    Assertions.assertEquals("Hello = 5 World = 5 ",
        operationString.showListWordAndNumberLetters(HELLO_WORLD));
  }

  @Test
  void song() {
    Assertions.assertEquals(SONG, operationString.song(14, 5));
  }
}