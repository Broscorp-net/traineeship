package net.broscorp.strings;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class WorkWithStringTest {

  private WorkWithString workWithString = new WorkWithString();

  @Test
  void isPalindromeTest() {
    assertTrue(workWithString.isPalindrome("Level"));
    assertTrue(workWithString.isPalindrome(""));
    assertFalse(workWithString.isPalindrome("Word"));
  }

  @Test
  @DisplayName("Delete word \"World\" from \"Hello World\"")
  void cutWordTest() {
    assertEquals("Hello", workWithString.cutWord("Hello World", "World"));
  }

  @Test
  @DisplayName("Delete all char 'l' in \"Hello World\"")
  void cutAllSymbolsTest() {
    assertEquals("Heo Word", workWithString.cutAllChars("Hello World", "l"));
  }

  @Test
  @DisplayName("Replace all 'o' to 'q'")
  void replaceCharsTest() {
    assertEquals("Hellq Wqrld",
        workWithString.replaceChars("Hello World", "o", "q"));
  }

  @Test
  void endlessSongTest() {
    String textSong = "20 little bugs in the code, \n"
        + "20 little bugs in the code. \n"
        + "Take one down, patch it around 16 little bugs in the code.\n"
        + "16 little bugs in the code, \n"
        + "16 little bugs in the code. \n"
        + "Take one down, patch it around 13 little bugs in the code.\n"
        + "13 little bugs in the code, \n"
        + "13 little bugs in the code. \n"
        + "Take one down, patch it around 21 little bugs in the code.\n"
        + "21 little bugs in the code, \n"
        + "21 little bugs in the code. \n"
        + "Take one down, patch it around 29 little bugs in the code.\n";
    String str = workWithString.endlessSong(20, 4);
    assertEquals(4, str.split("Take one").length - 1);
    assertEquals(textSong, str);
  }
}