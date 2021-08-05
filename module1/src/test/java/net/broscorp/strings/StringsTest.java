package net.broscorp.strings;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.util.HashMap;
import java.util.Map;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

class StringsTest {

  private Strings strings;
  private String helloWorld;
  private Map<String, Integer> map;

  @BeforeEach
  void setup() {
    strings = new Strings();
    helloWorld = "Hello World";
    map = new HashMap<>();
  }

  @ParameterizedTest
  @ValueSource(strings = {"Redivider", "deiFied", "CIVIC", "radar", "level", "rotor", "kayak",
      "reviver", "racecar", "madam", "refer"})
  void testIfPalindromeCaseInsensitive(String string) {
    assertTrue(strings.isPalindrome(string));
  }

  @Test
  void testShouldLeaveOnlyFirstWord() {
    assertEquals("Hello", strings.leaveOnlyFirstWord(helloWorld));
  }

  @Test
  void testShouldLeaveOnlyHello() {
    String helloWorld = "Hello World,  Hello all, hello little thing";
    String expected = "Hello" + "\n" + "Hello" + "\n" + "hello" + "\n";
    assertEquals(expected, strings.leaveOnlyHello(helloWorld));
  }

  @Test
  void testShouldRemoveL() {
    String expected = "Heo Word";
    assertEquals(expected, strings.removeL(helloWorld));
  }

  @Test
  void testShouldReplaceOWithQ() {
    String expected = "Hellq Wqrld";
    assertEquals(expected, strings.replaceOWithQ(helloWorld));
  }

  @Test
  void testShouldComposeListOfWordsAndTheirCount() {
    map.put("hello", 1);
    map.put("world", 1);
    assertEquals(map, strings.returnListOfWordsAndTheirCount(helloWorld));
  }

  @Test
  void testShouldComposeListOfWordsAndNumberOfLettersInEach() {
    map.put("hello", 5);
    map.put("world", 5);
    assertEquals(map, strings.returnListOfWordsAndNumberOfLettersInEach(helloWorld));
  }

  @Test
  void testShouldReturnBugSongLyricsOfTwoVerses() {
    System.out.println(strings.bugLyrics(10, 3));
  }

  @Test
  void testBugLyricsShouldReturnEmptyStringIfZeroArguments() {
    String s = "";
    assertEquals(s, strings.bugLyrics(0, 0));
  }

  @Test
  void testBugLyricsShouldReturnEmptyStringIfNegativeArguments() {
    String s = "";
    assertEquals(s, strings.bugLyrics(-56, -100));
  }
}