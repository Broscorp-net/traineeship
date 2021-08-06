package net.broscorp.strings;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.Test;

public class StringServiceTest {

  @Test
  public void shouldReturnTrueIfWordIsPalindrome() {
    //given
    StringService service = new StringService();
    //when
    boolean result = service.isPalindrome("repaper");
    //then
    assertTrue(result);
  }

  @Test
  public void shouldReturnFalseIfWordIsNotPalindrome() {
    //given
    StringService service = new StringService();
    //when
    boolean result = service.isPalindrome("apple");
    //then
    assertFalse(result);
  }

  @Test
  public void shouldReturnFalseIfWordIsEmpty() {
    //given
    StringService service = new StringService();
    //when
    boolean result = service.isPalindrome("");
    //then
    assertFalse(result);
  }

  @Test
  public void shouldRemoveWord() {
    //given
    StringService service = new StringService();
    //when
    String result = service.removeWord("Hello World", "World");
    //then
    assertEquals("Hello", result);
  }

  @Test
  public void shouldRemoveLettersInString() {
    //given
    StringService service = new StringService();
    //when
    String result = service.removeLetter("Hello World", 'l');
    //then
    assertEquals("Heo Word", result);
  }

  @Test
  public void shouldReturnOriginalStringIfNoLettersAreFound() {
    //given
    StringService service = new StringService();
    //when
    String result = service.removeLetter("Hello World", 'q');
    //then
    assertEquals("Hello World", result);
  }

  @Test
  public void shouldReplaceSomeLettersToOther() {
    //given
    StringService service = new StringService();
    //when
    String result = service.replaceLetter("Hello World", 'o', 'q');
    //then
    assertEquals("Hellq Wqrld", result);
  }

  @Test
  public void shouldReturnOriginalStringIfNoOldLettersAreFound() {
    //given
    StringService service = new StringService();
    //when
    String result = service.replaceLetter("Hello World", 'u', 'A');
    //then
    assertEquals("Hello World", result);
  }

  @Test
  public void shouldPrintWordsWithItsSize() {
    //given
    StringService service = new StringService();
    //when
    service.printNumberOfCharacters("Hello World");
    //then
    /*
      Hello contains 5 letters;
      World contains 5 letters;
     */
  }

  @Test
  public void shouldReturnSongText() {
    //given
    StringService service = new StringService();
    String expectedSong = "10 little bugs in the code,\n"
        + "10 little bugs in the code.\n"
        + "Take one down, patch it around 6 little bugs in the code.\n"
        + "6 little bugs in the code,\n"
        + "6 little bugs in the code.\n"
        + "Take one down, patch it around 4 little bugs in the code.\n"
        + "4 little bugs in the code,\n"
        + "4 little bugs in the code.\n"
        + "Take one down, patch it around -1 little bugs in the code.\n";
    //when
    String actualSong = service.getSong(10, 3);
    //then
    assertEquals(expectedSong, actualSong);
  }

  @Test
  void shouldReturnEmptyStringIfZeroVerses() {
    //given
    StringService service = new StringService();
    //when
    String actualSong = service.getSong(10, 0);
    //then
    assertEquals("", actualSong);
  }

}
