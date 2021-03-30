package net.broscorp.strings;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;


class PhilologistTest {

  private Philologist philologist;

  @BeforeEach
  void setUp() {
    philologist = new Philologist();
  }

  @AfterEach
  void tearDown() {
  }

  @Test
  @DisplayName("Should return true from isPalindrome")
  void shouldReturnTrueIsPalindrome() {
    String str = "Was it a cat I saw";
    assertTrue(philologist.isPalindrome(str));
  }

  @Test
  @DisplayName("Should return false from isPalindrome")
  void shouldReturnFalseIsPalindrome() {
    String str = "Hello World";
    assertFalse(philologist.isPalindrome(str));
  }

  @Test
  @DisplayName("Should cut word in cutWord")
  void shouldCutWord() {
    String str = "Hello World";
    String cutStr = "World";
    assertEquals("Hello", philologist.cutWord(str, cutStr));
  }

  @Test
  @DisplayName("Should can not cut word in cutWord")
  void shouldNotCutWord() {
    String str = "Hello World";
    String cutStr = "Word";
    assertEquals("Hello World", philologist.cutWord(str, cutStr));
  }

  @Test
  @DisplayName("Should return null from cutWord")
  void shouldReturnNullCutWord() {
    String str = null;
    String cutStr = "World";
    assertNull(philologist.cutWord(str, cutStr));
  }


  @Test
  @DisplayName("Should delete character in deleteChar")
  void shouldDeleteChar() {
    String str = "Hello World";
    char delCh = 'l';
    assertEquals("Heo Word", philologist.deleteChar(str, delCh));
  }

  @Test
  @DisplayName("Should can not delete character in deleteChar")
  void shouldNotDeleteChar() {
    String str = "Hello World";
    char delCh = 'z';
    assertEquals("Hello World", philologist.deleteChar(str, delCh));
  }

  @Test
  @DisplayName("Should return null from deleteChar")
  void shouldReturnNulDeleteChar() {
    String str = null;
    char delCh = 'l';
    assertNull(philologist.deleteChar(str, delCh));
  }

  @Test
  @DisplayName("Should replace character in replaceChar")
  void shouldReplaceChar() {
    String str = "Hello World";
    char firstCh = 'o';
    char secondCh = 'q';
    assertEquals("Hellq Wqrld", philologist.replaceChar(str, firstCh, secondCh));
  }

  @Test
  @DisplayName("Should can not replace character in replaceChar")
  void shouldNotReplaceChar() {
    String str = "Hello World";
    char firstCh = 'z';
    char secondCh = 'q';
    assertEquals("Hello World", philologist.replaceChar(str, firstCh, secondCh));
  }

  @Test
  @DisplayName("Should return null from replaceChar")
  void shouldReturnNullReplaceChar() {
    String str = null;
    char firstCh = 'o';
    char secondCh = 'q';
    assertNull(philologist.replaceChar(str, firstCh, secondCh));
  }

  @Test
  @DisplayName("Should split string for splitString")
  void shouldSplitString() {
    String str = "Hello World";
    String[] strings = {"Hello", "World"};
    assertTrue(Arrays.equals(strings, philologist.splitString(str)));
  }

  @Test
  @DisplayName("Should can not split string for splitString")
  void shouldNotSplitString() {
    String str = "HelloWorld";
    String[] strings = {"Hello", "World"};
    assertFalse(Arrays.equals(strings, philologist.splitString(str)));
  }

  @Test
  @DisplayName("Should return null from splitString")
  void shouldReturnNullSplitString() {
    String str = null;
    String[] strings = {"Hello", "World"};
    assertNull(philologist.splitString(str));
  }

  @Test
  @DisplayName("Should return the list of stings")
  public void shouldReturnWordAndLength() {
    String[] nullString = null;
    String[] baseStrings = {"Hello", "World"};

    List<String> expectedList = new ArrayList<>();
    expectedList.add("Hello 5");
    expectedList.add("World 5");

    List<String> actualList = philologist.getWordWithLength(baseStrings);

    assertNull(philologist.getWordWithLength(nullString));
    assertEquals(expectedList, actualList);
  }

  @Test
  @DisplayName("Should return string from randomSong")
  void shouldReturnRandomSong() {
    int n = 3;
    int m = 2;
    String expected = "3 little bugs in the code,\n"
        + "3 little bugs in the code.\n"
        + "Take one down, patch it around 4 little bugs in the code.\n"
        + "4 little bugs in the code,\n"
        + "4 little bugs in the code.\n"
        + "Take one down, patch it around 10 little bugs in the code.\n";
    String actual = philologist.randomSong(n, m);
    assertEquals(expected, actual);
  }


  @Test
  @DisplayName("Should return empty from randomSong")
  void shouldReturnEmptyRandomSong() {
    int n = 3;
    int m = -2;
    String expected = "";
    assertEquals(expected, philologist.randomSong(n, m));
  }

}