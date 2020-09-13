import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class StringsTest {
  private Strings strings;
  String line;

  @BeforeEach
  void start() {
    strings = new Strings();
    line = "Hello World";
  }

  @Test
  void shouldReturnTrueIfLineIsPalindrome() {
    String palindrome = "I did did I";
    assertTrue(strings.isPalindrome(palindrome));
    assertFalse(strings.isPalindrome(line));
  }

  @Test
  void shouldReturnFirstWord() {
    String expected = "Hello";
    String result = strings.returnFirstWord(line);
    assertEquals(result, expected);
  }

  @Test
  void shouldRemoveAllLLetters() {
    String expected = "Heo Word";
    String result = strings.removeAllLLetters(line);
    assertEquals(result, expected);
  }

  @Test
  void shouldReplaceAllOLettersToQ() {
    String expected = "Hellq Wqrld";
    String result = strings.replaceOToQ(line);
    assertEquals(result, expected);
  }

  @Test
  void shouldPrintWordsWithNumberOfLetters() {
    String testLine = "12345 123";
    strings.printWords(testLine);
  }

  @Test
  void shouldReturnSongText() {
    String expected = "6 little bugs in the code, \n"
        + "6 little bugs in the code. \n"
        + "Take one down, patch it around 2 little bugs in the code. \n"
        + "2 little bugs in the code, \n"
        + "2 little bugs in the code. \n"
        + "Take one down, patch it around 4 little bugs in the code. \n";

    String result = strings.songText(6, 2);
    assertEquals(expected, result);
  }
}