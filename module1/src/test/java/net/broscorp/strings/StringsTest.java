package net.broscorp.strings;

import java.util.ArrayList;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class StringsTest {


  @Test
  void getPalindromeToSomeText() {
    String palindrome = "tattarrattat";
    Assertions.assertTrue(StringExample.getPalindrome(palindrome));
  }

  @Test
  void getFirstWordFromString() {
    String testString = "Hello world";
    String actualString = "Hello";
    Assertions.assertEquals(StringExample.getFirstWordFromString(testString),
        actualString);
  }

  @Test
  void deleteSomeCharFromString() {
    String testString = "Hello world";
    char deletedChar = 'l';
    Assertions.assertEquals(StringExample.deleteSomeCharFromString(testString, deletedChar),
        "Heo word");
  }

  @Test
  void replaceSomeCharacter() {
    String testString = "Hello world";
    char oldChar = 'l';
    char newChar = 'q';
    Assertions.assertEquals(StringExample.replaceSomeCharacter(testString, oldChar, newChar),
        "Heqqo worqd");
  }

  @Test
  void getWordAndItsAmountChar() {
    String testString = "Hello world";
    ArrayList<String> actualArray = new ArrayList<>();
    actualArray.add("\"" + "Hello" + "\"" + " its length = " + "Hello".length());
    actualArray.add("\"" + "world" + "\"" + " its length = " + "world".length());
    Assertions.assertEquals(StringExample.getWordAndItsAmountChar(testString), actualArray);
  }

  @Test
  void songAboutBugs(){
    int bugsAmount = 4;
    int coupletAmount = 2;
    int lengthSongString = coupletAmount == 1 ? 116 : 115;
    Assertions.assertEquals(coupletAmount * lengthSongString, StringExample.songAboutBugs(bugsAmount, coupletAmount).length());
  }

}
