package net.broscorp.strings;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

class StringManipulationTest {

  private static StringManipulation stringManipulation;
  private static String helloWorld;

  @BeforeAll
  static void setup() {
    stringManipulation = new StringManipulation();
    helloWorld = "Hello World";
  }

  @Test
  void isPalindrome() {
    Assertions.assertTrue(stringManipulation.isPalindrome("tenet"));
  }

  @Test
  void onlyHello() {
    String expected = stringManipulation.onlyHello(helloWorld);
    Assertions.assertEquals(expected, "Hello");
  }

  @Test
  void deleteLetterInWord() {
    String expected = stringManipulation.deleteLetterInWord(helloWorld, 'l');
    Assertions.assertEquals(expected,"Heo Word");
  }

  @Test
  void replaceLetterInWord() {
    String expected = stringManipulation.replaceLetterInWord(helloWorld, 'o', 'q');
    Assertions.assertEquals(expected, "Hellq Wqrld");
  }

  @Test
  void wordStatistic() {
    String expected = stringManipulation.wordStatistic(helloWorld);
    Assertions.assertEquals(expected, "Hello - 5 letters\n"
        + "World - 5 letters\n");
  }

  @Test
  void lyrics() {
    String expected = stringManipulation.lyrics(1, 1);
    Assertions.assertEquals(expected, "1 little bugs in the code, \n"
        + "1 little bugs in the code. \n"
        + "Take one down, patch it around -4 little bugs in the code.\n");
  }
}
