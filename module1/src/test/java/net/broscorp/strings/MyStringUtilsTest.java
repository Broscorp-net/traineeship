package net.broscorp.strings;

import java.util.HashMap;
import java.util.Map;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class MyStringUtilsTest {

  private final MyStringUtils utils = new MyStringUtils();

  @Test
  public void testIsPalindrome() {
    String input = "Madam";
    String input2 = "   level ";

    Assertions.assertTrue(utils.isPalindrome(input));
    Assertions.assertTrue(utils.isPalindrome(input2));
  }

  @Test
  public void testIsNotPalindrome() {
    String input = "paLiNdrome";

    Assertions.assertFalse(utils.isPalindrome(input));
  }

  @Test
  public void testIsPalindromeEmptyString() {
    String input = "";

    Assertions.assertFalse(utils.isPalindrome(input));
  }

  @Test
  public void testReturnValueIfContains() {
    String input = "Hello World";
    String expectedResult = "Hello";

    String actualResult = utils.returnValueIfContains(input, "Hello");

    Assertions.assertEquals(expectedResult, actualResult);
  }

  @Test
  public void testReturnValueIfContainsReturnsNull() {
    String input = "Hello World";

    String actualResult = utils.returnValueIfContains(input, "Bird");

    Assertions.assertNull(actualResult);
  }

  @Test
  public void testRemoveAllLetters() {
    String input = "I will come and meet you at Lilly's house";
    String expectedResult = "I wi come and meet you at Liy's house";

    String actualResult = utils.removeAllLetters(input, 'l');

    Assertions.assertEquals(expectedResult, actualResult);
  }

  @Test
  public void testReplaceOToQ() {
    String input = "I will come and meet you at Lilly's house";
    String expectedResult = "I will cqme and meet yqu at Lilly's hquse";

    String actualResult = utils.replaceOToQ(input);

    Assertions.assertEquals(expectedResult, actualResult);
  }

  @Test
  public void testGetWordsLengths() {
    String input = "I will come and meet you at Lilly's house";
    Map<String, Integer> expectedResult = new HashMap<>();
    expectedResult.put("I", 1);
    expectedResult.put("will", 4);
    expectedResult.put("come", 4);
    expectedResult.put("and", 3);
    expectedResult.put("meet", 4);
    expectedResult.put("you", 3);
    expectedResult.put("at", 2);
    expectedResult.put("Lilly's", 7);
    expectedResult.put("house", 5);

    Map<String, Integer> actualResult = utils.getWordsLengths(input);

    Assertions.assertEquals(expectedResult, actualResult);
  }

  @Test
  public void testCreateSong() {
    String expectedResult = "10 little bugs in the code, \n"
        + "10 little bugs in the code. \n"
        + "Take one down, patch it around 6 little bugs in the code.\n\n"
        + "6 little bugs in the code, \n"
        + "6 little bugs in the code. \n"
        + "Take one down, patch it around 4 little bugs in the code.\n\n"
        + "4 little bugs in the code, \n"
        + "4 little bugs in the code. \n"
        + "Take one down, patch it around -1 little bugs in the code.\n\n";

    String actualResult = utils.createSong(10, 3);

    Assertions.assertEquals(expectedResult, actualResult);
  }
}
