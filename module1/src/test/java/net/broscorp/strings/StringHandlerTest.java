package net.broscorp.strings;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.util.Map;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

public class StringHandlerTest {
  private static StringHandler stringHandler;
  private static String originalString;

  @BeforeAll
  public static void initTestClass() {
    stringHandler = new StringHandler();
    originalString = "Hello World";
  }

  @Test
  public void checkWordIsPalindromeTest() {
    assertTrue(stringHandler.checkIfWordIsPalindrome("saippuakivikauppias"));
  }

  @Test
  public void checkWordIsNotPalindromeTest() {
    assertFalse(stringHandler.checkIfWordIsPalindrome("test"));
  }

  @Test
  public void removeEverythingExceptFirstOccurrenceOfDesiredSubstringTest() {
    String realResultOfMethod =
        stringHandler.removeEverythingExceptFirstOccurrenceOfDesiredSubstring(
            originalString, "Hello");
    assertEquals("Hello", realResultOfMethod);
  }

  // This test checks the method that removes all letters "l" from the phrase "Hello World". Each
  // letter is removed as a character.
  @Test
  public void removeEveryCharOccurrenceTest() {
    assertEquals("Heo Word", stringHandler.removeEveryCharOccurrence(originalString, 'l'));
  }

  // This test checks the method that removes all letters "l" from the phrase "Hello World". Each
  // letter is removed as a substring.
  @Test
  public void removeEverySubstringOccurrenceTest() {
    assertEquals("Heo Word", stringHandler.removeEverySubstringOccurrence(originalString, "l"));
  }

  @Test
  public void replaceEverySubstringOccurrenceTest() {
    assertEquals(
        "Hellq Wqrld", stringHandler.replaceEverySubstringOccurrence(originalString, "o", "q"));
  }

  @Test
  public void getAllWordsWithNumberOfLettersInEachTest() {
    Map<String, Integer> resultWordMap =
        stringHandler.getAllWordsWithNumberOfLettersInEach(originalString);
    for (Map.Entry<String, Integer> e : resultWordMap.entrySet()) {
      assertEquals(e.getKey().length(), e.getValue());
    }
  }

  @Test
  public void getSongTest() {
    assertEquals(
        "\n17 little bugs in the code,\n"
            + "17 little bugs in the code.\n"
            + "Take one down, patch it around 13 little bugs in the code.\n"
            + "\n13 little bugs in the code,\n"
            + "13 little bugs in the code.\n"
            + "Take one down, patch it around 6 little bugs in the code.\n",
        stringHandler.getSong(17, 2));
  }
}
