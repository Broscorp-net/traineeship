package net.broscorp.n_strings;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.List;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

class StringsTest {

  private static Strings strings;

  @BeforeAll
  public static void initialization() {
    strings = new Strings();
  }

  @Test
  void testIsPalindrome() {
    String palindrome = "madam";
    assertEquals(true, strings.isPalindrome(palindrome));
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
  void LinesNumberCheckout() {
    int coupletsNumber = 5;
    int linesInOneCouplet = 3;
    int bugsNumber = 1;
    int linesSumm = coupletsNumber * linesInOneCouplet;
    String[] totalLines = strings.makeSong(coupletsNumber, bugsNumber).split("\n");
    assertEquals(linesSumm, totalLines.length);
  }

  @Test
  void BugsNumberCheckout() {
    int bugsNumber = 10;
    int coupletsNumber = 15;
    String s = strings.makeSong(coupletsNumber, bugsNumber);
    String[] lines = s.split("\n");
    String bugInThirdLine = lines[2].substring(31, (lines[2].length() - 1)); //exclude space
    String bugInFourthLine = lines[3].substring(0, (lines[3].length() - 2)); //exclude coma
    String bugInFifthLine = lines[4].substring(0, (lines[4].length() - 2));  // exclude dot
    assertEquals(bugInThirdLine, bugInFourthLine);
    assertEquals(bugInFourthLine, bugInFifthLine);
  }
}
