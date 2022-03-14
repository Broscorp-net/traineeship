package net.broscorp.strings;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.Test;

public class MyStringsTest {

  @Test
  public void checjIfPalindromeTest() {
    MyStrings obj = new MyStrings();
    assertTrue(obj.checkIfPalindrome("madam"));
    assertFalse(obj.checkIfPalindrome("monsieur"));
  }

  @Test
  public void cutWorldTest() {
    MyStrings obj = new MyStrings();
    assertTrue(obj.cutWorld("Hello World").equals("Hello"));
  }

  @Test
  public void cutL() {
    MyStrings obj = new MyStrings();
    assertTrue(obj.cutL("Hello World").equals("Heo Word"));
  }

  @Test
  public void replaceO() {
    MyStrings obj = new MyStrings();
    assertTrue(obj.replaceO("Hello World").equals("Hellq Wqrld"));
  }

  @Test
  public void countCharactersTest() {
    MyStrings obj = new MyStrings();
    assertTrue(
        obj.countCharacters("Hello World").equals("Hello: 5 characters\nWorld: 5 characters\n"));
  }

  @Test
  public void composeTest() {
    MyStrings obj = new MyStrings();
    String song = obj.compose(5, 6);
    String preSong = "5 little bugs in a code,\n" + "5 little bugs in a code.\n"
        + "Take one down, patch it around 13 little bugs in a code.\n"
        + "13 little bugs in a code,\n" + "13 little bugs in a code.\n"
        + "Take one down, patch it around 11 little bugs in a code.\n"
        + "11 little bugs in a code,\n" + "11 little bugs in a code.\n"
        + "Take one down, patch it around 12 little bugs in a code.\n"
        + "12 little bugs in a code,\n" + "12 little bugs in a code.\n"
        + "Take one down, patch it around 17 little bugs in a code.\n"
        + "17 little bugs in a code,\n" + "17 little bugs in a code.\n"
        + "Take one down, patch it around 20 little bugs in a code.\n"
        + "20 little bugs in a code,\n" + "20 little bugs in a code.\n"
        + "Take one down, patch it around 17 little bugs in a code.\n";
    //System.out.println(song);
    assertTrue(song.equals(preSong));
  }
}
