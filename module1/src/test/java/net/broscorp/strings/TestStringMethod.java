package net.broscorp.strings;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.util.Random;
import java.util.stream.Stream;

import org.junit.jupiter.api.Test;

public class TestStringMethod {

  private String mainWords = "Hello World";

  @Test
  public void palindromeTest() {
    assertTrue(isPalindrome("косок"));
  }

  @Test
  public void testForRemovingTheWordWorld() {
    assertEquals("Hello", leftOnlyHello(mainWords));
  }

  @Test
  public void testForRemovingTheLetterL() {
    assertEquals("Heo Word", deleteAllLettersLInString(mainWords));
  }

  @Test
  public void testToReplaceTheLetterOToQ() {
    assertEquals("Hellq Wqrld", replaceAllLettersOToQ(mainWords));
  }

  @Test
  public void testSplitWordsAndLetters() {
    String expectedString = "Слово Hello имеет - 5 букв."
        + " Слово World имеет - 5 букв. Количество слов - 2.";
    assertEquals(expectedString, numberOfLettersAndWords(mainWords));
  }

  @Test
  public void testingSong() {
    int numberOfBags = 50;
    int numberOfCouplet = 3;
    System.out.println(songAboutBugs(numberOfBags, numberOfCouplet));
    //assertEquals(numberOfCouplet * 24,
     //   splitWords(songAboutBugs(numberOfBags, numberOfCouplet)).length);
  }

  private boolean isPalindrome(String s) {
    int leftChar = 0;
    int rightChar = s.length() - 1;
    while (leftChar < rightChar) {
      if (s.charAt(leftChar) != s.charAt(rightChar)) {
        return false;
      }
      leftChar++;
      rightChar--;
    }
    return true;
  }

  private String leftOnlyHello(String string) {
    return string.replace("World", "").trim();
  }

  private String deleteAllLettersLInString(String string) {
    return string.replace("l", "");
  }

  private String replaceAllLettersOToQ(String string) {
    return string.replace("o", "q");
  }

  private String numberOfLettersAndWords(String string) {
    StringBuilder result = new StringBuilder();
    for (String str : splitWords(string)) {
      result.append("Слово ").append(str).append(" имеет - ")
          .append(str.length()).append(" букв. ");
    }
    return result.append("Количество слов - ")
        .append(splitWords(string).length).append(".").toString();
  }

  private String songAboutBugs(int numberOfBags, int numberOfCouplet) {
    StringBuilder song = new StringBuilder();
    Random random = new Random();
    for (int i = 0; i < numberOfCouplet; i++) {
      int m = 0;
      m = numberOfBags < 10
          ? 0 : numberOfBags - 10 + random.nextInt(20);
      song.append(numberOfBags).append(" little bugs in the code,\n")
          .append(numberOfBags).append(" little bugs in the code.\n")
          .append("Take one down, patch it around ")
          .append(m).append(" little bugs in the code.\n");
      numberOfBags = m;
    }
    return song.toString();
  }

  private String[] splitWords(String string) {
    return Stream.of(string).map(e -> e.replaceAll("[-+.^:,]","")).findAny().get().split(" ");
  }
}