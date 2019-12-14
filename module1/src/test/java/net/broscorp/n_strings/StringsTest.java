package net.broscorp.n_strings;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

class StringsTest {

  private static Strings strings;

  @BeforeAll
  public static void initialization() {
    strings = new Strings();
  }

  @Test
  void testIsPalindrome() {
    String doesItPalindrome = "madam";
    boolean processedWord = strings.isPalindrome(doesItPalindrome);
    boolean yesPalindrome = true;
    assertEquals(yesPalindrome, processedWord);
  }

  @Test
  void testWordDeletion() {
    String word = "Hello words";
    String processedWord = strings.wordDeletion(word);
    String expectedWord = "Hello";
    assertEquals(expectedWord, processedWord);
  }

  @Test
  void testLetterDeletion() {
    String word = "Hello word";
    String processedWord = strings.letterDeletion(word);
    String expectedWord = "Heo word";
    assertEquals(expectedWord, processedWord);
  }

  @Test
  void testLettersChaneging() {
    String word = "Hello word";
    String processedWord = strings.lettersChaneging(word);
    String expectedWord = "Hellq wqrd";
    assertEquals(expectedWord, processedWord);
  }

  @Test
  void testWordsLetters() {
    String word = "Hello word";
    List<String> actualList = strings.wordsLetters(word);
    int expectedListSize = 2;
    assertEquals(expectedListSize, actualList.size());
  }

  @Test
  void testMakeSongSumOfLinesCheckout() {
    int coupletsNumber = 5;
    int linesInOneCouplet = 3;
    int bugsNumber = 1;
    int sumOfLinesExpected = coupletsNumber * linesInOneCouplet;
    String[] totalSongLines = strings.makeSong(coupletsNumber, bugsNumber).split("\n");
    assertEquals(sumOfLinesExpected, totalSongLines.length);
  }

  @Test
  void testMakeSongBugsCheckout() {
    int bugsNumber = 2;
    int coupletsNumber = 2;
    String s = strings.makeSong(coupletsNumber, bugsNumber);
    String[] lines = s.split("\n");
    char bugInThirdLine = lines[2].charAt(31);
    char bugInFourthLine = lines[3].charAt(0);
    char bugInFifthLine = lines[4].charAt(0);
    assertEquals(bugInThirdLine, bugInFourthLine);
    assertEquals(bugInFourthLine, bugInFifthLine);
  }


}
